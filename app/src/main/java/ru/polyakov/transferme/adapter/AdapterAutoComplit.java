package ru.polyakov.transferme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.polyakov.transferme.R;
import ru.polyakov.transferme.network.dto.Suggestion;

public class AdapterAutoComplit extends RecyclerView.Adapter<AdapterAutoComplit.MyViewHolderAutoComplit> {

    private List<Suggestion> suggestions;
    private Context context;

    public AdapterAutoComplit(List<Suggestion> suggestions, Context context) {
        this.suggestions = suggestions;
        this.context = context;
    }


    @Override
    public MyViewHolderAutoComplit onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_autocomplit,parent,false);
        return new MyViewHolderAutoComplit(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolderAutoComplit holder, int position) {

        String name = suggestions.get(position).getName();

        holder.tvName.setText(suggestions.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return suggestions.size();
    }

    public static class MyViewHolderAutoComplit extends RecyclerView.ViewHolder{
        TextView tvName;

        public MyViewHolderAutoComplit(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
