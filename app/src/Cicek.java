package com.example.hack;

import java.security.PrivateKey;

public class Cicek {

    private int number;
    private String name;
    private int lentgh;
    private String mean;
    private int cost;
    private int percent;

    public Cicek(int number, String name, int lentgh, String mean, int cost, int percent) {
        this.number = number;
        this.name = name;
        this.lentgh = lentgh;
        this.mean = mean;
        this.cost = cost;
        this.percent = percent;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLentgh() {
        return lentgh;
    }

    public void setLentgh(int lentgh) {
        this.lentgh = lentgh;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
