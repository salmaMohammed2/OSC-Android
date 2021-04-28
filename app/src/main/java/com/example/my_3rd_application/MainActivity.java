package com.example.my_3rd_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ElementAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Button add;
    public static List<Note> noteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button) findViewById(R.id.buttonAdd);
        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        NoteDatabase noteDatabase =NoteDatabase.getInstance(MainActivity.this);
        noteList=noteDatabase.noteDao().getNote();
        adapter=new ElementAdapter(noteDatabase.noteDao().getNote(),getApplicationContext());
        layoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,AddNote.class);
                startActivity(i);
                finish();

            }
        });
        adapter=new ElementAdapter(noteList, getApplicationContext());
        layoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

}