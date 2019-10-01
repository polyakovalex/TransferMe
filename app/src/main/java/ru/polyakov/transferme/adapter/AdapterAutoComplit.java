package ru.polyakov.transferme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.polyakov.transferme.R;
import ru.polyakov.transferme.network.dto.PrepareQuery;

public class AdapterAutoComplit extends RecyclerView.Adapter<AdapterAutoComplit.MyViewHolderAutoComplit> {

    private List<PrepareQuery> prepareQueries;
    private Context context;

    public AdapterAutoComplit(List<PrepareQuery> pointsLocals, Context context) {
        this.prepareQueries = prepareQueries;
        this.context = context;
    }


    @Override
    public MyViewHolderAutoComplit onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolderAutoComplit(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolderAutoComplit holder, int position) {

        holder.tvName.setText(prepareQueries.get(position).getSuggestions().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return prepareQueries.size();
    }

    public static class MyViewHolderAutoComplit extends RecyclerView.ViewHolder{
        TextView tvName;

        public MyViewHolderAutoComplit(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
