package com.example.latihan3layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Masuk2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk2);
        TextView t = (TextView) findViewById(R.id.text_viewdata1);
        TextView w = (TextView) findViewById(R.id.text_viewdata2);
        Bundle bundle = getIntent().getExtras();
        String j = bundle.getString( "name");
        String s = j;
        String jawab = "";
        if (s.equals("897544")){
            jawab = "Selamat Anda Telah Memasuki Ruangan Ini";
        }
        else{
            jawab = "Kode salah silahkan coba lagi";
        }
        t.setText(s);
        w.setText(jawab);
    }
}