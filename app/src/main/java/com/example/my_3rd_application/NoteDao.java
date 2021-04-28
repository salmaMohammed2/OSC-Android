package com.example.my_3rd_application;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

// Database(Data Access Object)
@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNote(Note note);

    @Query("select* from Note")
    public List<Note> getNote();

    @Delete
    public void deleteNote(Note note);

   @Update
    public  void updateNote(Note note);
}
