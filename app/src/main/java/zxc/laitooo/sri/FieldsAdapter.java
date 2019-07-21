package zxc.laitooo.sri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Laitooo San on 22/06/2019.
 */

public class FieldsAdapter extends RecyclerView.Adapter<FieldsAdapter.FieldsHolder> {

    private ArrayList<String> list;
    private Context context;

    public FieldsAdapter(ArrayList<String> l,Context m){
        this.list = l;
        this.context = m;
    }


    @Override
    public FieldsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text,parent,false);
        return new FieldsHolder(v);
    }

    @Override
    public void onBindViewHolder(FieldsHolder holder, final int position) {

        final String field = list.get(position);

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(),field,Toast.LENGTH_SHORT).show();
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

    public class FieldsHolder extends RecyclerView.ViewHolder{
        TextView text;

        public FieldsHolder(View itemView) {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.LangText);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
