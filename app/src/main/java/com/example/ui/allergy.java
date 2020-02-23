package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class allergy extends AppCompatActivity implements allergy_bottomsheet_dialog.BottomSheetListener {

    ImageButton back_from_allergy_java;
    FloatingActionButton add_allergy_btn_java;
    RecyclerView recyclerView ;
    ArrayList<item_allergy> mlist;
    adapter_allergy.Adapter adapter;
    User user = SharedPref.getInstance(this).getUser();
    String aid=user.getAadhaar_id();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recyclerView = findViewById(R.id.allergy_recycle_view);

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

        fatch_data();
    }

    private void fatch_data() {

        StringRequest stringRequest= new StringRequest(Request.Method.POST, Constants.REPORT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // JSONObject object=new JSONObject(response);
                            mlist =new ArrayList<>() ;
                            JSONArray jsonArray=new JSONArray(response);
                            // Toast.makeText(getApplicationContext(),String.valueOf(jsonArray.length()),Toast.LENGTH_LONG).show();
                            for (int i=0;i<jsonArray.length();i++){
                                //JSONArray jsonArray=object.getJSONArray(i);
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                mlist.add(new item_allergy(jsonObject.getString("allergy_name"),
                                        jsonObject.getString("allergy_side_effects")));

                            }
                            setupRecycler();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                           // Toast.makeText(getApplicationContext(),"error..",Toast.LENGTH_LONG).show();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("aadhaar_id",aid);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }

    private void setupRecycler() {
        adapter=new adapter_allergy.Adapter(this,mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
