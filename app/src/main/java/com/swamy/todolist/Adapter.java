package com.swamy.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<ItemClass> list;
    SendData sendData;

    public Adapter(Context context, List<ItemClass> list,SendData sendDataListener) {
        this.context = context;
        this.list = list;
        this.sendData=sendDataListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getName());
        holder.imageView.setImageResource(list.get(position).getImg());
        holder.cardView.setCardBackgroundColor(list.get(position).getBackground_color());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData.delete(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
