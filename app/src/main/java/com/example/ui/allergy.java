package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class allergy extends AppCompatActivity {

    ImageButton back_from_allergy_java;
    FloatingActionButton add_allergy_btn_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy);

        back_from_allergy_java = (ImageButton) findViewById(R.id.back_from_allergy);
        add_allergy_btn_java = (FloatingActionButton) findViewById(R.id.add_allergy_btn);

        back_from_allergy_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(allergy.this, MainActivity.class));
                finish();
            }
        });

        add_allergy_btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(allergy.this,MainActivity.class));
    }
}
