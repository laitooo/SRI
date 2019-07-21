package zxc.laitooo.sri;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import zxc.laitooo.sri.data.UserData;

/**
 * Created by Zizo on 1/2/2018.
 */
public class MyDialog  extends DialogFragment{
    Context c;
    int v;
    ArrayList<String> list;
    int p;
    ArrayAdapter<String> adapter;
    TextView tt;

    public MyDialog(){}

    @SuppressLint("ValidFragment")
    public MyDialog(Context a, int l) {
        this.c = a;
        this.v = l;
    }

    @SuppressLint("ValidFragment")
    public MyDialog(Context a, int l, TextView textView) {
        this.c = a;
        this.v = l;
        this.tt = textView;
    }

    @SuppressLint("ValidFragment")
    public MyDialog(Context a, int l, ArrayList<String> strings, int Position, ArrayAdapter<String> as){
        this.c = a;
        this.v = l;
        this.list = strings;
        this.p = Position;
        this.adapter = as;
    }

    int number =0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (v == 1) {
            View v = getActivity().getLayoutInflater().inflate(R.layout.update_email, null, false);

            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setView(v);
            final EditText aa = (EditText) v.findViewById(R.id.edit_bio);
            Button b = (Button) v.findViewById(R.id.updateEmailBtn);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, aa.getText().toString(), Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            });
            return builder.create();

        }else if (v ==2){
            View v2 = getActivity().getLayoutInflater().inflate(R.layout.change_password, null, false);
            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setView(v2);
            return builder.create();
        }else if (v == 3){
            View v2 = getActivity().getLayoutInflater().inflate(R.layout.deactive_account, null, false);
            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setView(v2);
            return builder.create();
        }else if (v == 4){
            View v2 = getActivity().getLayoutInflater().inflate(R.layout.delete_language, null, false);
            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setView(v2);
            TextView yes = (TextView)v2.findViewById(R.id.yes);
            TextView no = (TextView)v2.findViewById(R.id.no);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(p);
                    adapter.notifyDataSetChanged();
                    dismiss();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return builder.create();
        }else if (v == 5){
            View v2 = getActivity().getLayoutInflater().inflate(R.layout.delete_language, null, false);
            TextView fff = (TextView)v2.findViewById(R.id.deleteTitle);
            fff.setText("Delete this Research Field?");
            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setView(v2);
            TextView yes = (TextView)v2.findViewById(R.id.yes);
            TextView no = (TextView)v2.findViewById(R.id.no);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(p);
                    adapter.notifyDataSetChanged();
                    dismiss();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return builder.create();
        }else if (v == 6){
            View v2 = getActivity().getLayoutInflater().inflate(R.layout.edit_bio, null, false);
            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setView(v2);
            final TextView numberOfCharacters = (TextView)v2.findViewById(R.id.UpdateBioLimit);
            final EditText editText = (EditText)v2.findViewById(R.id.edit_bio);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    String fs = editText.getText().toString();
                    if (fs.length() >= 500){
                        numberOfCharacters.setTextColor(Color.RED);
                    }else {
                        numberOfCharacters.setTextColor(Color.WHITE);
                    }

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    numberOfCharacters.setText(Integer.toString(editText.getText().toString().length()) + "/500");
                }
            });
            Button dd = (Button)v2.findViewById(R.id.updateEmailBtn);
            dd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (editText.getText().toString().length() >= 500) {
                        Toast.makeText(c,"Make your text less than 500 letters",Toast.LENGTH_LONG).show();
                    }else {
                        tt.setText(editText.getText().toString());
                        dismiss();
                    }
                }
            });
            return builder.create();
        }else if (v == 7){
            View v2 = getActivity().getLayoutInflater().inflate(R.layout.edit_profile, null, false);
            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setView(v2);
            return builder.create();
        }else if (v == 8){
            View v2 = getActivity().getLayoutInflater().inflate(R.layout.instruction_was_sent, null, false);
            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dismiss();
                }
            });
            builder.setView(v2);
            return builder.create();
        }else if (v == 9){
            View v2 = getActivity().getLayoutInflater().inflate(R.layout.logdia, null, false);
            final AlertDialog.Builder builder = new AlertDialog.Builder(c);
            Button b1 = (Button)v2.findViewById(R.id.dia_bt1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //The logging out code
                    UserData data = new UserData(c);
                    data.logOut();
                    Toast.makeText(c,"You logged out ",Toast.LENGTH_SHORT).show();
                    dismiss();
                    ((Activity)c).finish();
                    startActivity(new Intent(c,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });

            Button b2 = (Button)v2.findViewById(R.id.dia_bt2);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            builder.setView(v2);
            return builder.create();
        }else {
            return null;
        }

    }



}
