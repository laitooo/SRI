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

import co.lujun.androidtagview.TagContainerLayout;
import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.Date;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.QuestionTags;
import zxc.laitooo.sri.data.UserData;

public class SelectQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_questio_answers);
        setSupportActionBar(toolbar);

        final Intent m = getIntent();
        final int id_question = m.getIntExtra("id",0);
        String title = m.getStringExtra("questionTitle");
        final String name = m.getStringExtra("questionName");
        String time = m.getStringExtra("questionTime");
        String content = m.getStringExtra("questionContent");
        String tags = m.getStringExtra("tags");
        int votes = m.getIntExtra("votes",0);
        String image_url = m.getStringExtra("image");

        getSupportActionBar().setTitle(title);

        TextView questionTitle = (TextView)findViewById(R.id.sel_que_title);
        TextView questionName = (TextView)findViewById(R.id.sel_que_name);
        TextView questionTime = (TextView)findViewById(R.id.sel_que_time);
        TextView questionContent = (TextView)findViewById(R.id.sel_que_content);
        TextView votesText = (TextView)findViewById(R.id.number_votes);
        ImageView imageView = (ImageView)findViewById(R.id.post_image);

        if (image_url.equals("no_profile")){
            Picasso.with(SelectQuestionActivity.this)
                    .load(R.drawable.boy)
                    .skipMemoryCache()
                    .into(imageView);
        }else {
            Picasso.with(SelectQuestionActivity.this)
                    .load(image_url)
                    .skipMemoryCache()
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(imageView);
        }

        questionTitle.setText(title);
        questionName.setText(name);
        questionTime.setText(time);
        questionContent.setText(content);
        votesText.setText(String.valueOf(votes));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_ansers);
        final ArrayList<Answer> list = new ArrayList<>();
        final AnswersAdapter adapter = new AnswersAdapter(list,SelectQuestionActivity.this);
        Map<String,String> map = new HashMap<>();
        map.put("id_question",String.valueOf(id_question));
        NetworkTask task = new NetworkTask(true, Constants.SELECTED_QUESTION_ANSWERS, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray posts = object.getJSONArray("answers");
                    for (int i=0;i<posts.length();i++){
                        JSONObject answer = posts.getJSONObject(i);
                        list.add(new Answer(answer.getInt("id"),answer.getInt("id_question"),
                                answer.getInt("id_user"),answer.getString("content"),
                                answer.getString("date"),answer.getString("time"),
                                answer.getString("username"),answer.getString("image"),
                                answer.getInt("votes")));
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Toast.makeText(SelectQuestionActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, SelectQuestionActivity.this, map);
        task.executeTask();
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        Button d5 = (Button)findViewById(R.id.send_answer);
        final EditText f5 = (EditText)findViewById(R.id.new_answer);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String j = f5.getText().toString();
                if (!j.equals("")) {
                    final UserData data = new UserData(SelectQuestionActivity.this);
                    Map<String, String> map = new HashMap<>();
                    map.put("id_question", String.valueOf(id_question));
                    map.put("id_user", String.valueOf(data.getId()));
                    map.put("content", j);
                    map.put("date", Date.getDate());
                    map.put("time", Date.getTime());
                    NetworkTask task = new NetworkTask(true, Constants.ADD_ANSWER, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            try {
                                JSONObject object = new JSONObject(s);
                                if (!object.getBoolean("error")) {
                                    Toast.makeText(SelectQuestionActivity.this, object.getString("message"),
                                            Toast.LENGTH_LONG).show();
                                    list.add(list.size(),new Answer(object.getInt("id"), id_question, data.getId(), j,
                                            Date.getDate(), Date.getTime(), data.getUserName(),
                                            data.getImageUrl(), 0));
                                    adapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(SelectQuestionActivity.this, object.getString("message"),
                                            Toast.LENGTH_LONG).show();
                                }
                                adapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                Toast.makeText(SelectQuestionActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }, SelectQuestionActivity.this, map);
                    task.executeTask();
                    adapter.notifyDataSetChanged();
                    f5.setText("");
                }else {
                    Toast.makeText(SelectQuestionActivity.this, "please enter your answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        QuestionTags questionTags = new QuestionTags(SelectQuestionActivity.this);
        TagContainerLayout tagView = (TagContainerLayout)findViewById(R.id.tagview);
        ArrayList<String> taglist = new ArrayList<>();
        for (int i=0;i<tags.length();i++){
            taglist.add(questionTags.getTagName(tags.substring(i,i+1)));
        }
        tagView.setTags(taglist);



    }

}
