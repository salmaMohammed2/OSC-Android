package com.example.my_3rd_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        EditText name=(EditText)findViewById(R.id.editTextNoteName);
        EditText description=(EditText)findViewById(R.id.editTextDescription);
        Button add=(Button)findViewById(R.id.save);
        Button back=(Button)findViewById(R.id.back);
        NoteDatabase noteDatabase =NoteDatabase.getInstance(AddNote.this);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note=new Note(name.getText().toString(),description.getText().toString());
                MainActivity.noteList.add(note);
                noteDatabase.noteDao().insertNote(note);
                Toast.makeText(AddNote.this,"Your Note Added successfully",Toast.LENGTH_LONG).show();
                Intent i =new Intent(AddNote.this,MainActivity.class);
                startActivity(i);
                finish();


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(AddNote.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });


    }
}