package com.example.my_3rd_application;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String noteName;
    @ColumnInfo
    String Description;
    @Ignore
    public Note(String noteName,String Description)
    {
        this.noteName=noteName;
        this.Description=Description;
    }

    public Note(){

    }
    public void setNoteName(String name) {
        noteName = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getNoteName() {
        return noteName;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
