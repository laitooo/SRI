package zxc.laitooo.sri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zizo on 12/11/2017.
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {


    private ArrayList<Notification> list;
    private Context context;

    public NotificationAdapter(ArrayList<Notification> l,Context m){
        this.list = l;
        this.context = m;
    }


    @Override
    public  NotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifiacition,parent,false);
        return new NotificationHolder(v);
    }

    @Override
    public void onBindViewHolder(NotificationHolder holder, int position) {
        /*
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap m = BitmapFactory.decodeFile(String.valueOf(list.get(position).getImage()), options);
        Bitmap k = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.aaa, options);

        holder.Image.setImageBitmap(k);
        */
        holder.Content.setText(list.get(position).getContent());
        holder.Image.setOnClickListener(FF);
        holder.Content.setOnClickListener(FF);
    }

    View.OnClickListener FF = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Do Something here
        }
    };

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationHolder extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Content;

        public NotificationHolder(View itemView) {
            super(itemView);
            Image = (ImageView)itemView.findViewById(R.id.notImage);
            Content = (TextView)itemView.findViewById(R.id.notName);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
