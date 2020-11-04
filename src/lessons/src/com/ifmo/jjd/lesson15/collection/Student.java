package com.ifmo.jjd.lesson15.collection;

import java.util.Comparator;

// Comparable<Student> objects of thich class we must compare
public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getAge() != student.getAge()) return false;
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(student.getSurname()) : student.getSurname() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override //0/-1/1
    public int compareTo(Student student) {
//        if (this.age>student.age) return 1;
//        if (student.age>this.age) return -1;
//        return 0;

        return (student.age>this.age)?-1:(this.age>student.age)?1:0;
    }
}

class StudentAgeComparator implements Comparator<Student>{

    @Override
    public int compare(Student student, Student t1) {
        return Integer.compare(student.getAge(),t1.getAge());
    }
}

class StudentNameComparator implements Comparator<Student>{

    @Override
    public int compare(Student student, Student t1) {
        return student.getName().compareTo(t1.getName());
    }
}