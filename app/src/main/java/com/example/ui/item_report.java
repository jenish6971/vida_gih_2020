package com.example.ui;

public class item_report {

    String report_name;
    String report_date;

    public item_report() {
    }

    public item_report(String report_name, String report_date) {
        this.report_name = report_name;
        this.report_date = report_date;
    }

    public String getReport_name() {
        return report_name;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

}
