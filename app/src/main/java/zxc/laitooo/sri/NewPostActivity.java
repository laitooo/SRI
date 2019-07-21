package zxc.laitooo.sri;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

public class NewPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        Toolbar t = (Toolbar)findViewById(R.id.toolbar_new_post);
        setSupportActionBar(t);

        ActionBar a = getSupportActionBar();
        a.setDisplayHomeAsUpEnabled(true);
        a.setTitle("New Post");

        //final EditText title = (EditText)findViewById(R.id.newPosSub);
        final EditText content = (EditText)findViewById(R.id.newPosCon);

        Button post = (Button)findViewById(R.id.newPosBtn);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(//title.getText().toString().equals("") ||
                content.getText().toString().equals(""))) {
                    final Map<String, String> map = new HashMap<>();
                    final UserData data = new UserData(NewPostActivity.this);
                    map.put("id_user",String.valueOf(data.getId()));
                    //map.put("title", title.getText().toString());
                    map.put("content", content.getText().toString());
                    map.put("date","today");
                    map.put("time","just now");
                    NetworkTask task = new NetworkTask(true, Constants.ADD_POST, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            try {
                                JSONObject object = new JSONObject(s);
                                if (!object.getBoolean("error")){
                                    Toast.makeText(NewPostActivity.this, "Posted successfully", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(NewPostActivity.this,MainActivity.class);
                                    intent.putExtra("id",object.getInt("id"));
                                    //intent.putExtra("title",title.getText().toString());
                                    intent.putExtra("content",content.getText().toString());
                                    intent.putExtra("date","today");
                                    intent.putExtra("time","time");
                                    setResult(RESULT_OK,intent);
                                    finish();
                                }else {
                                    Toast.makeText(NewPostActivity.this, object.getString("message"), Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                Toast.makeText(NewPostActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }, NewPostActivity.this, map);
                    task.executeTask();
                }else {
                    Toast.makeText(getApplicationContext(),"Please fill the fields",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
