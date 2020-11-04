package com.ifmo.jjd.lesson6;

public class AutherClass {
    private String firstNname;
    private String surname;

    public AutherClass(String firstNname) {
        setFirstNname(firstNname);
    }

    public AutherClass(String firstNname, String surname) {
        setFirstNname(firstNname);
        setSurname(surname);
    }

    public AutherClass() {
    }

    public String getFirstNname() {
        return firstNname;
    }

    public void setFirstNname(String firstNname) {
        this.firstNname=firstNname; // this is not mandatory if  arg in method differs from class field name.
        if (firstNname == null ||firstNname.strip().length()<3){
            throw new IllegalArgumentException("title must not be longer then 3!");
        }
        this.firstNname = firstNname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname; // this is not mandatory if  arg in method differs from class field name.
        if (surname == null || surname.strip().length()<3){
            throw new IllegalArgumentException("title must not be longer then 3!");
        }
        this.surname = surname;
    }

    public String getfullName(){
        String fullname= firstNname+" "+ surname;
        return fullname;
    }

    @Override
    public String toString() {
        return "AutherClass{" +
                "firstNname='" + firstNname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
