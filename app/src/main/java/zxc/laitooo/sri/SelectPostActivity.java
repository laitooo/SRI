package zxc.laitooo.sri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.Date;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

public class SelectPostActivity extends AppCompatActivity {

    ArrayList<Comment> list;
    CommentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent m = getIntent();
        final int id = m.getIntExtra("id",0);
        final int id_user = m.getIntExtra("id_user",0);
        //String title = m.getStringExtra("title");
        final String username = m.getStringExtra("username");
        String time = m.getStringExtra("time");
        String content = m.getStringExtra("content");
        String image = m.getStringExtra("image");
        final int views = m.getIntExtra("views",0);

        getSupportActionBar().setTitle(username);


        //TextView questionTitle = (TextView)findViewById(R.id.post_title_selected);
        TextView questionName = (TextView)findViewById(R.id.post_name_selected);
        TextView questionTime = (TextView)findViewById(R.id.post_time_selected);
        TextView questionContent = (TextView)findViewById(R.id.post_content_selected);
        final TextView questionViews = (TextView)findViewById(R.id.post_views_selected);
        ImageView imageView = (ImageView)findViewById(R.id.post_image_selected);

        //questionTitle.setText(title);
        questionName.setText(username);
        questionTime.setText(time);
        questionContent.setText(content);
        questionViews.setText(views + " views");

        list = new ArrayList<>();
        adapter = new CommentsAdapter(list,getApplicationContext());

        if (image.equals("no_profile")){
            Picasso.with(SelectPostActivity.this)
                    .load(R.drawable.boy)
                    .skipMemoryCache()
                    .into(imageView);
        }else {
            Picasso.with(SelectPostActivity.this)
                    .load(image)
                    .skipMemoryCache()
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(imageView);
        }



        Map<String ,String> map = new HashMap<>();
        map.put("id_post",String.valueOf(id));
        NetworkTask task = new NetworkTask(true, Constants.SELECTED_POST_COMMENTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = object.getJSONArray("post_comments");
                    for (int i=0;i<array.length();i++){
                        JSONObject comment = array.getJSONObject(i);
                        list.add(new Comment(comment.getInt("id_post"),
                                comment.getInt("id_user"),comment.getString("image"),
                                comment.getString("username"),comment.getString("date"),
                                comment.getString("time"),comment.getString("content")));
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Toast.makeText(SelectPostActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, SelectPostActivity.this, map);
        task.executeTask();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.Recycler_posts);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        Button d = (Button)findViewById(R.id.send_comment);
        final EditText f = (EditText)findViewById(R.id.new_comment);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Content = f.getText().toString();
                if (!(Content.equals(""))) {
                    final Map<String, String> map = new HashMap<>();
                    map.put("id_post", String.valueOf(id));
                    map.put("id_user", String.valueOf(id_user));
                    map.put("content", Content);
                    map.put("date", Date.getDate());
                    map.put("time", Date.getTime());
                    NetworkTask task = new NetworkTask(true, Constants.ADD_POST_COMMENT, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            try {
                                JSONObject object = new JSONObject(s);
                                if (!object.getBoolean("error")) {
                                    UserData userData = new UserData(SelectPostActivity.this);
                                    list.add(list.size(), new Comment(id, id_user, userData.getImageUrl(),
                                            userData.getUserName(), Date.getDate(), Date.getTime(), Content));
                                    Toast.makeText(SelectPostActivity.this, object.getString("message"), Toast.LENGTH_LONG).show();
                                    adapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(SelectPostActivity.this, object.getString("message")
                                            , Toast.LENGTH_LONG).show();
                                }
                                adapter.notifyDataSetChanged();
                                /*new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        adapter.notifyDataSetChanged();
                                    }
                                }, 500);*/
                                adapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                Toast.makeText(SelectPostActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }, SelectPostActivity.this, map);
                    task.executeTask();
                } else {
                    Toast.makeText(getApplicationContext(), "All fields are required",
                            Toast.LENGTH_LONG).show();
                }
                adapter.notifyDataSetChanged();
                f.setText("");
            }
        });


        final Map<String, String> map2 = new HashMap<>();
        map.put("id_post", String.valueOf(id));
        map.put("id_user", String.valueOf(id_user));
        NetworkTask task2 = new NetworkTask(true, Constants.VIEW_POST, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    if (!object.getBoolean("error")){
                        questionViews.setText(object.getInt("views") + " views");
                    }
                } catch (JSONException e) {
                    //
                }
            }
        }, SelectPostActivity.this, map,false);
        task2.executeTask();

    }

}
