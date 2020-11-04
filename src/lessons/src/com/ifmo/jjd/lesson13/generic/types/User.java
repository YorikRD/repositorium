package com.ifmo.jjd.lesson13.generic.types;

public class User <T> { // hear we declare tha our class can use generics

    private String login;
    private String pwd;
    private T id; // dataType that is decided in th moment of objects creation it will always be compiled as Object
    // so can use only object-class methods.

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
