package com.hkr.schoolnote;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// use those annotations provided by the librarys
// map each row in the databse automatically to one of these model objects



@Entity(tableName = "notes")
public class Note {

    //add annotations
    @PrimaryKey
    public int id;

    //add annotations
    @ColumnInfo(name = "contents")
    public String contents;


}
