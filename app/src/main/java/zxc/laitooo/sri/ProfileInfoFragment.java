package zxc.laitooo.sri;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
 * Created by Zizo on 12/29/2017.
 */
public class ProfileInfoFragment extends Fragment{

    private static Context cont;

    static ArrayList<String> listLanguages;
    static ArrayList<String> listFields;
    static FieldsAdapter adapterFields;
    static LanguagesAdapter adapterLanguages;


    public static ProfileInfoFragment makeFragment(Context a){
        ProfileInfoFragment fragment = new ProfileInfoFragment();
        cont = a;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    String new_language;
    String asR;

    Fragment f;
    static FragmentManager manager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_info,container,false);




        manager = getChildFragmentManager();
        f = manager.findFragmentById(R.id.fragment_edit);
                if(f == null){
                    manager.beginTransaction()
                            .add(R.id.fragment_edit,new UserInfoFragment())
                            .commit();
                }


        InfoLists infoLists = new InfoLists();
        UserData userData = new UserData(getActivity());



        RecyclerView recyclerLanguage = (RecyclerView) v.findViewById(R.id.Languages);
        listLanguages = new ArrayList<>();
        adapterLanguages = new LanguagesAdapter(listLanguages,getActivity());
        recyclerLanguage.setAdapter(adapterLanguages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerLanguage.setLayoutManager(linearLayoutManager);




        /*Button add = (Button)v.findViewById(R.id.UserLevel);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_language = auto.getText().toString();
                auto.setText("");
                listLanguages.add(new_language);
                adapterLanguages.notifyDataSetChanged();
            }
        });*/



        RecyclerView recyclerFields = (RecyclerView) v.findViewById(R.id.ResearcheFields);
        listFields = new ArrayList<>();
        adapterFields = new FieldsAdapter(listFields,getActivity());
        recyclerFields.setAdapter(adapterFields);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        recyclerFields.setLayoutManager(linearLayoutManager2);




        Map<String,String> map = new HashMap<>();
        map.put("id_user",String.valueOf(userData.getId()));

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


        ImageButton add_lang = (ImageButton)v.findViewById(R.id.add_lang);
        add_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddLanguageDialog dialog = new AddLanguageDialog();
                dialog.show(getChildFragmentManager(), "My Dialog");
            }
        });

        ImageButton add_field = (ImageButton)v.findViewById(R.id.FieldField);
        add_field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFieldDialog dialog = new AddFieldDialog();
                dialog.show(getChildFragmentManager(), "My Dialog");
            }
        });

        return v;
    }

    public static void fragmentToActivityInfo(int de,int co,String ci,String we,String jo){
        manager.beginTransaction()
                .replace(R.id.fragment_edit,new EditInfoFragment(de,co,ci,we,jo))
                .addToBackStack(null)
                .commit();
    }

    public static void fragmentToActivityEditInfo(){
        manager.beginTransaction()
                .replace(R.id.fragment_edit,new UserInfoFragment())
                .addToBackStack(null)
                .commit();
    }

    public static void addLanguage(String lang){
        listLanguages.add(lang);
        adapterLanguages.notifyDataSetChanged();
    }


}
