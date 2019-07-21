package zxc.laitooo.sri;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.InfoLists;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

/**
 * Created by Laitooo San on 21/06/2019.
 */

public class AddFieldDialog extends android.support.v4.app.DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.add_language, null, false);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        final AutoCompleteTextView auto = (AutoCompleteTextView)v.findViewById(R.id.add_lang_auto);
        auto.setHint("Add Field");
        Button add = (Button)v.findViewById(R.id.add_lang_btn);

        InfoLists infoLists = new InfoLists();

        final ArrayList<String> list2 = infoLists.fieldList;

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                android.R.layout.select_dialog_item, list2);
        auto.setAdapter(adapter2);
        auto.setThreshold(1);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!auto.getText().toString().equals("")) {
                    UserData userData = new UserData(getContext());
                    Map<String, String> map = new HashMap<>();
                    map.put("id_user", String.valueOf(userData.getId()));
                    map.put("field", auto.getText().toString());
                    NetworkTask task = new NetworkTask(true, Constants.ADD_FIELD, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            try {
                                JSONObject object = new JSONObject(s);
                                if (!object.getBoolean("error")) {
                                    ProfileInfoFragment.listFields.add(auto.getText().toString());
                                    ProfileInfoFragment.adapterFields.notifyDataSetChanged();
                                    Toast.makeText(getActivity(), "Added the field", Toast.LENGTH_SHORT).show();
                                    dismiss();
                                } else {
                                    Toast.makeText(getActivity(), object.getString("message"), Toast.LENGTH_SHORT).show();
                                    dismiss();
                                }

                            } catch (JSONException e) {
                                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                dismiss();
                            }
                        }
                    }, getActivity(), map);
                    task.executeTask();
                }else {
                    Toast.makeText(getActivity(),"Please enter a field", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return builder.create();

    }
}
