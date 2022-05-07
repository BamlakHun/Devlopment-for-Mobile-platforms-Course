package com.hkr.schoolnote;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDataAccessObject {

    // add annotation
    // access table
    @Query("INSERT INTO NOTES (contents) VALUES ('New note')")
    void create();

    // add annotation
    // select query
    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();

    // add annotation
    // save data
    @Query("UPDATE notes SET contents =:contents WHERE id = :id")
    void save(String contents, int id );



}
