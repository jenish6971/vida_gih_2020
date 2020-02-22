package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class profile extends AppCompatActivity {

    ImageButton back_from_profile_java,log_out;
    MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
    TextView fname,bg,uid,gender,dob,address;
    ImageView qr_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        qr_code=findViewById(R.id.qr_code);
        qr_code.setImageBitmap(qrGenerate());

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

    public Bitmap qrGenerate(){

            User u = SharedPref.getInstance(this).getUser();
            String info = u.getAadhaar_id().trim();
        BitMatrix bitMatrix= null;
        try {
            bitMatrix = multiFormatWriter.encode(info, BarcodeFormat.QR_CODE,250,250);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
        Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
        return bitmap;
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(profile.this,MainActivity.class));
    }
}
