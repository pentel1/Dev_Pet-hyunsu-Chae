package com.example.bolg_transform_data.Model.DataModel_example;

public class Time {
    String starttime;
    String swung;
    String endtime;

    public Time(String starttime, String swung, String endtime) {
        this.starttime = starttime;
        this.swung = swung;
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getSwung() {
        return swung;
    }

    public void setSwung(String swung) {
        this.swung = swung;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
