package zxc.laitooo.sri;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

/**
 * Created by Zizo on 1/10/2018.
 */
public class EditBioFragment extends Fragment {

    EditText editBio;
    int count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.edit_bio, container, false);

        editBio = (EditText)v.findViewById(R.id.edit_bio);
        Button update = (Button)v.findViewById(R.id.updateButton);
        Button cancel = (Button)v.findViewById(R.id.cancelButton);
        final TextView limit = (TextView)v.findViewById(R.id.UpdateBioLimit);

        count = 0;

        editBio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                count = s.toString().length();
                limit.setText(count + "/500");
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editBio.getText().toString().equals("")) {
                    if (count < 500) {
                        final UserData userData = new UserData(getContext());
                        final Map<String, String> map = new HashMap<>();
                        map.put("bio", editBio.getText().toString());
                        map.put("id", String.valueOf(userData.getId()));
                        NetworkTask task = new NetworkTask(true, Constants.EDIT_BIO, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String s) {
                                try {
                                    JSONObject object = new JSONObject(s);
                                    if (!object.getBoolean("error")) {
                                        Toast.makeText(getContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                                        ((ProfileActivity) getActivity()).
                                                fragmentToActivityEditBio(editBio.getText().toString());
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
                        Toast.makeText(getContext(), "Maximum length is 500", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getContext(),"all fields are required",Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ProfileActivity)getActivity()).fragmentToActivityEditBio("");
            }
        });

        return v;
    }

    private void kill(){
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();

    }
}
