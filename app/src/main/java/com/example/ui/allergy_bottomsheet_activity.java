package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class allergy_bottomsheet_activity extends AppCompatActivity {
    private EditText allergy_name,allergy_side_effects,allergy_description;
    User user = SharedPref.getInstance(this).getUser();
    String aid=user.getAadhaar_id();
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_bottomsheet_activity);

        allergy_name=findViewById(R.id.allergy_name);
        allergy_side_effects=findViewById(R.id.allergy_side_effects);
        allergy_description=findViewById(R.id.allergy_description);
        submit=findViewById(R.id.allergy_submit_btn);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fatch_data();
                //Toast.makeText(getApplicationContext(),allergy_name.getText().toString(),Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),allergy_side_effects.getText().toString(),Toast.LENGTH_LONG).show();
               // Toast.makeText(getApplicationContext(),allergy_description,Toast.LENGTH_LONG).show();
            }
        });

    }

    private void fatch_data() {
        final String a_name=allergy_name.getText().toString().trim();
        final String a_effects=allergy_side_effects.getText().toString().trim();
        final String a_description=allergy_description.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.ADD_ALLERGY_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                            startActivity(new Intent(allergy_bottomsheet_activity.this, allergy.class));
                            finish();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("aadhaar_id",aid);
                params.put("allergy_name",a_name);
                params.put("allergy_side_effects",a_effects);
                params.put("allergy_description",a_description);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}

