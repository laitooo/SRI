package zxc.laitooo.sri;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.lujun.androidtagview.TagContainerLayout;
import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.QuestionTags;
import zxc.laitooo.sri.data.UserData;

/**
 * Created by Zizo on 12/12/2017.
 */
public class QuestionsAdapter  extends RecyclerView.Adapter<QuestionsAdapter.QuestionHolder>{

    private ArrayList<Question> list;
    private Context context;
    private QuestionTags questionTags;

    public QuestionsAdapter(ArrayList<Question> l, Context m){
        this.list = l;
        this.context = m;
        questionTags = new QuestionTags(context);
    }

    @Override
    public QuestionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.questions,parent,false);
        return new QuestionHolder(v);
    }

    @Override
    public void onBindViewHolder(final QuestionHolder holder, int position) {

        /*
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap m = BitmapFactory.decodeFile(String.valueOf(list.get(position).getMemberImage()), options);
        Bitmap k = BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.aaa,options);
        holder.imageView.setImageBitmap(k);
        */
        final Question question = list.get(position);
        holder.title.setText(question.getTitle());
        holder.name.setText(question.getName());
        holder.time.setText(question.getTime());
        holder.content.setText(question.getContent());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context,SelectQuestionActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("id",question.getId());
                i.putExtra("questionTitle", question.getTitle());
                i.putExtra("questionName",question.getName());
                i.putExtra("questionTime",question.getTime());
                i.putExtra("questionContent",question.getContent());
                i.putExtra("tags",question.getTags());
                i.putExtra("votes",question.getVotes());
                i.putExtra("image",question.getImage());
                context.startActivity(i);

            }
        });


        if (question.getImage().equals("no_profile")){
            Picasso.with(context)
                    .load(R.drawable.boy)
                    .skipMemoryCache()
                    .into(holder.imageView);
        }else {
            Picasso.with(context)
                    .load(question.getImage())
                    .skipMemoryCache()
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(holder.imageView);
        }

        ArrayList<String> tags = new ArrayList<>();
        for (int i=0;i<question.getTags().length();i++){
            tags.add(questionTags.getTagName(question.getTags().substring(i,i+1)));
        }
        holder.tagView.setTags(tags);
        holder.votes.setText(String.valueOf(question.getVotes()));


        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String, String> map = new HashMap<>();
                map.put("id_question", String.valueOf(question.getId()));
                map.put("id_user", String.valueOf(new UserData(context).getId()));
                map.put("is_plus","true");
                NetworkTask task = new NetworkTask(true, Constants.VOTE_QUESTION, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            if (!object.getBoolean("error")){
                                holder.votes.setText(String.valueOf(object.getInt("votes")));
                                question.setVotes(object.getInt("votes"));
                            }else {
                                Toast.makeText(context, object.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, context, map,false);
                task.executeTask();
            }
        });


        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String, String> map = new HashMap<>();
                map.put("id_question", String.valueOf(question.getId()));
                map.put("id_user", String.valueOf(new UserData(context).getId()));
                map.put("is_plus","false");
                NetworkTask task = new NetworkTask(true, Constants.VOTE_QUESTION, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            if (!object.getBoolean("error")){
                                holder.votes.setText(String.valueOf(object.getInt("votes")));
                                question.setVotes(object.getInt("votes"));
                            }else {
                                Toast.makeText(context, object.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, context, map,false);
                task.executeTask();
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

    public class QuestionHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView name;
        TextView time;
        TextView content;
        TextView answer;
        //TextView comment;
        RelativeLayout layout;
        TagContainerLayout tagView;
        ImageButton plus;
        ImageButton minus;
        TextView votes;

        public QuestionHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.post_image);
            title = (TextView)itemView.findViewById(R.id.ques_name_textview);
            name = (TextView)itemView.findViewById(R.id.comments_time);
            time = (TextView)itemView.findViewById(R.id.question_time);
            content = (TextView)itemView.findViewById(R.id.comments_content);
            answer = (TextView)itemView.findViewById(R.id.ans);
            //comment = (TextView)itemView.findViewById(R.id.comment);
            layout = (RelativeLayout)itemView.findViewById(R.id.layoutQuestion);
            tagView = (TagContainerLayout)itemView.findViewById(R.id.tagview);
            plus = (ImageButton) itemView.findViewById(R.id.plus_vote);
            minus = (ImageButton) itemView.findViewById(R.id.minus_vote);
            votes = (TextView)itemView.findViewById(R.id.number_votes);

        }
    }

}
