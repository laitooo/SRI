package zxc.laitooo.sri;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Zizo on 2/3/2018.
 */
public class profileReputationFragment extends Fragment {

    private static Context c;

    Button level;
    TextView reputation,lastseen,following,followers,contents;
    static int levelValue,followingValue,followersValue,contentsValue;
    static double reputationValue;
    static String lastseenValue;

    public profileReputationFragment() {
    }

    public static profileReputationFragment makeFragment(Context context,int levelVal,int contentsVal,
                                                         int followingVal,int followersVal,
                                                         double reputationVal,String lastseenVal){
        profileReputationFragment fragment = new profileReputationFragment();
        c = context;
        followersValue = followersVal;
        followingValue = followingVal;
        lastseenValue = lastseenVal;
        reputationValue = reputationVal;
        contentsValue = contentsVal;
        levelValue = levelVal;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_reputaion, container, false);
        level = (Button)v.findViewById(R.id.UserLevel);
        reputation = (TextView)v.findViewById(R.id.profile_reputation);
        lastseen = (TextView)v.findViewById(R.id.lastseen);
        following = (TextView)v.findViewById(R.id.following);
        followers = (TextView)v.findViewById(R.id.followers);
        contents = (TextView)v.findViewById(R.id.contents);

        level.setText("Level " + String.valueOf(levelValue));
        reputation.setText(String.valueOf(reputationValue));
        lastseen.setText(lastseenValue);
        following.setText(String.valueOf(followingValue));
        followers.setText(String.valueOf(followersValue));
        contents.setText(String.valueOf(contentsValue));
        ImageButton b =(ImageButton)v.findViewById(R.id.editProfileBtn1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ProfileActivity)getActivity()).fragmentToActivityReputation();
            }
        });
        return v;
    }

}
