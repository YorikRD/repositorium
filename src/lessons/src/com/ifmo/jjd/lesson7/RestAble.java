package com.ifmo.jjd.lesson7;
// interface -may contain methods without realisation!
// interface -may contain methods with realisation< but its strongly not reccomended!
// interface -may contain STATIC methods with realisation< but its strongly not reccomended!
// class which impliments interface< must realise all methods without realisatoiob listed in interface, If class is not abstract!
public interface RestAble {
    //i.e method without realisation;
    // void rest(); without realisation
    // void rest(){}; with realisation.
    void rest(); // without
    default void run(){ //with! with realisation is default
        System.out.println("run Restable");
    }
}

