package com.example.ui;

public class item_history {

    String diseasesname_name;
    String doctor_name;
    String diseases_date;

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

}
