package com.example.tickee;

import java.util.List;

public class ListCinemaModel {
    private String name;
    private int img;
    private boolean isExpan;

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
