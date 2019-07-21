package zxc.laitooo.sri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Laitooo San on 10/06/2019.
 */

public class RepliesAdapter extends RecyclerView.Adapter<RepliesAdapter.RepliesHolder> {


    private ArrayList<Reply> list;
    private Context context;

    public RepliesAdapter(ArrayList<Reply> l, Context c){
        this.list = l;
        this.context = c;
    }


    @Override
    public RepliesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments,parent,false);
        return new RepliesHolder(v);
    }

    @Override
    public void onBindViewHolder(RepliesHolder holder, int position) {

        Reply reply = list.get(position);
        holder.name.setText(list.get(position).getName());
        holder.time.setText(list.get(position).getTime());
        //holder.image.setImageResource(list.get(position).getVideoImage());
        holder.content.setText(list.get(position).getContent());


        if (reply.getImage().equals("no_profile")){
            Picasso.with(context)
                    .load(R.drawable.boy)
                    .skipMemoryCache()
                    .into(holder.image);
        }else {
            Picasso.with(context)
                    .load(reply.getImage())
                    .skipMemoryCache()
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(holder.image);
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RepliesHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView time;
        ImageView image;
        TextView content;


        public RepliesHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.post_image);
            name = (TextView)itemView.findViewById(R.id.comment_name);
            time = (TextView)itemView.findViewById(R.id.comments_time);
            content = (TextView)itemView.findViewById(R.id.comments_content);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
