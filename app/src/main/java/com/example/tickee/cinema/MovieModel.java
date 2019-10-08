package com.example.tickee.cinema;

import java.util.List;

public class MovieModel {
    private String movieName;
    private String movieDes;
    List<TimeModel> timeModelList;
    private int img;

    public MovieModel() {
    }


    public MovieModel(String movieName, String movieDes, List<TimeModel> timeModelList, int img) {
        this.movieName = movieName;
        this.movieDes = movieDes;
        this.timeModelList = timeModelList;
        this.img = img;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDes() {
        return movieDes;
    }

    public void setMovieDes(String movieDes) {
        this.movieDes = movieDes;
    }

    public List<TimeModel> getTimeModelList() {
        return timeModelList;
    }

    public void setTimeModelList(List<TimeModel> timeModelList) {
        this.timeModelList = timeModelList;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
