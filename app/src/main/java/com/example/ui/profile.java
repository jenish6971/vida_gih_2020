package com.example.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class profile extends AppCompatActivity {

    ImageButton back_from_profile_java, log_out;
    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    TextView fname, bg, uid, gender, dob, address;
    ImageView qr_code, imageView;
    String path = "";
    FloatingTextButton ftb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        qr_code = findViewById(R.id.qr_code);
        qr_code.setImageBitmap(qrGenerate());

        if (!SharedPref.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, login.class));
        }

        fname = findViewById(R.id.user_name);
        bg = findViewById(R.id.blood_group);
        uid = findViewById(R.id.user_uid);
        gender = findViewById(R.id.gender);
        dob = findViewById(R.id.dob);
        address = findViewById(R.id.address);
        back_from_profile_java = (ImageButton) findViewById(R.id.back_from_profile);
        log_out = findViewById(R.id.logout_btn);
        ftb = findViewById(R.id.print_health_card_btn);

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

                AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);

                builder.setIcon(R.drawable.ic_warning_black_24dp);

                builder.setTitle("Logout");

                builder.setMessage("Are you sure you want to Logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPref.getInstance(getApplicationContext()).logout();
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });


        ftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Take Screenshot",Toast.LENGTH_LONG).show();
            }
        });


    }

    public Bitmap qrGenerate() {

        User u = SharedPref.getInstance(this).getUser();
        String info = u.getAadhaar_id().trim();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = multiFormatWriter.encode(info, BarcodeFormat.QR_CODE, 350, 350);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
        return bitmap;
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(profile.this, MainActivity.class));
        finish();
    }


    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/VIDA" + now + ".jpeg";

            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);


            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            //setting screenshot in imageview
            String filePath = imageFile.getPath();

            Bitmap ssbitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            imageView.setImageBitmap(ssbitmap);
            path = filePath;

        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }


}
