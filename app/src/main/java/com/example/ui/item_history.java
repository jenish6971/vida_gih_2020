package com.example.ui;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class item_history {

    String diseasesname_name;
    String doctor_name;
    String diseases_date;
    Context c;

    public item_history() {
    }

    public item_history(String diseasesname_name, String doctor_name, String diseases_date) {
        this.diseasesname_name = diseasesname_name;
        this.doctor_name = doctor_name;
        this.diseases_date = diseases_date;
    }

    public String getDiseasesname_name() {
        return diseasesname_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getDiseases_date() {
        return diseases_date;
    }



    public void setDiseasesname_name(String diseasesname_name) {
        this.diseasesname_name = diseasesname_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public void setDiseases_date(String diseases_date) {
        this.diseases_date = diseases_date;
    }
    //StringRequest stringRequest = new StringRequest(Request.Method.POST,Constants.HISTORY_URL,)





}
