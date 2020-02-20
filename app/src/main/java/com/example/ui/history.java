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

public class history extends AppCompatActivity {

    ImageButton back_from_history_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // setup recyclerview with the adapter
        RecyclerView recyclerView = findViewById(R.id.history_recycle_view);

        List<item_history> mlist = new ArrayList<>();
        mlist.add(new item_history("Cholera","Dr.Jenish Dhanani","19/06/2014"));
        mlist.add(new item_history("Cold","Dr.Jenish Dhanani","19/06/2015"));
        mlist.add(new item_history("Plague","Dr.Jenish Dhanani","19/06/2016"));
        mlist.add(new item_history("Cold","Dr.Jenish Dhanani","19/06/2017"));
        mlist.add(new item_history("Cold","Dr.Jenish Dhanani","19/06/2018"));
        adapter_history.Adapter adapter = new adapter_history.Adapter(this,mlist);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


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
