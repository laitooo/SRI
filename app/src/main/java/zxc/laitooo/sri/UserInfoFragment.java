package zxc.laitooo.sri;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.InfoLists;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

/**
 * Created by Laitooo San on 13/06/2019.
 */

public class UserInfoFragment extends Fragment{

    int degree_e,country_e;
    String city_e,website_e,job_e;

    public UserInfoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_info,container,false);
        final ImageButton edit = (ImageButton)v.findViewById(R.id.editInfo);
        final TextView degree = (TextView)v.findViewById(R.id.degree);
        final TextView country = (TextView)v.findViewById(R.id.country);
        final TextView city = (TextView)v.findViewById(R.id.city);
        final TextView website = (TextView)v.findViewById(R.id.website);
        final TextView job = (TextView)v.findViewById(R.id.job);


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileInfoFragment.fragmentToActivityInfo(1,1,"","","");
            }
        });

        final Map<String, String> map = new HashMap<>();
        final UserData data = new UserData(getActivity());
        map.put("id_user",String.valueOf(data.getId()));
        NetworkTask task = new NetworkTask(true, Constants.GET_INFO, new Response.Listener<String>() {
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

                        edit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ProfileInfoFragment.fragmentToActivityInfo(degree_e,country_e,city_e,
                                        website_e,job_e);
                            }
                        });

                    }else {
                        Toast.makeText(getContext(), object.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, getActivity(), map,false);
        task.executeTask();



        return v;
    }
}
