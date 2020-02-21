package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.health.ServiceHealthStats;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    ImageButton back_from_profile_java,log_out;

    TextView fname,bg,uid,gender,dob,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        if (!SharedPref.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, login.class));
        }
        fname=findViewById(R.id.user_name);
        bg=findViewById(R.id.blood_group);
        uid=findViewById(R.id.user_uid);
        gender=findViewById(R.id.gender);
        dob=findViewById(R.id.dob);
        address=findViewById(R.id.address);
        back_from_profile_java = (ImageButton) findViewById(R.id.back_from_profile);
        log_out=findViewById(R.id.logout_btn);

        final User user = SharedPref.getInstance(this).getUser();

        uid.setText(user.getAadhaar_id());
        fname.setText(user.getF_name());
        gender.setText(user.getGender());
        dob.setText(user.getDob());
        address.setText(user.getAddress());

        back_from_profile_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile.this, MainActivity.class));
                finish();
            }
        });


        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getInstance(getApplicationContext()).logout();
            }
        });



    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(profile.this,MainActivity.class));
    }
}
