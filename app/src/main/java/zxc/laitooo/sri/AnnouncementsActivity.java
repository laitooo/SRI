package zxc.laitooo.sri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

public class AnnouncementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        Context c = getApplicationContext();


        final ArrayList<Announcement> list = new ArrayList<>();
        //list.add(new Announcement("Announcement1","08:00","Are you actionBar qualified researcher? Do you have an interest in being one of the group of Sudanese researcher? Join Now!"));
        //list.add(new Announcement("Announcement2","11:00","No Lectures"));
        //list.add(new Announcement("Announcement3","14:00","Good GPA"));
        //list.add(new Announcement("Announcement4", "17:00", "Kill your self"));
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler2);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        final AnnouncementAdapter adapter = new AnnouncementAdapter(list,c);
        recyclerView.setAdapter(adapter);

        Toolbar t = (Toolbar)findViewById(R.id.toolba3);
        setSupportActionBar(t);

        ActionBar a = getSupportActionBar();
        a.setDisplayHomeAsUpEnabled(true);
        a.setTitle("Announcements");

        NetworkTask task = new NetworkTask(true, Constants.ALL_ANNOUNCEMENTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray announcements = object.getJSONArray("announcements");
                    for (int i=0;i<announcements.length();i++){
                        JSONObject ann = announcements.getJSONObject(i);
                        list.add(new Announcement(ann.getString("title"),ann.getString("date") +
                                " " + ann.getString("time"), ann.getString("content")));
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Toast.makeText(AnnouncementsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, AnnouncementsActivity.this, new HashMap<String, String>());
        task.executeTask();

    }

}