package eostest.android.com.customview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hjx on 2018/10/25 .
 */
public class TopViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList data;


    public TopViewAdapter(Context context, ArrayList data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top, viewGroup, false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MViewHolder) viewHolder).content.setText(data.get(i).toString());
        ((MViewHolder) viewHolder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MViewHolder extends RecyclerView.ViewHolder {

        TextView content;
        View itemView;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            content = itemView.findViewById(R.id.content);
        }
    }

    interface ItemLongListener {
        void onLongListener();
    }
}
