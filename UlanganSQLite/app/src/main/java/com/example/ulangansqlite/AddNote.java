package com.example.ulangansqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class
AddNote extends AppCompatActivity {
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_ISI = "extra_isi";
    public static final String EXTRA_NAME = "extra_name";
    boolean edit;
    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.etContent)

    EditText etIsi;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);


        ImageView save = (ImageView) findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveNote();
            }
        });

        ImageView hapus = (ImageView) findViewById(R.id.deleteButton);

        if(getIntent().getStringExtra(EXTRA_NAME) == null){
            edit = false;
            hapus.setVisibility(View.INVISIBLE);
        }else{
            edit = true;
            etIsi.setText(getIntent().getStringExtra(EXTRA_ISI));
            etTitle.setText(getIntent().getStringExtra(EXTRA_NAME));

            hapus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DatabaseHelper db = new DatabaseHelper(AddNote.this);
                    db.delete(getIntent().getStringExtra(EXTRA_ID));
                    back();
                }
            });
        }
    }

    private void saveNote(){
        Date tanggal = Calendar.getInstance().getTime();
        String judul = etTitle.getText().toString();
        String isi = etIsi.getText().toString();

        if(judul.equals("") || isi.equals("")){
            showToast("Isi terlebih dahulu");
        }else{
            DatabaseHelper db = new DatabaseHelper(this);
            if(edit==true){
                Note note = new Note(judul, isi, tanggal.toString(), getIntent().getStringExtra(EXTRA_ID));
                db.update(note);
            }else{
                Note note = new Note(judul, isi, tanggal.toString());
                db.insert(note);
            }
            db.close();
            back();
        }
    }

    private void back(){
        Intent i = new Intent(AddNote.this, Home.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_save){
            saveNote();
        }

        return super.onOptionsItemSelected(item);
    }
}
