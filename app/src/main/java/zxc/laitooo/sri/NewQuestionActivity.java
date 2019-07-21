package zxc.laitooo.sri;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.Date;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.QuestionTags;
import zxc.laitooo.sri.data.UserData;

public class NewQuestionActivity extends AppCompatActivity {

    ArrayList<CheckBox> tagsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_question);

        Toolbar t = (Toolbar)findViewById(R.id.toolbar_new_question);
        setSupportActionBar(t);

        ActionBar a = getSupportActionBar();
        a.setDisplayHomeAsUpEnabled(true);
        a.setTitle("New Question");

        final EditText title = (EditText)findViewById(R.id.newQueSub);
        final EditText content = (EditText)findViewById(R.id.newQueCon);

        tagsList = new ArrayList<>();

        tagsList.add((CheckBox)findViewById(R.id.tag1));
        tagsList.add((CheckBox)findViewById(R.id.tag2));
        tagsList.add((CheckBox)findViewById(R.id.tag3));
        tagsList.add((CheckBox)findViewById(R.id.tag4));
        tagsList.add((CheckBox)findViewById(R.id.tag5));
        tagsList.add((CheckBox)findViewById(R.id.tag6));
        tagsList.add((CheckBox)findViewById(R.id.tag7));
        tagsList.add((CheckBox)findViewById(R.id.tag8));
        tagsList.add((CheckBox)findViewById(R.id.tag9));
        tagsList.add((CheckBox)findViewById(R.id.tag10));
        tagsList.add((CheckBox)findViewById(R.id.tag11));
        tagsList.add((CheckBox)findViewById(R.id.tag12));
        tagsList.add((CheckBox)findViewById(R.id.tag13));


        Button post = (Button)findViewById(R.id.newPosBtn);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final QuestionTags tags = new QuestionTags(NewQuestionActivity.this);
                for (int i=0;i<tagsList.size();i++){
                    if (tagsList.get(i).isChecked()){
                        tags.addTag(i);
                    }
                }
                //Toast.makeText(NewQuestionActivity.this,tags.getTagsShorted(),Toast.LENGTH_LONG).show();
                if (!(title.getText().toString().equals("") || content.getText().toString().equals(""))) {
                    final Map<String, String> map = new HashMap<>();
                    final UserData data = new UserData(NewQuestionActivity.this);
                    map.put("id_user",String.valueOf(data.getId()));
                    map.put("title", title.getText().toString());
                    map.put("content", content.getText().toString());
                    map.put("date","today");
                    map.put("time","just now");
                    map.put("tags",tags.getTagsShorted());
                    NetworkTask task = new NetworkTask(true, Constants.ADD_QUESTION, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            try {
                                JSONObject object = new JSONObject(s);
                                if (!object.getBoolean("error")){
                                    Toast.makeText(NewQuestionActivity.this, "question submitted successfully", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(NewQuestionActivity.this,MainActivity.class);
                                    intent.putExtra("id",object.getInt("id"));
                                    intent.putExtra("title",title.getText().toString());
                                    intent.putExtra("content",content.getText().toString());
                                    intent.putExtra("date", Date.getDate());
                                    intent.putExtra("time", Date.getTime());
                                    intent.putExtra("tags", tags.getTagsShorted());
                                    setResult(RESULT_OK,intent);
                                    finish();
                                }else {
                                    Toast.makeText(NewQuestionActivity.this, object.getString("message"), Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                Toast.makeText(NewQuestionActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }, NewQuestionActivity.this, map);
                    task.executeTask();
                }else {
                    Toast.makeText(getApplicationContext(),"Please fill the fields",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
