package com.example.belajar_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.belajarintent.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button explicitIntent;
    Button implicitIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        explicitIntent = (Button)findViewById(R.id.explicitIntent);
        explicitIntent.setOnClickListener(this);
        implicitIntent = (Button)findViewById(R.id.implicitIntent);
        implicitIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.explicitIntent:
                Intent explicit = new Intent(MainActivity.this,Activity_Intent.class);
                startActivity(explicit);
                break;
            case R.id.implicitIntent:
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.w3school.com"));
                startActivity(implicit);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}