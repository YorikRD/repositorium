package com.ifmo.jjd.lesson11;

import java.time.LocalDate;
import java.util.Objects;

public class Article {
    enum Country { //enumeration
        UK,USA, AUSTRALIA

    }
    private final String title;
    private String text;
    private final LocalDate creation;
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        Objects.requireNonNull(country,"Ckhsksdh");
        this.country = country;
    }

    public Article(String title) {
        this.title = title;
        creation = LocalDate.now();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCreation() {
        return creation;
    }
}
