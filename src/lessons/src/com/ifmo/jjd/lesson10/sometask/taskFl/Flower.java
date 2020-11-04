package com.ifmo.jjd.lesson10.sometask.taskFl;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Flower {
    private String name;
    private String country;
    private int days;
    private int price;


    public Flower(String name, String country, int days) {
        setName(name);
        setDays(days);
        setCountry(country);
    }

    public String getName() {
        return name;
    }


    private void setName(String name) {
        Objects.requireNonNull(name,"Name must be notnull");
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        Objects.requireNonNull(country,"country must be notnull");
        this.country = country;
    }

    public int getDays() {
        return days;
    }

    private void setDays(int days) {
        if (days<=0)throw new IllegalArgumentException("days must be more then 0");
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        if (price<=0)throw new IllegalArgumentException("price must be more then 0");
        this.price = price;
    }
    static void sold (int sn){
        if(sn<=0)throw new IllegalArgumentException("price must be more then 0");
    }
}
