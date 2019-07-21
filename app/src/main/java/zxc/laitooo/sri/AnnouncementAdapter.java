package zxc.laitooo.sri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zizo on 12/9/2017.
 */
public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementHolder> {

    private ArrayList<Announcement> list;
    private Context context;

    public AnnouncementAdapter(ArrayList<Announcement> l,Context m){
        this.list = l;
        this.context = m;
    }

    @Override
    public AnnouncementHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.announcments,parent,false);
        return new AnnouncementHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnnouncementHolder holder, int position) {
        final int[] ifd = {0};
        holder.title.setText(list.get(position).getAnnouncementTitle());
        holder.time.setText(list.get(position).getAnnouncementTime());
        final String a = list.get(position).getAnnouncementContent();
        String[] f = a.split(" ");
        final String b;
        if (a.length()>31) {
            b = f[0] + " " + f[1] + " " +f[2] + " " + f[3] + " " + f[4];
        }else {
            b = a;
            holder.readmore.setText("");
            holder.readmore.setClickable(false);
        }
        holder.content.setText(b);
        holder.readmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifd[0] %2 == 0) {
                    holder.content.setText(a);
                    holder.readmore.setText("read less");
                    ifd[0]++;
                }else {
                    holder.content.setText(b);
                    holder.readmore.setText("read more");
                    ifd[0]++;
                }
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AnnouncementHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        TextView content;
        TextView readmore;

        public AnnouncementHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.comment_name);
            time = (TextView)itemView.findViewById(R.id.comments_time);
            content = (TextView)itemView.findViewById(R.id.comments_content);
            readmore = (TextView)itemView.findViewById(R.id.readmore);

        }
    }
}
