package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class report extends AppCompatActivity {

    ImageButton back_from_report_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // setup recyclerview with the adapter
        RecyclerView recyclerView = findViewById(R.id.report_recycle_view);

        List<item_report> mlist = new ArrayList<>();
        mlist.add(new item_report("Report A","19/06/2014"));
        mlist.add(new item_report("Report B","19/06/2015"));
        mlist.add(new item_report("Report C","19/06/2016"));
        mlist.add(new item_report("Report D","19/06/2017"));
        mlist.add(new item_report("Report E","19/06/2018"));
        mlist.add(new item_report("Report F","19/06/2019"));
        adapter_report.Adapter adapter = new adapter_report.Adapter(this,mlist);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
