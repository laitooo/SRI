package zxc.laitooo.sri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Zizo on 11/3/2017.
 */
public class WebinarsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts);

        ArrayList<Webinars> list = new ArrayList<>();
        list.add(new Webinars("Lecture 1","3rd of December 2016",R.drawable.aaa,"About Android Programming"));
        list.add(new Webinars("Lecture 2","25th of Mai 2017",R.drawable.bac,"About Japanese Language"));
        list.add(new Webinars(" المحاضرة الثالثة ", "20/4/2015", R.drawable.logo, "  مقدم المحاضرة دكتور احمد اسامة دكتور في علم النفس "));
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.WRecycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        WebinarsAdapter adapter = new WebinarsAdapter(list,getApplicationContext());
        recyclerView.setAdapter(adapter);

        android.support.v7.widget.Toolbar l = (android.support.v7.widget.Toolbar)findViewById(R.id.tool);
        setSupportActionBar(l);

        android.support.v7.app.ActionBar a = getSupportActionBar();

        a.setTitle("Webinars");
        a.setDisplayHomeAsUpEnabled(true);


    }

}
