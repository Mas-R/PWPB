package com.example.latihan3layout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    public Button btnMoveActivity;
    public Button btnMoveWithDataActivity;
    public Button btnMoveWithObject;
    public Button btnMoveActivity1;
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;
    private int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity1 = (Button)findViewById(R.id.btn_masuk);
        btnMoveActivity1.setOnClickListener(this);
        btnMoveActivity = (Button)findViewById(R.id.btn_Dapur);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity =
                (Button)findViewById(R.id.btn_Taman);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject =
                (Button)findViewById(R.id.btn_Ruangtamu);
        btnMoveWithObject.setOnClickListener(this);
        btnMoveResult = findViewById(R.id.btn_Kode);
        btnMoveResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_masuk:
                Intent moveIntent1 = new Intent(MainActivity.this,

                        Masuk.class);
                startActivity(moveIntent1);

                break;

            case R.id.btn_Dapur:
                Intent moveIntent2 = new Intent(MainActivity.this,

                        Dapur.class);
                startActivity(moveIntent2);

                break;

            case R.id.btn_Taman:
                Intent moveIntent3 = new Intent(MainActivity.this,

                        Taman.class);
                startActivity(moveIntent3);

                break;
            case R.id.btn_Ruangtamu:
                Intent moveIntent4 = new Intent(MainActivity.this,

                        RuangTamu.class);
                startActivity(moveIntent4);

                break;

            case R.id.btn_Kode:
                Intent moveForResultIntent = new Intent(MainActivity.this,
                        Kode.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Kode.RESULT_CODE) {
                int selectedValue =
                        data.getIntExtra(Kode.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Kodenya adalah : %s", selectedValue));
            }
        }
    }
}