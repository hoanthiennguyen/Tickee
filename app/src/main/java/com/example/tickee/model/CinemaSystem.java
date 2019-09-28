package com.example.tickee.model;

import java.util.List;

public class CinemaSystem {
    String name;
    int quantity;
    int backgroundResourceId;
    List<Cinema> cinemas;

    public CinemaSystem(String name, int quantity, int backgroundResourceId, List<Cinema> cinemas) {
        this.name = name;
        this.quantity = quantity;
        this.backgroundResourceId = backgroundResourceId;
        this.cinemas = cinemas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBackgroundResourceId() {
        return backgroundResourceId;
    }

    public void setBackgroundResourceId(int backgroundResourceId) {
        this.backgroundResourceId = backgroundResourceId;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
