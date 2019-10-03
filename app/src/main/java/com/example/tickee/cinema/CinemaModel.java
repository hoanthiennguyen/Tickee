package com.example.tickee.cinema;

public class CinemaModel {
    private String cinemaName;
    private String cinemaLocation;
    private String cinemaDistance;
    private int Photo;
    private boolean isExpan;

    public CinemaModel() {
    }

    public CinemaModel(String cinemaName, String cinemaLocation, String cinemaDistance, int photo) {
        this.cinemaName = cinemaName;
        this.cinemaLocation = cinemaLocation;
        this.cinemaDistance = cinemaDistance;
        Photo = photo;
    }

    public CinemaModel(String cinemaName, String cinemaLocation, String cinemaDistance) {
        this.cinemaName = cinemaName;
        this.cinemaLocation = cinemaLocation;
        this.cinemaDistance = cinemaDistance;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaLocation() {
        return cinemaLocation;
    }

    public void setCinemaLocation(String cinemaLocation) {
        this.cinemaLocation = cinemaLocation;
    }

    public String getCinemaDistance() {
        return cinemaDistance;
    }

    public void setCinemaDistance(String cinemaDistance) {
        this.cinemaDistance = cinemaDistance;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
