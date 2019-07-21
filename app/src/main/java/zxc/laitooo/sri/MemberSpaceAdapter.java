package zxc.laitooo.sri;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Zizo on 12/10/2017.
 */
public class MemberSpaceAdapter extends RecyclerView.Adapter<MemberSpaceAdapter.MemberSpaceHolder> {

    private ArrayList<MemberSpace> list;
    private Context context;

    public MemberSpaceAdapter(ArrayList<MemberSpace> l,Context m){
        this.list = l;
        this.context = m;
    }


    @Override
    public MemberSpaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_space,parent,false);
        return new MemberSpaceHolder(v);
    }

    @Override
    public void onBindViewHolder(MemberSpaceHolder holder, final int position) {

        final MemberSpace post = list.get(position);

        //holder.image.setImageResource(list.get(position).getMemberImage());
        //holder.title.setText(list.get(position).getPostTitle());
        holder.name.setText(list.get(position).getMemberName());
        holder.time.setText(list.get(position).getPostTime());
        holder.content.setText(list.get(position).getPostContent());
        holder.views.setText(Integer.toString(list.get(position).getPostViews()) + " views");
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, OtherPersonProfileActivity.class);
                i.putExtra("id",post.getIdUser());
                i.putExtra("username",post.getMemberName());
                i.putExtra("image",post.getMemberImage());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

                /*
                Intent i = new Intent(context,FullscreenActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra(op,"Down");
                i.putExtra("op2",mVideos.get(position).getRealName() );
                context.startActivity(i);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("D", position);
                editor.apply();
                Intent intent = new Intent(context, EpisodesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                */
            }
        });
        final int pp = position;

        final Intent intent = new Intent(context,SelectPostActivity.class);
        intent.putExtra("id",post.getId());
        //intent.putExtra("title",post.getPostTitle());
        intent.putExtra("content",post.getPostContent());
        intent.putExtra("date",post.getPostDate());
        intent.putExtra("time",post.getPostTime());
        intent.putExtra("id_user",post.getIdUser());
        intent.putExtra("views",post.getPostViews());
        intent.putExtra("username",post.getMemberName());
        intent.putExtra("image",post.getMemberImage());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        holder.m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(intent);
            }
        });

        holder.Comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(intent);
            }
        });


        if (post.getMemberImage().equals("no_profile")){
            Picasso.with(context)
                    .load(R.drawable.boy)
                    .skipMemoryCache()
                    .into(holder.image);
        }else {
            Picasso.with(context)
                    .load(post.getMemberImage())
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

    public class MemberSpaceHolder extends RecyclerView.ViewHolder{
        ImageView image;
        //TextView title;
        TextView name;
        TextView time;
        TextView content;
        TextView views;
        TextView Comment;
        RelativeLayout m;


        public MemberSpaceHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.post_image);
            name = (TextView)itemView.findViewById(R.id.comment_name);
            time = (TextView)itemView.findViewById(R.id.comments_time);
            content = (TextView)itemView.findViewById(R.id.comments_content);
            views = (TextView)itemView.findViewById(R.id.seens);
            Comment = (TextView)itemView.findViewById(R.id.m_comment);
            m = (RelativeLayout) itemView.findViewById(R.id.memberSpace);
            //title = (TextView)itemView.findViewById(R.id.post_title);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
