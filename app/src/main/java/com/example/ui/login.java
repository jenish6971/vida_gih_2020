package com.example.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import com.example.ui.*;
import java.util.HashMap;
import java.util.Map;


public class login extends AppCompatActivity {

    private EditText uid, password;
    private ImageButton next;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (SharedPref.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        uid = (EditText) findViewById(R.id.aadhar_id_edittext);
        password = (EditText) findViewById(R.id.pass_edittext);
        next = (ImageButton) findViewById(R.id.next_btn);
        signup = (TextView) findViewById(R.id.signup_txt);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String aid = uid.getText().toString().trim();
                final String pass = password.getText().toString().trim();

                if(!aid.isEmpty()||!pass.isEmpty()){
                    userLogin();}
                else {
                    Toast.makeText(getApplicationContext(),"insert aid or password",Toast.LENGTH_LONG).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, register.class));
                finish();
            }
        });

    }

    private void userLogin() {

        final String aid = uid.getText().toString().trim();
        final String pass = password.getText().toString().trim();

        if(!aid.isEmpty()||!pass.isEmpty()) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                //converting response to json object
                                JSONObject obj = new JSONObject(response);
                                String s = obj.getString("status");
                                // Toast.makeText(getApplicationContext(),"enter..",Toast.LENGTH_LONG).show();
                                // startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                //if no error in response
                                if (s.equals("1")) {
                                    Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                                    //Toast.makeText(getApplicationContext(), "enter..", Toast.LENGTH_LONG).show();
                                    //getting the user from the response
                                    JSONObject userJson = obj.getJSONObject("user");

                                    //creating a new user object
                                    User user = new User(
                                            userJson.getString("aadhaar_id"),
                                            userJson.getString("f_name"),
                                            userJson.getString("l_name"),
                                            userJson.getString("dob"),
                                            userJson.getString("gender"),
                                            userJson.getString("address")
                                    );
                                    SharedPref.getInstance(getApplicationContext()).userLogin(user);

                                    //starting the profile activity
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(), "Enter correct AID or Password", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("aadhaar_id", aid);
                    params.put("password", pass);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
        else {
            Toast.makeText(getApplicationContext(),"insert aid or password",Toast.LENGTH_LONG).show();
        }
    }


}

