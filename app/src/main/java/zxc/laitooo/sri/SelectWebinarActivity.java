package zxc.laitooo.sri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;


public class SelectWebinarActivity extends AppCompatActivity {

    public static final String API_KEY = "AIzaSyAs3UEm7do04qijI3syn7X44qcrzGOWA";
    public final static String VIDEO_ID = "I7DfivwvfF0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_select_webinar);


        //YouTubePlayerView playerView = (YouTubePlayerView)findViewById(R.id.youtubePlayer);
        //playerView.initialize(API_KEY, this);

        Intent a = getIntent();

        TextView aa = (TextView)findViewById(R.id.videoname);
        TextView ab = (TextView)findViewById(R.id.videodate);
        TextView ac = (TextView)findViewById(R.id.videoinfo);

        aa.setText(a.getStringExtra("Name"));
        ab.setText(a.getStringExtra("Date"));
        ac.setText(a.getStringExtra("Info"));
    }

    /*@Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        youTubePlayer.setPlayerStateChangeListener(actionBar);
        youTubePlayer.setPlaybackEventListener(c);

        if (b){
            youTubePlayer.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getApplicationContext(), "FAiled to load video", Toast.LENGTH_SHORT).show();
    }

    YouTubePlayer.PlaybackEventListener c = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    YouTubePlayer.PlayerStateChangeListener actionBar =new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };*/

}
