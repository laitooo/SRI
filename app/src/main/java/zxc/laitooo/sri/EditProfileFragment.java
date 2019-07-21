package zxc.laitooo.sri;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by Zizo on 1/9/2018.
 */
public class EditProfileFragment extends Fragment {

    EditText username,firstname,lastname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.edit_profile, container, false);

        username = (EditText)v.findViewById(R.id.username_edit);
        firstname = (EditText)v.findViewById(R.id.firstname_edit);
        lastname = (EditText)v.findViewById(R.id.lastname_edit);
        Button edit = (Button)v.findViewById(R.id.edit_button);
        Button cancel = (Button)v.findViewById(R.id.cancel_button);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().equals("") && !firstname.getText().toString().equals("") &&
                        !lastname.getText().toString().equals("")) {
                    final UserData userData = new UserData(getContext());
                    final Map<String, String> map = new HashMap<>();
                    map.put("username", username.getText().toString());
                    map.put("firstname", firstname.getText().toString());
                    map.put("lastname", lastname.getText().toString());
                    map.put("id",String.valueOf(userData.getId()));
                    NetworkTask task = new NetworkTask(true, Constants.EDIT_USERNAME, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            try {
                                JSONObject object = new JSONObject(s);
                                if (!object.getBoolean("error")) {
                                    Toast.makeText(getContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                                    userData.setUserName(username.getText().toString());
                                    userData.setFirstName(firstname.getText().toString());
                                    userData.setLastName(lastname.getText().toString());
                                    ((ProfileActivity)getActivity()).
                                            fragmentToActivityEditProfile(username.getText().toString());
                                } else {
                                    Toast.makeText(getContext(), object.getString("message"), Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }, getContext(), map);
                    task.executeTask();
                }else {
                    Toast.makeText(getContext(),"all fields are required",Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ProfileActivity)getActivity()).
                        fragmentToActivityEditProfile(new UserData(getContext()).getUserName());
            }
        });

        return v;
    }



}
