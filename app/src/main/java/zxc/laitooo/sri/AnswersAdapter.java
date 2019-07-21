package zxc.laitooo.sri;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.Date;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.UserData;

/**
 * Created by Zizo on 2/5/2018.
 */
public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.AnswersHolder> {

    private ArrayList<Answer> list;
    private Context context;

    public AnswersAdapter(ArrayList<Answer> l, Context c){
        this.list = l;
        this.context = c;
    }


    @Override
    public AnswersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer,parent,false);
        return new AnswersHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnswersHolder holder, int position) {
        final Answer answer = list.get(position);

        if (answer.getImage().equals("no_profile")){
            Picasso.with(context)
                    .load(R.drawable.boy)
                    .skipMemoryCache()
                    .into(holder.image);
        }else {
            Picasso.with(context)
                    .load(answer.getImage())
                    .skipMemoryCache()
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(holder.image);
        }
        holder.name.setText(answer.getName());
        holder.time.setText(answer.getTime());
        //holder.image.setImageResource(list.get(position).getVideoImage());
        holder.content.setText(answer.getContent());
        holder.votes.setText(String.valueOf(answer.getVotes()));

        final ArrayList<Reply> listReplies = new ArrayList<>();
        holder.recycler.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(context);
        holder.recycler.setLayoutManager(layoutManager2);
        final RepliesAdapter repliesAdapter = new RepliesAdapter(listReplies,context);
        holder.recycler.setAdapter(repliesAdapter);

        Map<String ,String> map = new HashMap<>();
        map.put("id_answer",String.valueOf(answer.getId()));
        NetworkTask task = new NetworkTask(true, Constants.SELECTED_ANSWER_REPLIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = object.getJSONArray("answer_replies");
                    for (int i=0;i<array.length();i++){
                        JSONObject reply = array.getJSONObject(i);
                        listReplies.add(new Reply(reply.getInt("id_answer"),
                                reply.getInt("id_user"),reply.getString("content"),
                                reply.getString("date"),reply.getString("time"),
                                reply.getString("username"),reply.getString("image")));
                    }
                    repliesAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, context, map,false);
        task.executeTask();




        holder.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Content = holder.newComment.getText().toString();
                if (!(Content.equals(""))) {
                    final UserData userData = new UserData(context);
                    final Map<String, String> mapSend = new HashMap<>();
                    mapSend.put("id_answer", String.valueOf(answer.getId()));
                    mapSend.put("id_user", String.valueOf(userData.getId()));
                    mapSend.put("content", Content);
                    mapSend.put("date", Date.getDate());
                    mapSend.put("time", Date.getTime());
                    NetworkTask task = new NetworkTask(true, Constants.ADD_ANSWER_REPLY, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            try {
                                JSONObject object = new JSONObject(s);
                                if (!object.getBoolean("error")){
                                    listReplies.add(listReplies.size(),new Reply(answer.getId(),userData.getId(),
                                            Content,Date.getDate(),Date.getTime(),userData.getUserName(),
                                            userData.getImageUrl()));
                                    Toast.makeText(context, object.getString("message"), Toast.LENGTH_LONG).show();
                                    repliesAdapter.notifyDataSetChanged();
                                }else {
                                    Toast.makeText(context, object.getString("message")
                                            , Toast.LENGTH_LONG).show();
                                }
                                repliesAdapter.notifyDataSetChanged();
                                /*new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        adapter.notifyDataSetChanged();
                                    }
                                }, 500);*/
                            } catch (JSONException e) {
                                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }, context, mapSend);
                    task.executeTask();
                }else {
                    Toast.makeText(context,"All fields are required",
                            Toast.LENGTH_LONG).show();
                }
                repliesAdapter.notifyDataSetChanged();
                holder.newComment.setText("");
            }
        });






        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String, String> map = new HashMap<>();
                map.put("id_answer", String.valueOf(answer.getId()));
                map.put("id_user", String.valueOf(new UserData(context).getId()));
                map.put("is_plus","true");
                NetworkTask task = new NetworkTask(true, Constants.VOTE_ANSWER, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            if (!object.getBoolean("error")){
                                holder.votes.setText(String.valueOf(object.getInt("votes")));
                                answer.setVotes(object.getInt("votes"));
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
                map.put("id_answer", String.valueOf(answer.getId()));
                map.put("id_user", String.valueOf(new UserData(context).getId()));
                map.put("is_plus","false");
                NetworkTask task = new NetworkTask(true, Constants.VOTE_ANSWER, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            if (!object.getBoolean("error")){
                                holder.votes.setText(String.valueOf(object.getInt("votes")));
                                answer.setVotes(object.getInt("votes"));
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
    public int getItemCount() {
        return list.size();
    }

    public class AnswersHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView time;
        ImageView image;
        TextView content;
        RecyclerView recycler;
        EditText newComment;
        ImageButton send;
        ImageButton plus;
        ImageButton minus;
        TextView votes;


        public AnswersHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.answer_image);
            name = (TextView)itemView.findViewById(R.id.answer_name);
            time = (TextView)itemView.findViewById(R.id.answer_time);
            content = (TextView)itemView.findViewById(R.id.answer_content);
            recycler = (RecyclerView)itemView.findViewById(R.id.recycler_answers_comments);
            newComment = (EditText)itemView.findViewById(R.id.new_comment);
            send = (ImageButton)itemView.findViewById(R.id.send_comment);
            plus = (ImageButton)itemView.findViewById(R.id.plus_vote);
            minus = (ImageButton)itemView.findViewById(R.id.minus_vote);
            votes = (TextView) itemView.findViewById(R.id.number_votes);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
