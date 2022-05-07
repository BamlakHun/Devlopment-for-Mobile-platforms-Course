package com.hkr.schoolnote;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    public static class NoteViewHolder extends RecyclerView.ViewHolder{
        LinearLayout containerView;
        TextView textView;

        // Create constructor

        NoteViewHolder(View view){
            super(view);
            containerView = view.findViewById(R.id.note_row);
            textView = view.findViewById(R.id.note_row_text);


            containerView.setOnClickListener(v -> {
                Note current = (Note) containerView.getTag();
                Intent intent = new Intent(v.getContext(), NoteActivity.class);
                intent.putExtra("id", current.id);
                intent.putExtra("contents", current.contents);

                v.getContext().startActivity(intent);

            });
        }
    }

    // create a list for notes
    private List<Note> notes = new ArrayList<>();


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row, parent, false);

        return new NoteViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        Note current = notes.get(position); // get note
        holder.textView.setText(current.contents);  // set it to be text if for the view
        holder.containerView.setTag(current);  // get number of notes

    }
    @Override
    public int getItemCount(){ // get number of notes
        return notes.size();

    }
    public void reload(){
        notes = MainActivity.database.noteDataAccessObject().getAllNotes();
        notifyDataSetChanged();
    }
}
