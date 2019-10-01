package ru.polyakov.transferme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.polyakov.transferme.R;
import ru.polyakov.transferme.network.dto.PointsLocal;

public class AdapterAutoComplit extends RecyclerView.Adapter<AdapterAutoComplit.MyViewHolderAutoComplit> {

    private List<PointsLocal> pointsLocals;
    private Context context;

    public AdapterAutoComplit(List<PointsLocal> pointsLocals, Context context) {
        this.pointsLocals = pointsLocals;
        this.context = context;
    }


    @Override
    public MyViewHolderAutoComplit onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolderAutoComplit(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolderAutoComplit holder, int position) {

        holder.tvName.setText(pointsLocals.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return pointsLocals.size();
    }

    public static class MyViewHolderAutoComplit extends RecyclerView.ViewHolder{
        TextView tvName;

        public MyViewHolderAutoComplit(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
