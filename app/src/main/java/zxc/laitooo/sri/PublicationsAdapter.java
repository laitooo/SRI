package zxc.laitooo.sri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zizo on 12/29/2017.
 */
public class PublicationsAdapter extends RecyclerView.Adapter<PublicationsAdapter.PublicationsHolder> {


    private ArrayList<Publications> list;
    private Context context;

    public PublicationsAdapter(ArrayList<Publications> l,Context m){
        this.list = l;
        this.context = m;
    }


    @Override
    public PublicationsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.publication,parent,false);
        return new PublicationsHolder(v);
    }

    @Override
    public void onBindViewHolder(PublicationsHolder holder, int position) {

        //holder.image.setImageResource(list.get(position).getMemberImage());
        holder.title.setText(list.get(position).getPublicationTitle());
        holder.authors.setText(list.get(position).getPublicationAuthors());
        holder.publishers.setText(list.get(position).getPublicationPublisher());
        holder.date.setText(list.get(position).getPublicationDate());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PublicationsHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView authors;
        TextView publishers;
        TextView date;

        public PublicationsHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.PublicationTitle);
            authors = (TextView)itemView.findViewById(R.id.comments_time);
            publishers = (TextView)itemView.findViewById(R.id.PublicationPublisher);
            date = (TextView)itemView.findViewById(R.id.PublicationDate);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}
