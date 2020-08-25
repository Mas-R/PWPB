package com.example.parcelable;

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
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;
    private int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity =
                (Button)findViewById(R.id.btn_move_with_data_activity);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject =
                (Button)findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);
        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);
        btnMoveResult = findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this,

                        Activity_Move.class);
                startActivity(moveIntent);

                break;

            case R.id.btn_move_with_data_activity:
                Intent moveWithDataIntent = new Intent(MainActivity.this,
                        Activity_move_with_data.class);
                moveWithDataIntent.putExtra(Activity_move_with_data.EXTRA_NAME,
                        "Muhammad Aslam Setiawan Riziq");
                moveWithDataIntent.putExtra(Activity_move_with_data.EXTRA_AGE,
                        16);
                startActivity(moveWithDataIntent);

                break;

            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("Muhammad Aslam Setiawan Riziq");
                mPerson.setAge(16);

                mPerson.setEmail("muh.aslam.s.r@gmail.com");

                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this,
                        Activity_move_with_object.class);
                moveWithObjectIntent.putExtra(Activity_move_with_object.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);

                break;

            case R.id.btn_dial_number:
                String phoneNumber = "088218629454";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);

                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this,
                        Activity_move_for_result.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity_move_for_result.RESULT_CODE) {
                int selectedValue =
                        data.getIntExtra(Activity_move_for_result.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}