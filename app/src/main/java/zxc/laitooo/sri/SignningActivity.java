package zxc.laitooo.sri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.Date;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

public class SignningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signning);

        final EditText username,password,email,confpw,firstname,lastname;
        username = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.useremail);
        password = (EditText)findViewById(R.id.password);
        confpw = (EditText)findViewById(R.id.confpw);
        firstname = (EditText)findViewById(R.id.firstname);
        lastname = (EditText)findViewById(R.id.lastname);


        Button signup = (Button)findViewById(R.id.bRegister);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(username.getText().toString().equals("") || email.getText().toString().equals("")
                || password.getText().toString().equals("") || firstname.getText().toString().equals("")
                || confpw.getText().toString().equals("") || lastname.getText().toString().equals(""))) {
                    if (password.getText().toString().equals(confpw.getText().toString())) {
                        if (password.getText().toString().length() >= 8) {
                            final Map<String, String> map = new HashMap<>();
                            map.put("email", email.getText().toString());
                            map.put("password", password.getText().toString());
                            map.put("username", username.getText().toString());
                            map.put("firstname", firstname.getText().toString());
                            map.put("lastname", lastname.getText().toString());
                            map.put("date", Date.getDate());
                            NetworkTask task = new NetworkTask(true, Constants.SIGN_UP, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String s) {
                                    try {
                                        JSONObject object = new JSONObject(s);
                                        if (!object.getBoolean("error")){
                                            UserData data = new UserData(SignningActivity.this);
                                            data.saveUser(object.getInt("id"),object.getString("email"),
                                                    object.getString("username"),object.getString("firstname"),
                                                    object.getString("lastname"),object.getString("image_url"));
                                            Toast.makeText(SignningActivity.this, "Account created successfully", Toast.LENGTH_LONG).show();
                                            finish();
                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        }else {
                                            Toast.makeText(SignningActivity.this, object.getString("message"), Toast.LENGTH_LONG).show();
                                        }
                                    } catch (JSONException e) {
                                        Toast.makeText(SignningActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            }, SignningActivity.this, map);
                            task.executeTask();
                        }else {
                            Toast.makeText(getApplicationContext(),"password length must be at least 8",
                                    Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"passwords don't match",
                                Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"All fields are required",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void JoinFacebook(View view) {
        Toast.makeText(getApplicationContext(), "Join via facebook", Toast.LENGTH_SHORT).show();
    }

}
