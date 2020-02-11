package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class user_detail extends AppCompatActivity {

    private Spinner bg,gender;
    private DatePicker picker;
    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        bg = (Spinner)findViewById(R.id.blood_spinner);
        gender = (Spinner)findViewById(R.id.gender_spinner);
        picker = (DatePicker)findViewById(R.id.datePicker1);
        next = (ImageButton) findViewById(R.id.user_detail_next_btn);

        final int month = picker.getMonth();
        final int day = picker.getDayOfMonth();
        final int year = picker.getYear();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(user_detail.this,
                        "Details Submitted : " +
                                "\nBlood Group : " + (bg.getSelectedItem()) +
                                "\nGender : " + (gender.getSelectedItem()) +
                                "\nDate:"+ day + month + year,
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(user_detail.this, MainActivity.class));
                finish();
            }
        });


    }
}
