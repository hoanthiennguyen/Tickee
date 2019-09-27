package com.example.tickee.model;

public class Film {
    String name, duration,time;
    int backgroundResourceId;

    public Film(String name, String duration, String time, int backgroundResourceId) {
        this.name = name;
        this.duration = duration;
        this.time = time;
        this.backgroundResourceId = backgroundResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBackgroundResourceId() {
        return backgroundResourceId;
    }

    public void setBackgroundResourceId(int backgroundResourceId) {
        this.backgroundResourceId = backgroundResourceId;
    }
}
