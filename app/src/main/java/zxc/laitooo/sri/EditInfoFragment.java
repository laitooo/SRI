package zxc.laitooo.sri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.Date;
import zxc.laitooo.sri.data.InfoLists;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

/**
 * Created by Laitooo San on 13/06/2019.
 */

public class EditInfoFragment extends Fragment {

    int degree_selected;
    int country_selected;

    int degree_e,country_e;
    String city_e,website_e,job_e;



    public EditInfoFragment() {
    }

    @SuppressLint("ValidFragment")
    public EditInfoFragment(int degree_e, int country_e, String city_e, String website_e, String job_e) {
        this.degree_e = degree_e;
        this.country_e = country_e;
        this.city_e = city_e;
        this.website_e = website_e;
        this.job_e = job_e;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.edit_info, container, false);

        Spinner degree = (Spinner)v.findViewById(R.id.degree);
        Spinner country = (Spinner)v.findViewById(R.id.country);
        final EditText city = (EditText)v.findViewById(R.id.city);
        final EditText website = (EditText)v.findViewById(R.id.website);
        final EditText job = (EditText)v.findViewById(R.id.job);
        Button edit = (Button)v.findViewById(R.id.edit_button);
        Button cancel = (Button)v.findViewById(R.id.cancel_button);

        InfoLists infoLists = new InfoLists();

        final ArrayList<String> degreeList = infoLists.degreeList;

        ArrayAdapter adapterDegree = new ArrayAdapter(getContext(),R.layout.spinner_tag_text,
                degreeList);
        degree.setAdapter(adapterDegree);
        degree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                degree_selected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        final ArrayList<String> countryList = infoLists.countryList;


        ArrayAdapter adapterCountry = new ArrayAdapter(getContext(),R.layout.spinner_tag_text,
                countryList);
        country.setAdapter(adapterCountry);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country_selected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String, String> map = new HashMap<>();
                final UserData data = new UserData(getActivity());
                map.put("id_user",String.valueOf(data.getId()));
                map.put("degree", String.valueOf(degree_selected));
                map.put("country", String.valueOf(country_selected));
                map.put("city",city.getText().toString());
                map.put("website",website.getText().toString());
                map.put("job",job.getText().toString());
                NetworkTask task = new NetworkTask(true, Constants.UPDATE_INFO, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            if (!object.getBoolean("error")){
                                Toast.makeText(getContext(), object.getString("message"), Toast.LENGTH_LONG).show();
                                ProfileInfoFragment.fragmentToActivityEditInfo();
                            }else {
                                Toast.makeText(getContext(), object.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, getActivity(), map);
                task.executeTask();

            }
        });


        degree.setSelection(degree_e);
        country.setSelection(country_e);
        city.setText(city_e);
        website.setText(website_e);
        job.setText(job_e);



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileInfoFragment.fragmentToActivityEditInfo();
            }
        });
        return v;
    }
}
