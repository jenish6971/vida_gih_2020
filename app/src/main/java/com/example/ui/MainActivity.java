package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.BlurMaskFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import eightbitlab.com.blurview.BlurView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton qr_code_btn_java;
    CardView report_btn_java, allergy_btn_java, history_btn_java;
    ImageButton user_profile_btn_java;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        qr_code_btn_java = (FloatingActionButton) findViewById(R.id.qr_code_btn);
        report_btn_java = (CardView) findViewById(R.id.report_btn);
        allergy_btn_java = (CardView) findViewById(R.id.allergy_btn);
        history_btn_java = (CardView) findViewById(R.id.history_btn);
        user_profile_btn_java = (ImageButton) findViewById(R.id.user_profile_btn);


        user_profile_btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, profile.class));
                finish();
            }
        });

        report_btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, report.class));
                finish();
            }
        });

        allergy_btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, allergy.class));
                finish();
            }
        });

        history_btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, history.class));
                finish();
            }
        });

        qr_code_btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, qr_code_pop.class));
            }
        });

    }

}
