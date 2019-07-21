package zxc.laitooo.sri;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Zizo on 2/3/2018.
 */
public class ProfileBioFragment extends Fragment {

    private static Context c;

    TextView content;
    static String Bio;

    public ProfileBioFragment() {
    }

    public static ProfileBioFragment makeBioFragment(Context a,String bio){
        ProfileBioFragment fragment = new ProfileBioFragment();
        c = a;
        if (bio.equals("")){
            Bio = "No bio";
        }else {
            Bio = bio;
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_bio, container, false);
        ImageButton b =(ImageButton)v.findViewById(R.id.editProfileBtn2);
        content = (TextView)v.findViewById(R.id.proBioContent);

        content.setText(Bio);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ProfileActivity)getActivity()).fragmentToActivityBio();
            }
        });
        return v;
    }

}
