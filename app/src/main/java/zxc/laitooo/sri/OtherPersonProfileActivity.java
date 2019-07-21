package zxc.laitooo.sri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;
import zxc.laitooo.sri.picasso.CircleTransformation;
import zxc.laitooo.sri.reputation.ReputationSystem;

public class OtherPersonProfileActivity extends AppCompatActivity {

    boolean followed = false;
    TextView UserName;
    ImageButton follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_other_person_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_profile);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ImageView profile = (ImageView) findViewById(R.id.profile_image);
        UserName = (TextView)findViewById(R.id.username);
        follow = (ImageButton)findViewById(R.id.follow);
        final Button level = (Button)findViewById(R.id.UserLevel);
        final TextView reputation = (TextView)findViewById(R.id.profile_reputation);
        final TextView lastseen = (TextView)findViewById(R.id.lastseen);
        final TextView following = (TextView)findViewById(R.id.following);
        final TextView followers = (TextView)findViewById(R.id.followers);
        final TextView contents = (TextView)findViewById(R.id.contents);
        final TextView bio = (TextView)findViewById(R.id.proBioContent);



        Intent i = getIntent();
        final int ID_USER = i.getIntExtra("id",0);
        final String USER_NAME = i.getStringExtra("username");
        String PROFILE = i.getStringExtra("image");


        UserName.setText(USER_NAME);

        if (PROFILE.equals("no_profile")){
            Picasso.with(OtherPersonProfileActivity.this)
                    .load(R.drawable.boy)
                    .skipMemoryCache()
                    .transform(new CircleTransformation())
                    .into(profile);
        }else {
            Picasso.with(OtherPersonProfileActivity.this)
                    .load(PROFILE)
                    .skipMemoryCache()
                    .transform(new CircleTransformation())
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(profile);
        }


        Map<String,String> map = new HashMap<>();
        map.put("id_user", String.valueOf(ID_USER));
        NetworkTask task = new NetworkTask(true, Constants.GET_REPUTATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    if (!object.getBoolean("error")){
                        level.setText("Level " + String.valueOf(object.getInt("level")));
                        lastseen.setText(object.getString("last_seen"));
                        following.setText(String.valueOf(object.getInt("following")));
                        followers.setText(String.valueOf(object.getInt("followers")));
                        contents.setText(String.valueOf(object.getInt("content")));
                        if (!object.getString("bio").equals(""))
                            bio.setText(object.getString("bio"));
                        else
                            bio.setText("No bio");
                        reputation.setText(String.valueOf(object.getDouble("points")));

                    }else {
                        Toast.makeText(OtherPersonProfileActivity.this, object.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(OtherPersonProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },OtherPersonProfileActivity.this,map);
        task.executeTask();


        final UserData userData = new UserData(OtherPersonProfileActivity.this);

        Map<String,String> map2 = new HashMap<>();
        map2.put("id_user",String.valueOf(userData.getId()));
        map2.put("id_following", String.valueOf(ID_USER));
        NetworkTask task2 = new NetworkTask(true, Constants.IS_FOLLOWING, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    if (!object.getBoolean("error")){
                        if (object.getBoolean("isFollowing")){
                            follow.setImageResource(android.R.drawable.ic_delete);
                            followed = true;
                        }else {
                            follow.setImageResource(android.R.drawable.ic_input_add);
                            followed = false;
                        }
                        follow.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Map<String,String> map4 = new HashMap<>();
                                map4.put("id_user", String.valueOf(userData.getId()));
                                map4.put("id_following", String.valueOf(ID_USER));
                                if (!followed) {
                                    NetworkTask task4 = new NetworkTask(true, Constants.FOLLOW,
                                            new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String s) {
                                            try {
                                                JSONObject object = new JSONObject(s);
                                                if (!object.getBoolean("error")){
                                                    follow.setImageResource(android.R.drawable.ic_delete);
                                                    followed = true;
                                                    Toast.makeText(OtherPersonProfileActivity.this,
                                                            "You followed " + USER_NAME,Toast.LENGTH_SHORT).show();
                                                }else {
                                                    Toast.makeText(OtherPersonProfileActivity.this,
                                                            object.getString("message"), Toast.LENGTH_SHORT).show();
                                                }
                                            } catch (JSONException e) {
                                                Toast.makeText(OtherPersonProfileActivity.this,
                                                        e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    },OtherPersonProfileActivity.this,map4,false);
                                    task4.executeTask();
                                }else {
                                    NetworkTask task4 = new NetworkTask(true, Constants.UNFOLLOW,
                                            new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String s) {
                                            try {
                                                JSONObject object = new JSONObject(s);
                                                if (!object.getBoolean("error")){
                                                    follow.setImageResource(android.R.drawable.ic_input_add);
                                                    followed = false;
                                                    Toast.makeText(OtherPersonProfileActivity.this,
                                                            "You unfollowed " + USER_NAME,Toast.LENGTH_SHORT).show();
                                                }else {
                                                    Toast.makeText(OtherPersonProfileActivity.this, object.getString("message"), Toast.LENGTH_SHORT).show();
                                                }
                                            } catch (JSONException e) {
                                                Toast.makeText(OtherPersonProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    },OtherPersonProfileActivity.this,map4,false);
                                    task4.executeTask();
                                    follow.setImageResource(android.R.drawable.ic_input_add);
                                    followed = false;
                                }
                            }
                        });
                    }else {
                        Toast.makeText(OtherPersonProfileActivity.this, object.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(OtherPersonProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },OtherPersonProfileActivity.this,map2,false);
        task2.executeTask();



        final FragmentManager manager = getSupportFragmentManager();
        Fragment f = manager.findFragmentById(R.id.proFragment);

        if(f == null){
            f = new OtherPersonProfileInfoFragment(ID_USER);
            manager.beginTransaction()
                    .add(R.id.proFragment,f)
                    .commit();
        }

        final Button b1 = (Button)findViewById(R.id.proBtnInfo);
        final Button b2 = (Button)findViewById(R.id.proBtnPublications);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                b2.setBackgroundColor(getResources().getColor(R.color.icon));
                manager.beginTransaction()
                        .replace(R.id.proFragment, new OtherPersonProfileInfoFragment(ID_USER))
                        .addToBackStack(null)
                        .commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                b1.setBackgroundColor(getResources().getColor(R.color.icon));
                manager.beginTransaction()
                        .replace(R.id.proFragment, new ProfilePublicationFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }


}
