package com.example.tickee.cinema;

public class TimeModel {
    private String endTime;
    private String startTime;
    private String price;

    public TimeModel(String startTime, String endTime, String price) {
        this.endTime = endTime;
        this.startTime = startTime;
        this.price = price;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
