package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class history extends AppCompatActivity {

    RecyclerView recyclerView ;
    ArrayList<item_history> mlist;
    adapter_history.Adapter adapter;
    User user = SharedPref.getInstance(this).getUser();
    String aid=user.getAadhaar_id();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageButton back_from_history_java;
        recyclerView = findViewById(R.id.history_recycle_view);


        //final Context context = null;

        // setup recyclerview with the adapter

        recyclerView.setLayoutManager(new LinearLayoutManager(this));




//       mlist.add(new item_history("Cholera","Dr.Jenish Dhanani","19/06/2014"));
//        mlist.add(new item_history("Cold","Dr.Jenish Dhanani","19/06/2015"));
//        mlist.add(new item_history("Plague","Dr.Jenish Dhanani","19/06/2016"));
//        mlist.add(new item_history("Cold","Dr.Jenish Dhanani","19/06/2017"));
//        mlist.add(new item_history("Cold","Dr.Jenish Dhanani","19/06/2018"));

        fatch_data();

//        adapter_history.Adapter adapter = new adapter_history.Adapter(this,mlist);
//
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//

        back_from_history_java = (ImageButton) findViewById(R.id.back_from_history);

        back_from_history_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(history.this, MainActivity.class));
                finish();
            }
        });



    }

    private void fatch_data() {
        StringRequest stringRequest= new StringRequest(Request.Method.POST, Constants.HISTORY_URL,
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
                                mlist.add(new item_history(jsonObject.getString("disease"),
                                        jsonObject.getString("doctor_name"),
                                        jsonObject.getString("date")));

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
        adapter=new adapter_history.Adapter(this,mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(history.this,MainActivity.class));
    }

}
