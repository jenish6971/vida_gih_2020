package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class allergy extends AppCompatActivity implements allergy_bottomsheet_dialog.BottomSheetListener {

    ImageButton back_from_allergy_java;
    FloatingActionButton add_allergy_btn_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
                allergy_bottomsheet_dialog bottomsheet = new allergy_bottomsheet_dialog();
                bottomsheet.show(getSupportFragmentManager(),"add_allegry_bottomsheet");
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(allergy.this,MainActivity.class));
    }



    // Bottom variable assignment here

    @Override
    public void onButtonClicked(String allergy_named, String allergy_side_effected) {
        // write where the values will go like list view

        // setup recyclerview with the adapter
//        RecyclerView recyclerView = findViewById(R.id.allergy_recycle_view);
//
//        ArrayList<ExampleItem> mExampleList
//
//        mExampleList = new ArrayList<>();
//        mExampleList.add(new ExampleItem(allergy_named,allergy_side_effected));
//

    }
}
