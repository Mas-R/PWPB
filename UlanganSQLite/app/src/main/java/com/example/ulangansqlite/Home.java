package com.example.ulangansqlite;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Home extends AppCompatActivity {

    @BindView(R.id.rvNotes)
    RecyclerView rvNotes;
    RecyclerView.Adapter adapter;
    List<Note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initViews();
        getNotes();
    }

    private void initViews(){
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getNotes(){
        DatabaseHelper db = new DatabaseHelper(this);
        notesList = db.getAllNotes();
        if(notesList.size()!=0){
            adapter = new NotesAdapter(this, notesList);
            rvNotes.setAdapter(adapter);
        }
    }

    @OnClick(R.id.fabAddNote)
    public void addNote(){
        Intent i = new Intent(Home.this, AddNote.class);
        startActivity(i);
    }
}