package com.example.tickee.filmschedule;

import java.util.List;

public class ScheduleModel {
    private String movie_name;
    private String movie_des;
    private int movie_img;
    private List time;

    public ScheduleModel() {
    }

    public ScheduleModel(String movie_name, String movie_des, int movie_img) {
        this.movie_name = movie_name;
        this.movie_des = movie_des;
        this.movie_img = movie_img;
    }

    public List getTime() {
        return time;
    }

    public void setTime(List time) {
        this.time = time;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_des() {
        return movie_des;
    }

    public void setMovie_des(String movie_des) {
        this.movie_des = movie_des;
    }

    public int getMovie_img() {
        return movie_img;
    }

    public void setMovie_img(int movie_img) {
        this.movie_img = movie_img;
    }
}
