package com.example.ui;

public class User {
    private String aadhaar_id,f_name,l_name,dob,gender,address;

    public  User(String aadhaar_id,String f_name,String l_name,String dob,String gender,String address){
        this.aadhaar_id=aadhaar_id;
        this.f_name=f_name;
        this.l_name=l_name;
        this.dob=dob;
        this.gender=gender;
        this.address=address;

    }



    public String getAadhaar_id() {
        return aadhaar_id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
}
