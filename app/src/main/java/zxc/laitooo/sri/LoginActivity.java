package zxc.laitooo.sri;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    ImageButton d;
    boolean visible;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserData user = new UserData(getApplicationContext());
        if (user.isUserLogged()){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }else {
            setContentView(R.layout.activity_login);

            visible = false;

            email = (EditText) findViewById(R.id.loginEmailid);
            password = (EditText) findViewById(R.id.loginpasswordid);

            d = (ImageButton) findViewById(R.id.password_hide);
            d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!visible) {
                        password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        visible = true;
                    } else if (visible) {
                        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                        visible = false;
                    }
                }
            });

            Button login = (Button)findViewById(R.id.newPosBtn);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!(email.getText().toString().equals("") || password.getText().toString().equals(""))) {
                        final Map<String, String> map = new HashMap<>();
                        map.put("email", email.getText().toString());
                        map.put("password", password.getText().toString());
                        NetworkTask task = new NetworkTask(true, Constants.LOGIN, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String s) {
                                try {
                                    JSONObject object = new JSONObject(s);
                                    if (!object.getBoolean("error")){
                                        UserData data = new UserData(LoginActivity.this);
                                        data.saveUser(object.getInt("id"),object.getString("email"),
                                                object.getString("username"),object.getString("firstname"),
                                                object.getString("lastname"),object.getString("image_url"));
                                        Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_LONG).show();
                                        finish();
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    }else {
                                        Toast.makeText(LoginActivity.this, object.getString("message"), Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }, LoginActivity.this, map);
                        task.executeTask();
                    }else {
                        Toast.makeText(getApplicationContext(),"All fields are required",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public void SignUp(View view) {
        Intent i = new Intent(getApplicationContext(),SignningActivity.class);
        startActivityForResult(i, 121);
    }

    public void JoinFacebook(View view) {

    }

    public void ForgotMyPassword(View view) {
        Intent i = new Intent(getApplicationContext(),ForgetPasswordActivity.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 121 ){
            if (resultCode == RESULT_OK){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
