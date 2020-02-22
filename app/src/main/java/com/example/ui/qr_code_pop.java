package com.example.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class qr_code_pop extends Activity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_code_bottomsheet);

        textView = findViewById(R.id.uid_text);
        imageView = findViewById(R.id.qr_image);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        User u = SharedPref.getInstance(this).getUser();
        textView.setText(u.getAadhaar_id().trim());
        profile Profile = new profile();
        imageView.setImageBitmap(Profile.qrGenerate());

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.5));
    }

}
