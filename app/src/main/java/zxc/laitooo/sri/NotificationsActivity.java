package zxc.laitooo.sri;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Toolbar t = (Toolbar)findViewById(R.id.toolba);
        setSupportActionBar(t);

        android.support.v7.app.ActionBar a = getSupportActionBar();
        a.setTitle("Notifications");
        a.setDisplayHomeAsUpEnabled(true);

        Context c = getApplicationContext();

        ArrayList<Notification> list = new ArrayList<>();
        list.add(new Notification(R.drawable.bac,"Laitooo san Mentioned you in comment"));
        list.add(new Notification(R.drawable.logo_c, "Ahmed mohammed answered your question"));
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler3);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        NotificationAdapter adapter = new NotificationAdapter(list,c);
        recyclerView.setAdapter(adapter);

        android.app.Notification e = new NotificationCompat.Builder(c)
        .setSmallIcon(R.mipmap.ic_l)
                .setContentTitle("SRF")
                .setAutoCancel(true)
        .setContentText("Omer Ali posted actionBar new post")
        .build();

        NotificationManager h = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        h.notify(0,e);



    }
}
