package com.hkr.schoolnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {
    private EditText editText;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        editText = findViewById(R.id.edit_note_text);

        String contents = getIntent().getStringExtra("contents");
        id = getIntent().getIntExtra("id", 0);
        editText.setText(contents);

    }
    @Override
    protected void onPause(){
        super.onPause();
        MainActivity.database.noteDataAccessObject().save(editText.getText().toString(), id);

    }
}
