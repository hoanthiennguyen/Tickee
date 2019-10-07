package com.example.tickee.cinema;

public class MovieModel {
    private String movieName;
    private String movieDes;
    private String endTime;
    private String startTime;
    private String price;
    private int img;

    public MovieModel() {
    }

    public MovieModel(String movieName, String movieDes, String endTime, String startTime, String price, int img) {
        this.movieName = movieName;
        this.movieDes = movieDes;
        this.endTime = endTime;
        this.startTime = startTime;
        this.price = price;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
