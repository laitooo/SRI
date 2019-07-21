package zxc.laitooo.sri;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.InfoLists;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

/**
 * Created by Zizo on 1/7/2018.
 */
public class OtherPersonProfileInfoFragment extends Fragment {


    ArrayList<String> listLanguages;
    ArrayList<String> listFields;
    FieldsAdapter adapterFields;
    LanguagesAdapter adapterLanguages;

    int degree_e,country_e;
    String city_e,website_e,job_e;


    int ID;

    public OtherPersonProfileInfoFragment() {
    }

    @SuppressLint("ValidFragment")
    public OtherPersonProfileInfoFragment(int ID) {
        this.ID = ID;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.other_person_profile_info,container,false);



        RecyclerView recyclerLanguage = (RecyclerView) v.findViewById(R.id.Languages);
        listLanguages = new ArrayList<>();
        adapterLanguages = new LanguagesAdapter(listLanguages,getActivity());
        recyclerLanguage.setAdapter(adapterLanguages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerLanguage.setLayoutManager(linearLayoutManager);




        RecyclerView recyclerFields = (RecyclerView) v.findViewById(R.id.ResearcheFields);
        listFields = new ArrayList<>();
        adapterFields = new FieldsAdapter(listFields,getActivity());
        recyclerFields.setAdapter(adapterFields);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        recyclerFields.setLayoutManager(linearLayoutManager2);




        Map<String,String> map = new HashMap<>();
        map.put("id_user",String.valueOf(ID));

        NetworkTask task = new NetworkTask(true, Constants.GET_LANGUAGES, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray languages = object.getJSONArray("languages");
                    for (int i=0;i<languages.length();i++){
                        JSONObject lang = languages.getJSONObject(i);
                        listLanguages.add(lang.getString("language"));
                    }
                    adapterLanguages.notifyDataSetChanged();
                } catch (JSONException e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, getActivity(), map,false);
        task.executeTask();


        NetworkTask task2 = new NetworkTask(true, Constants.GET_FIELDS, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray fields = object.getJSONArray("fields");
                    for (int i=0;i<fields.length();i++){
                        JSONObject field = fields.getJSONObject(i);
                        listFields.add(field.getString("field"));
                    }
                    adapterFields.notifyDataSetChanged();
                } catch (JSONException e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, getActivity(), map,false);
        task2.executeTask();



        final TextView degree = (TextView)v.findViewById(R.id.degree);
        final TextView country = (TextView)v.findViewById(R.id.country);
        final TextView city = (TextView)v.findViewById(R.id.city);
        final TextView website = (TextView)v.findViewById(R.id.website);
        final TextView job = (TextView)v.findViewById(R.id.job);




        final Map<String, String> map3 = new HashMap<>();
        map3.put("id_user",String.valueOf(ID));
        NetworkTask task3 = new NetworkTask(true, Constants.GET_INFO, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    InfoLists infoList = new InfoLists();
                    if (!object.getBoolean("error")){
                        degree_e = object.getInt("degree");
                        country_e = object.getInt("country");
                        city_e = object.getString("city");
                        website_e = object.getString("website");
                        job_e = object.getString("job");

                        if (degree_e == 1)
                            degree.setText("Not selected");
                        else
                            degree.setText(infoList.degreeList.get(degree_e));


                        if (country_e == 1)
                            country.setText("Not selected");
                        else
                            country.setText(infoList.countryList.get(country_e));


                        if (city_e.equals(""))
                            city.setText("Empty");
                        else
                            city.setText(city_e);

                        if (website_e.equals(""))
                            website.setText("Empty");
                        else
                            website.setText(website_e);

                        if (job_e.equals(""))
                            job.setText("Empty");
                        else
                            job.setText(job_e);

                    }else {
                        Toast.makeText(getContext(), object.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, getActivity(), map3,false);
        task3.executeTask();



        return v;
    }


}
