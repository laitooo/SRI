package zxc.laitooo.sri;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

public class ProfileActivity extends AppCompatActivity {

    UserData user;
    Fragment fragment_reputaion;
    Fragment fragment_bio;
    FragmentManager manager;

    String LastSeen,Bio;
    int Level,Following,Followers,Contents;
    double Points;


    TextView current_reputation,votes_limit,current_points,next_level,points_next_level;
    TextView UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_profile);
        setSupportActionBar(toolbar);

        final Button b1 = (Button)findViewById(R.id.proBtnInfo);
        final Button b2 = (Button)findViewById(R.id.proBtnPublications);
        current_reputation = (TextView) findViewById(R.id.rep_level);
        current_points = (TextView) findViewById(R.id.rep_points);
        votes_limit = (TextView) findViewById(R.id.rep_limit_votes);
        next_level = (TextView) findViewById(R.id.rep_next_level);
        points_next_level = (TextView) findViewById(R.id.rep_points_next_level);
        ImageView profile = (ImageView) findViewById(R.id.profile_image);
        UserName = (TextView)findViewById(R.id.username);





        user = new UserData(ProfileActivity.this);
        UserName.setText(user.getUserName());


        if (user.getImageUrl().equals("no_profile")){
            Picasso.with(ProfileActivity.this)
                    .load(R.drawable.boy)
                    .skipMemoryCache()
                    .transform(new CircleTransformation())
                    .into(profile);
        }else {
            Picasso.with(ProfileActivity.this)
                    .load(user.getImageUrl())
                    .skipMemoryCache()
                    .transform(new CircleTransformation())
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(profile);
        }


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.app_bar);

        manager = getSupportFragmentManager();
        Fragment f = manager.findFragmentById(R.id.proFragment);



        Map<String,String> map = new HashMap<>();
        map.put("id_user", String.valueOf(user.getId()));
        NetworkTask task = new NetworkTask(true, Constants.GET_REPUTATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    if (!object.getBoolean("error")){
                        Level = object.getInt("level");
                        LastSeen = object.getString("last_seen");
                        Following = object.getInt("following");
                        Followers = object.getInt("followers");
                        Contents = object.getInt("content");
                        Contents = object.getInt("content");
                        Bio = object.getString("bio");
                        Points = object.getDouble("points");

                        ReputationSystem system = new ReputationSystem(Points);
                        current_reputation.setText("Level " + Level);
                        votes_limit.setText(String.valueOf(system.getVotesLimit()));
                        current_points.setText(String.valueOf(Points));
                        next_level.setText("Level " + system.getNextLevel());
                        points_next_level.setText(String.valueOf(system.getPointsNextLevel()));

                    }else {
                        Toast.makeText(ProfileActivity.this, object.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                    fragment_reputaion = manager.findFragmentById(R.id.R1);

                    if(fragment_reputaion == null){
                        fragment_reputaion = profileReputationFragment.makeFragment(ProfileActivity.this,Level,
                                Contents,Following,Followers,Points,LastSeen);
                        manager.beginTransaction()
                                .add(R.id.R1,fragment_reputaion)
                                .commit();
                    }

                    fragment_bio = manager.findFragmentById(R.id.R3);

                    if (fragment_bio == null){
                        fragment_bio = ProfileBioFragment.makeBioFragment(ProfileActivity.this,Bio);
                        manager.beginTransaction()
                                .add(R.id.R3,fragment_bio)
                                .commit();
                    }

                } catch (JSONException e) {
                    Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },ProfileActivity.this,map);
        task.executeTask();



        if(f == null){
            f = ProfileInfoFragment.makeFragment(ProfileActivity.this);
            manager.beginTransaction()
                    .add(R.id.proFragment,f)
                    .commit();
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(ContextCompat.getColor(ProfileActivity.this,R.color.colorPrimaryDark));
                b2.setBackgroundColor(ContextCompat.getColor(ProfileActivity.this,R.color.icon));
                manager.beginTransaction()
                        .replace(R.id.proFragment,new ProfileInfoFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackgroundColor(ContextCompat.getColor(ProfileActivity.this,R.color.colorPrimaryDark));
                b1.setBackgroundColor(ContextCompat.getColor(ProfileActivity.this,R.color.icon));
                manager.beginTransaction()
                        .replace(R.id.proFragment,new ProfilePublicationFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // new_language you specify actionBar parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.changePassword){
            MyDialog dialogss = new MyDialog(ProfileActivity.this,2);
            dialogss.show(getFragmentManager(), "My Dialog");
        }else if (id == R.id.updateEmail){
            MyDialog dialogss = new MyDialog(ProfileActivity.this,1);
            dialogss.show(getFragmentManager(),"My Dialog");
        }else if (id == R.id.deactiveAccount){
            MyDialog dialogss = new MyDialog(ProfileActivity.this,3);
            dialogss.show(getFragmentManager(), "My Dialog");
        }else if (id == R.id.changePicture){
            Toast.makeText(getApplicationContext(),"Changing Profile Picture",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void fragmentToActivityReputation(){
        manager.beginTransaction()
                .replace(R.id.R1,new EditProfileFragment())
                .addToBackStack(null)
                .commit();
    }

    public void fragmentToActivityEditProfile(String new_username){
        manager.beginTransaction()
                .replace(R.id.R1,profileReputationFragment.makeFragment(ProfileActivity.this,Level,
                        Contents,Following,Followers,Points,LastSeen))
                .addToBackStack(null)
                .commit();
        UserName.setText(new_username);
    }

    public void fragmentToActivityBio(){
        manager.beginTransaction()
                .replace(R.id.R3,new EditBioFragment())
                .addToBackStack(null)
                .commit();
    }

    public void fragmentToActivityEditBio(String bio){
        manager.beginTransaction()
                .replace(R.id.R3,ProfileBioFragment.makeBioFragment(ProfileActivity.this,bio))
                .addToBackStack(null)
                .commit();
    }
}
