package zxc.laitooo.sri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import zxc.laitooo.sri.about.ContactUsActivity;

/**
 * Created by Zizo on 2/14/2018.
 */
public class importantAnnounementsFragment extends Fragment {

    public static importantAnnounementsFragment showAnnouncements(){
        importantAnnounementsFragment fragment = new importantAnnounementsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.important_announcements,container,false);
        ImageButton ff = (ImageButton)v.findViewById(R.id.button_important);
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).closeImportant();
            }
        });

        RelativeLayout layout = (RelativeLayout)v.findViewById(R.id.important_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).closeImportant();
                startActivity(new Intent(getContext(),ContactUsActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        return v;
    }
}
