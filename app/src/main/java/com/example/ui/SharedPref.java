package com.example.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPref  {
    private  static final String SHARED_PREF_NAME = "profilesharedpref";
    private  static final String KEY_AADHAAR_UID ="keyaadhaaruid";
    private  static final String KEY_F_NAME ="keyfname";
    private  static final String KEY_L_NAME ="keylname";
    private  static final String KEY_DOB="keydob";
    private  static final String KEY_GENDER="keygender";
    private  static final String KEY_ADDRESS="keyaddress";

    private  static SharedPref mInstance;
    private static Context mCtx;

    private SharedPref(Context context){
        mCtx= context;
    }

    public static  synchronized SharedPref getInstance(Context context){
        if(mInstance==null){
            mInstance=new SharedPref(context);
        }
     return mInstance;
    }

    public void userLogin(User user){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_AADHAAR_UID,user.getAadhaar_id());
        editor.putString(KEY_F_NAME,user.getF_name());
        editor.putString(KEY_L_NAME,user.getL_name());
        editor.putString(KEY_DOB,user.getDob());
        editor.putString(KEY_GENDER,user.getGender());
        editor.putString(KEY_ADDRESS,user.getAddress());
        editor.apply();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_F_NAME, null) != null;
    }

    public  User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_AADHAAR_UID,null),
                sharedPreferences.getString(KEY_F_NAME,null),
                sharedPreferences.getString(KEY_L_NAME,null),
                sharedPreferences.getString(KEY_DOB,null),
                sharedPreferences.getString(KEY_GENDER,null),
                sharedPreferences.getString(KEY_ADDRESS,null)
        );
    }

    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, login.class));
    }
}
