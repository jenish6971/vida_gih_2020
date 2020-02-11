package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class register extends AppCompatActivity {

    private EditText email,pass,conpass;
    private ImageButton next,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        email = (EditText)findViewById(R.id.signup_email_edittxt);
        pass = (EditText)findViewById(R.id.signup_pass_edittxt);
        conpass = (EditText)findViewById(R.id.signup_con_pass_edittxt);
        next = (ImageButton) findViewById(R.id.signup_next_btn);
        back = (ImageButton) findViewById(R.id.signup_back_btn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this, user_detail.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this, login.class));
                finish();
            }
        });

    }
}
