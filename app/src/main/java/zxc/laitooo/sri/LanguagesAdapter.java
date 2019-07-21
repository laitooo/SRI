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
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Laitooo San on 22/06/2019.
 */

public class LanguagesAdapter extends RecyclerView.Adapter<LanguagesAdapter.LanguagesHolder> {

    private ArrayList<String> list;
    private Context context;

    public LanguagesAdapter(ArrayList<String> l,Context m){
        this.list = l;
        this.context = m;
    }


    @Override
    public LanguagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text,parent,false);
        return new LanguagesHolder(v);
    }

    @Override
    public void onBindViewHolder(LanguagesHolder holder, final int position) {

        final String lang = list.get(position);

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(),lang,Toast.LENGTH_SHORT).show();
            }
        });
        holder.text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //MyDialog dialog = new MyDialog(context ,4,list,position,adapterLanguages);
                //dialog.show(getActivity().getFragmentManager(),"My Dialog");
                return true;
            }
        });

        holder.text.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LanguagesHolder extends RecyclerView.ViewHolder{
        TextView text;

        public LanguagesHolder(View itemView) {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.LangText);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
