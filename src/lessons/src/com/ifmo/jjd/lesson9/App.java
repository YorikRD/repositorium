package com.ifmo.jjd.lesson9;



import java.util.Objects;

public class App {
    public static void main(String[] args) {
        Author ivan = new Author("Иван", "Петров");
        Author anna = new Author("Анна", "Гришкова");

        ColouringBook cars = new ColouringBook("Машинки", 23, 15);
        cars.setAuthor(ivan);

        ColouringBook robots = new ColouringBook("Роботы", 38, 19);
        robots.setAuthor(ivan);

        ColouringBook flowers = new ColouringBook("Цветы", 12, 10);
        flowers.setAuthor(anna);

        //All classes extends class Object.
//        Object object= new Object();
//        Object auther = new Author("ivan","Petrov");
//        ;
        System.out.println(ivan.toString());


        Author ivan1 = new Author("Auther", "Auther");
        Author ivan2 = new Author("Auther", "Auther");
        System.out.println(ivan1 == ivan2); // false because we are comparing links!!!!
        System.out.println(ivan1.equals(ivan2)); // method equals is used to compare objects because
        // we are comparing links here to. true after overriding methods

        // a.equals(b) == b.equals(a); (simmetry) // read!!!
        //a.equals(b) == b.equals(c) == a.equals(c);(transitibness) // read!!!
        //equals must: object must be lways equal to himself.(reflectivness)
        // equals must be the same without objects changing (consistence)

        //hashCode()
        // if objects equals = true, the hashcode should return the same value.
        //if object fields are the same ist hashcode must be the same.


        //possibilities :
        //hashcode may be the same for different objects. its not a problemm but a possibility.

        ColouringBook robots1 = new ColouringBook("Роботы", 38, 19);
        robots1.setAuthor(ivan);

        ColouringBook robots2 = new ColouringBook("Роботы", 38, 19);
        robots2.setAuthor(ivan);
        System.out.println(robots1.equals(robots2));

        /*
        java Objects class.
        clone()
        return super.clone(); by default - it will copy only primitives copyes link on the same objects
        if clone method is used vial super realisation it must throw exeption
        */
//        Author copyIvan = ivan.clone();
        ColouringBook bl = (ColouringBook) robots2.clone();
        System.out.println(bl.equals(robots2) +" equals ");
        System.out.println(robots2 == bl);

     }
    //equals() и hashCode() used to compare objects. To compare object we have to override thise methods.


}
