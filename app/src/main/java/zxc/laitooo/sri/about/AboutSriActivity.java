package zxc.laitooo.sri.about;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import zxc.laitooo.sri.R;

public class AboutSriActivity extends AppCompatActivity {

    ImageButton[] imageButtons = new ImageButton[5];
    TextView[] textViews = new TextView[5];
    boolean[] booleans = new boolean[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int tt = intent.getIntExtra("laitooo", 0);
        booleans[0] = false; booleans[1] = false; booleans[2] = false; booleans[3] = false; booleans[4] = false;

        if (tt == 111) {

            setContentView(R.layout.about);


            textViews[0] = (TextView)findViewById(R.id.about1C);
            textViews[1] = (TextView)findViewById(R.id.about2C);
            textViews[2] = (TextView)findViewById(R.id.about3C);
            textViews[3] = (TextView)findViewById(R.id.about4C);
            textViews[4] = (TextView)findViewById(R.id.about5C);

            imageButtons[0] = (ImageButton)findViewById(R.id.buttonViewMore1);
            imageButtons[1] = (ImageButton)findViewById(R.id.buttonViewMore2);
            imageButtons[2] = (ImageButton)findViewById(R.id.buttonViewMore3);
            imageButtons[3] = (ImageButton)findViewById(R.id.buttonViewMore4);
            imageButtons[4] = (ImageButton)findViewById(R.id.buttonViewMore5);


            textViews[0].setText(getResources().getString(R.string.rational));
            textViews[1].setText(getResources().getString(R.string.our_vision));
            textViews[2].setText(getResources().getString(R.string.our_mission));
            textViews[3].setText(getResources().getString(R.string.our_goals));
            textViews[4].setText(getResources().getString(R.string.our_strategy));

            for (int i=0;i<textViews.length;i++) {
                textViews[i].setVisibility(View.GONE);
                final int t = i;
                imageButtons[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!booleans[t]){
                            textViews[t].setVisibility(View.VISIBLE);
                            imageButtons[t].setImageResource(android.R.drawable.arrow_up_float);
                            booleans[t] = true;
                        }else {
                            textViews[t].setVisibility(View.GONE);
                            imageButtons[t].setImageResource(android.R.drawable.arrow_down_float);
                            booleans[t] = false;
                        }
                    }
                });
            }


            /*imageButtons[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!booleans[1]){
                        textViews[1].setVisibility(View.VISIBLE);
                        imageButtons[1].setImageResource(android.R.drawable.arrow_up_float);
                        booleans[1] = true;
                    }else {
                        textViews[1].setVisibility(View.GONE);
                        imageButtons[1].setImageResource(android.R.drawable.arrow_down_float);
                        booleans[1] = false;
                    }
                }
            });
            imageButtons[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!booleans[2]){
                        textViews[2].setVisibility(View.VISIBLE);
                        imageButtons[2].setImageResource(android.R.drawable.arrow_up_float);
                        booleans[2] = true;
                    }else {
                        textViews[2].setVisibility(View.GONE);
                        imageButtons[2].setImageResource(android.R.drawable.arrow_down_float);
                        booleans[2] = false;
                    }
                }
            });
            imageButtons[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!booleans[3]){
                        textViews[3].setVisibility(View.VISIBLE);
                        imageButtons[3].setImageResource(android.R.drawable.arrow_up_float);
                        booleans[3] = true;
                    }else {
                        textViews[3].setVisibility(View.GONE);
                        imageButtons[3].setImageResource(android.R.drawable.arrow_down_float);
                        booleans[3] = false;
                    }
                }
            });
            imageButtons[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!booleans[4]){
                        textViews[4].setVisibility(View.VISIBLE);
                        imageButtons[4].setImageResource(android.R.drawable.arrow_up_float);
                        booleans[4] = true;
                    }else {
                        textViews[4].setVisibility(View.GONE);
                        imageButtons[4].setImageResource(android.R.drawable.arrow_down_float);
                        booleans[4] = false;
                    }
                }
            });*/


            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about);
            setSupportActionBar(toolbar);

            ActionBar k = getSupportActionBar();
            k.setTitle("About SRI");

        }else if (tt == 222){

        }


    }


}