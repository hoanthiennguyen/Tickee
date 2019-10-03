package com.example.tickee.cinema;

import java.util.List;

public class ListCinemaModel {
    private List<CinemaModel> details;
    private String name;
    private int img;
    private boolean isExpan;

    public List<CinemaModel> getDetails() {
        return details;
    }

    public void setDetails(List<CinemaModel> details) {
        this.details = details;
    }

    public ListCinemaModel(String name) {
        this.name = name;
    }

    public ListCinemaModel(String name, int img, boolean isExpan) {
        this.name = name;
        this.img = img;
        this.isExpan = isExpan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isExpan() {
        return isExpan;
    }

    public void setExpan(boolean expan) {
        isExpan = expan;
    }
}
