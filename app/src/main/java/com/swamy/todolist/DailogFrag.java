package com.swamy.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

public class DailogFrag extends DialogFragment  implements  View.OnClickListener{
    EditText task;
    int type;
    Button add,cancle;
    Dialog dialog;
    AlertDialog.Builder alertDialog;
    ImageView brain,hand,money,health,energy;
    SendData sendData;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        type=R.drawable.brain;

        View view=layoutInflater.inflate(R.layout.dialog,null,false);
        alertDialog= new AlertDialog.Builder(requireContext())
                .setView(view);
        dialog=alertDialog.create();
        task=(EditText)view.findViewById(R.id.task);
        add=view.findViewById(R.id.addTask);
        cancle=view.findViewById(R.id.cancle);
        brain=view.findViewById(R.id.brain);
        hand=view.findViewById(R.id.hand);
        energy=view.findViewById(R.id.energy);
        money=view.findViewById(R.id.money);
        health=view.findViewById(R.id.health);
        setTagForImages();
        brain.setOnClickListener(this);
        hand.setOnClickListener(this);
        energy.setOnClickListener(this);
        health.setOnClickListener(this);
        money.setOnClickListener(this);

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskname=task.getText().toString();

                if(!taskname.equals(""))
                {
                    if(sendData!=null)
                    {
                        sendData.addItem(new ItemClass(taskname,type,getBackground(R.drawable.health)));
                        dialog.dismiss();
                    }
                    else
                    {
                        Toast.makeText(getContext(), "failed to add the task", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return dialog;
    }

    private void setTagForImages() {
        brain.setTag(R.drawable.brain);
        hand.setTag(R.drawable.hand);
        energy.setTag(R.drawable.energy);
        health.setTag(R.drawable.health);
        money.setTag(R.drawable.money);
    }

    private int getBackground(int type) {
        switch (type)
        {
            case R.drawable.brain:
                return R.color.brainColor;
            case R.drawable.hand:
                return R.color.handColor;
            case R.drawable.health:
                return R.color.healthColor;
            case R.drawable.money:
                return R.color.moenyColor;
            case R.drawable.energy:
                return R.color.energyColor;
            default:
                Log.d("jk", "getBackground: "+type);
                Log.d("jk", "getBackground: "+R.drawable.brain);
                Log.d("jk", "getBackground: "+R.drawable.hand);
                Log.d("jk", "getBackground: "+R.drawable.health);
                Log.d("jk", "getBackground: "+R.drawable.money);
                Log.d("jk", "getBackground: "+R.drawable.energy);

                return R.color.teal_700;
        }
    }


    @Override
    public void onClick(View view) {
        brain.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.background_desabled_for_box));
        hand.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.background_desabled_for_box));
        health.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.background_desabled_for_box));
        energy.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.background_desabled_for_box));
        money.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.background_desabled_for_box));
        view.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.background_box));
        Log.d("tag", "onClick: "+view.getTag().toString());
        type= Integer.parseInt(view.getTag().toString());

    }
    public void setListener(SendData sendDataListener)
    {
        this.sendData=sendDataListener;
    }

}
