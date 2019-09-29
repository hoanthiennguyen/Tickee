package com.example.tickee.model;

public class Cinema {
    String name, address, distance,street;
    int backgroundResourceId;

    public Cinema(String name, String distance, String street) {
        this.name = name;
        this.distance = distance;
        this.street = street;
    }

    public Cinema(String name, String address, String distance, String street, int backgroundResourceId) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.street = street;
        this.backgroundResourceId = backgroundResourceId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Cinema(String name, String address, String distance, int backgroundResourceId) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.backgroundResourceId = backgroundResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getBackgroundResourceId() {
        return backgroundResourceId;
    }

    public void setBackgroundResourceId(int backgroundResourceId) {
        this.backgroundResourceId = backgroundResourceId;
    }
}
