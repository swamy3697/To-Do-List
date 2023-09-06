package com.swamy.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SendData {
    FloatingActionButton fab;
    List<ItemClass> items;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab=(FloatingActionButton) findViewById(R.id.add);
        items=new ArrayList<ItemClass>();
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         adapter=new Adapter(getApplicationContext(),items,this);
        recyclerView.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DailogFrag dailogFrag=new DailogFrag();
                dailogFrag.setListener(MainActivity.this);
                dailogFrag.show(getSupportFragmentManager(), "frag");
            }
        });

    }

    @Override
    public void addItem(ItemClass itemClass) {
        items.add(itemClass);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void delete(int pos) {
        items.remove(pos);
        adapter.notifyDataSetChanged();

    }
}