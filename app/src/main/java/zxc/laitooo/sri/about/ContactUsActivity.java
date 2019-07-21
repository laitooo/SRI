package zxc.laitooo.sri.about;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.MainActivity;
import zxc.laitooo.sri.NewQuestionActivity;
import zxc.laitooo.sri.R;
import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.Date;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

/**
 * Created by Zizo on 11/3/2017.
 */
public class ContactUsActivity extends AppCompatActivity {

    int checkedBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);

        final EditText name = (EditText)findViewById(R.id.name);
        final EditText subject = (EditText)findViewById(R.id.subject);
        final EditText email = (EditText)findViewById(R.id.email);
        final EditText content = (EditText)findViewById(R.id.content);
        Button submit = (Button)findViewById(R.id.submit);

        final CheckBox[] checkBoxes = new CheckBox[5];
        checkedBox = 551;

        checkBoxes[0] = (CheckBox)findViewById(R.id.checkBox1);
        checkBoxes[1] = (CheckBox)findViewById(R.id.checkBox2);
        checkBoxes[2] = (CheckBox)findViewById(R.id.checkBox3);
        checkBoxes[3] = (CheckBox)findViewById(R.id.checkBox4);
        checkBoxes[4] = (CheckBox)findViewById(R.id.checkBox5);

        for (int i=0;i<5;i++){
            checkBoxes[i].setChecked(false);
            final int k = i;
            checkBoxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        checkedBox = k + 1;
                        for (int j = 0; j < 5; j++) {
                            if (j != k) {
                                checkBoxes[j].setChecked(false);
                                //Toast.makeText(ContactUsActivity.this, "k" + k + "  j" + j, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            });
        }




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().equals("") && !subject.getText().toString().equals("") &&
                        !email.getText().toString().equals("") && !content.getText().toString().equals("") &&
                        checkedBox != 551) {
                    final Map<String, String> map = new HashMap<>();
                    map.put("name", name.getText().toString());
                    map.put("subject", subject.getText().toString());
                    map.put("email", email.getText().toString());
                    map.put("content", content.getText().toString());
                    map.put("channel", String.valueOf(checkedBox));
                    NetworkTask task = new NetworkTask(true, Constants.GET_IN_TOUCH, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            try {
                                JSONObject object = new JSONObject(s);
                                if (!object.getBoolean("error")){
                                    Toast.makeText(ContactUsActivity.this, object.getString("message"),
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                }else {
                                    Toast.makeText(ContactUsActivity.this, object.getString("message"), Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                Toast.makeText(ContactUsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }, ContactUsActivity.this, map);
                    task.executeTask();
                }else {
                    Toast.makeText(getApplicationContext(),"Please fill the fields",
                            Toast.LENGTH_LONG).show();
                }
            }
        });





    }


    public void finish(View view) {
        finish();
    }
}
