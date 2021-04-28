package com.example.my_3rd_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static java.lang.Integer.parseInt;

public class EditDeleteNote extends AppCompatActivity {

    EditText name;
    EditText description;
    Button edit;
    Button delete;
    Button back;
    MainActivity mainActivity=new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_note);
        name=(EditText)findViewById(R.id.editTextNoteName);
        description=(EditText)findViewById(R.id.editTextDescription);
        edit=(Button)findViewById(R.id.save);
        delete=(Button)findViewById(R.id.delete);
        back=(Button)findViewById(R.id.back);
        Bundle b=getIntent().getExtras();
        name.setText(b.getString("key1"));
        description.setText(b.getString("key2"));
        NoteDatabase noteDatabase =NoteDatabase.getInstance(EditDeleteNote.this);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note=new Note();
                //Bundle b=getIntent().getExtras();
                note.setId(Integer.parseInt(b.getString("id")));
                //note.setNoteName(b.getString("key1"));
                //note.setDescription(b.getString("key2"));
                note.setNoteName(name.getText().toString());
                note.setDescription(description.getText().toString());
                noteDatabase.noteDao().updateNote(note);
                Toast.makeText(EditDeleteNote.this,"Updeted",Toast.LENGTH_SHORT).show();
                Intent i =new Intent(EditDeleteNote.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note=new Note();
                Bundle b=getIntent().getExtras();
                note.setId(Integer.parseInt(b.getString("id")));
                note.setNoteName(b.getString("key1"));
                note.setDescription(b.getString("key2"));
                noteDatabase.noteDao().deleteNote(note);
                Toast.makeText(EditDeleteNote.this,"Deleted",Toast.LENGTH_SHORT).show();
                Intent i =new Intent(EditDeleteNote.this,MainActivity.class);
                startActivity(i);
                finish();


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(EditDeleteNote.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });



    }

}