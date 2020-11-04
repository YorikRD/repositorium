package com.ifmo.jjd.lesson13.generic.types;

import java.awt.*;

public class TstGenericTypes {
    public static void main(String[] args) {
        User<String> stringUser = new User<>(); //in declaring exeplar here we restricted we type of generic as String.
        // User<>()
        // If we dont name generuc type in object declaration it will be object.
        //Later in object inicialisation <> says " go and look in declaration
        stringUser.setId("fgfgfgf123");
        stringUser.setLogin("gfgdg");
        stringUser.setPwd("dfghi");

        System.out.println(stringUser.getId().getClass());

        User<Integer> integerUser = new User<>();
        integerUser.setId(123);
        integerUser.setLogin("gfgdg");
        integerUser.setPwd("dfghi");

        System.out.println(integerUser.getId().getClass());

        PairContainer<String,Integer> container1= new PairContainer<>("qwe",12); // key - Stringtype - value - Integer-type.
        System.out.println(container1.getValue());
        PairContainer<String, User> container3 = new PairContainer<>("qwe2",stringUser); //hear we havenot declared generic for data inside (Users class generic)
        //it is callde raw-type!
        System.out.println(container3.getValue().getId()); // hear we see users id as object

        PairContainer<String, User<String>> container2 = new PairContainer<>("qwe2",stringUser);
        System.out.println(container2.getValue().getId()); // hear we see id as String

        User<Number> numberuser = new User<>();
        integerUser.setId(1263);
        integerUser.setLogin("gfgdg");
        integerUser.setPwd("dfghi");


        PairContainer<String,User<Number>> pairContainer3 = new PairContainer<>("14",numberuser); // we cannot use ven childtype data hear.





    }
}
