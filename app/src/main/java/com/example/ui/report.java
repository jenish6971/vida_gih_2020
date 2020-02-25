package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class report extends AppCompatActivity {

    ImageButton back_from_report_java;
    ImageButton report_save_pdf_btn;
    RecyclerView recyclerView ;
    ArrayList<item_report> mlist;
    adapter_report.Adapter adapter;
    User user = SharedPref.getInstance(this).getUser();
    String aid=user.getAadhaar_id();
    String report_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // setup recyclerview with the adapter
        recyclerView = findViewById(R.id.report_recycle_view);

         mlist = new ArrayList<>();
//        mlist.add(new item_report("Report A","19/06/2014"));
//        mlist.add(new item_report("Report B","19/06/2015"));
//        mlist.add(new item_report("Report C","19/06/2016"));
//        mlist.add(new item_report("Report D","19/06/2017"));
//        mlist.add(new item_report("Report E","19/06/2018"));
//        mlist.add(new item_report("Report F","19/06/2019"));
        //adapter_report.Adapter adapter = new adapter_report.Adapter(this,mlist);
//
//        recyclerView.setAdapter(adapter);
       //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fatch_data();
        report_save_pdf_btn=findViewById(R.id.report_save_pdf_btn);
//        report_save_pdf_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
//                startActivity(browserIntent);
//            }
//        });

        back_from_report_java = (ImageButton) findViewById(R.id.back_from_report);
        back_from_report_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(report.this, MainActivity.class));
                finish();
            }
        });




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
                                mlist.add(new item_report(jsonObject.getString("report"),
                                        jsonObject.getString("report_date")));
                                 report_link= jsonObject.getString("report_link");

                            }
                            setupRecycler();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
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
        adapter=new adapter_report.Adapter(this,mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(report.this,MainActivity.class));
    }
}
