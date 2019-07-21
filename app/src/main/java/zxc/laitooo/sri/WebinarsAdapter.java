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
 * Created by Zizo on 12/15/2017.
 */
public class WebinarsAdapter extends RecyclerView.Adapter<WebinarsAdapter.WebinarHolder> {

    private ArrayList<Webinars> list;
    private Context context;

    public WebinarsAdapter(ArrayList<Webinars> l,Context m){
        this.list = l;
        this.context = m;
    }


    @Override
    public WebinarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.webinars,parent,false);
        return new WebinarHolder(v);
    }

    @Override
    public void onBindViewHolder(WebinarHolder holder, int position) {
        holder.name.setText(list.get(position).getVideoName());
        holder.date.setText(list.get(position).getVideoDate());
        //holder.image.setImageResource(list.get(position).getVideoImage());
        holder.info.setText(list.get(position).getVideoInfo());
        final int pp = position;
        /*holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,SelectWebinarActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Name", list.get(pp).getVideoName());
                i.putExtra("Date", list.get(pp).getVideoDate());
                i.putExtra("Info", list.get(pp).getVideoInfo());
                context.startActivity(i);
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WebinarHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView date;
        ImageView image;
        TextView info;


        public WebinarHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.videoimage);
            name = (TextView)itemView.findViewById(R.id.videoname);
            date = (TextView)itemView.findViewById(R.id.videodate);
            info = (TextView)itemView.findViewById(R.id.videoinfo);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
