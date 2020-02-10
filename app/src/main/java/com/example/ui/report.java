package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class report extends AppCompatActivity {

    ImageButton back_from_report_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        back_from_report_java = (ImageButton) findViewById(R.id.back_from_report);
        back_from_report_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(report.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(report.this,MainActivity.class));
    }
}
