package com.hkr.schoolnote;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities =  {Note.class}, version = 1)
// use the bodys and objects in roomDB that are available hence
// implement abstract
public abstract class NoteDB extends RoomDatabase {
    // make use of the room library generated by annotation
    public abstract NoteDataAccessObject noteDataAccessObject();


}
