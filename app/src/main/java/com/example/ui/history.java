package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class history extends AppCompatActivity {

    ImageButton back_from_history_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        back_from_history_java = (ImageButton) findViewById(R.id.back_from_history);

        back_from_history_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(history.this, MainActivity.class));
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(history.this,MainActivity.class));
    }
}
