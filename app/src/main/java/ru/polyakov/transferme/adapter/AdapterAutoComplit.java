package ru.polyakov.transferme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.polyakov.transferme.R;
import ru.polyakov.transferme.databinding.ItemAutocomplitBinding;
import ru.polyakov.transferme.network.dto.Suggestion;

public class AdapterAutoComplit extends RecyclerView.Adapter<AdapterAutoComplit.MyViewHolderAutoComplit> {

    private List<Suggestion> suggestions;
    private Context context;

    public AdapterAutoComplit(List<Suggestion> suggestions, Context context) {
        this.suggestions = suggestions;
        this.context = context;
    }


    /*

     @Override
    public MyViewHolderAutoComplit onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_autocomplit,parent,false);
        return new MyViewHolderAutoComplit(view);
    }
     */

    @Override
    public MyViewHolderAutoComplit onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemAutocomplitBinding binding = ItemAutocomplitBinding.inflate(inflater,parent,false);
        return  new MyViewHolderAutoComplit(binding.getRoot());

    }

   /* @Override
    public void onBindViewHolder(MyViewHolderAutoComplit holder, int position) {
        holder.tvName.setText(suggestions.get(position).getName());
    }*/

    @Override
    public void onBindViewHolder(MyViewHolderAutoComplit holder, int position) {
        Suggestion suggestion = suggestions.get(position);
        holder.binding.setSuggestion(suggestion);
    }

    @Override
    public int getItemCount() {
        return suggestions.size();
    }

    /*public static class MyViewHolderAutoComplit extends RecyclerView.ViewHolder{
        TextView tvName;

        public MyViewHolderAutoComplit(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }*/

    public static class MyViewHolderAutoComplit extends RecyclerView.ViewHolder{
        ItemAutocomplitBinding binding;

        public MyViewHolderAutoComplit(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
