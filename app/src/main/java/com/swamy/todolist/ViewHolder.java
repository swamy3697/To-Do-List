package com.swamy.todolist;

import android.animation.Animator;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    ImageView imageView;

    Button btn;
    CardView cardView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.taskDiscription);
        imageView=itemView.findViewById(R.id.img);
        cardView=itemView.findViewById(R.id.cardView);
        btn=itemView.findViewById(R.id.btn);

    }
}
