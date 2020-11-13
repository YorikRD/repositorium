package com.ifmo.jjd.lesson20.socketio.serialisation;

import java.io.Serializable;

// human serialisable class so all his children will become Seialisable.
public class Human implements Serializable {
    protected String name = "Человек";
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 5) this.age = age;
    }
}