package com.lab.domain;

public class Order {
    private Integer id;
    private Integer clientId;
    private Integer tourId;
    private Integer duration;
    private Integer totalCost;
    private String uid;


    public Order(Integer clientId, Integer tourId, Integer duration, Integer totalCost, String uid) {
        this.clientId = clientId;
        this.tourId = tourId;
        this.duration = duration;
        this.totalCost = totalCost;
        this.uid = uid;
    }
    public Order(Integer id,Integer clientId, Integer tourId, Integer duration, Integer totalCost, String uid) {
        this.id = id;
        this.clientId = clientId;
        this.tourId = tourId;
        this.duration = duration;
        this.totalCost = totalCost;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
