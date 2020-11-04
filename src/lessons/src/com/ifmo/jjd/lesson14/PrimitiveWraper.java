package com.ifmo.jjd.lesson14;

public class PrimitiveWraper {
    //byte,int,long,float..
    //byte - class Byte
    //int - Integer
    //long - Float
    //float - Float
    //double - double.
    //boolean - Boolean
    //char - Char
    //short - Short.
    public static void main(String[] args) {
        //primitives must be used alwayws, but :
        //1 - it is impossible.i.e. Generics
        //2 - it is nescessary to use wraper-class methods.

        int num = 567;
//    Integer count = new Integer() unlikely way! old one!
        Integer integer = 54; // we integer seted walue of primitivee
        //inside was autowrping;
        // autopacking - primitive value was setted yo wrapper class field.
        Integer age1 =38;
        age1 = num;
        //auto unpacking

        double price;
        Double someDouble = 56.9;
        price = someDouble;

        // RULES for autopacking and unpacking:
        //1 autopacking doesnot worl if primitibe type dont match Wrapper class.
        //2 autouoacking doesnot follow thise rule.
        Byte two = 2;
        int num2 = two; // неявное приведение типов.

        Integer three =3;
//        byte num3 =(Byte)three; // неявное приведение типов не может произойти нужно сделать явное. которое мы не можем выполнить т.к. типы несовместимы.
        //3. methods parameters(arg) are following the rules upper.
        printScrt(78); //here we puted primitive value, it was wraped
        printNum(integer);

        //4. autopack and autoupack doesnot support arrys. It will be nescessary to wrap them individualy
        double[] arg2  ={45.88,423.12 ,3.8};
//        doublePrint(arg2);

        // Nums have methods which return primitibes of reauired type but is is simble bringing so we have full responsibility for its results.
        // methods peseXXX(String with value); - returns primitive; static method
        // valueOf(String with value); - returns object; static method
        Byte.parseByte("4"); // return primitive of byte =4;
        Byte.valueOf("4"); //return Byte with value of 4;
        //if any simbols not valid type are present the result will be Exeption.
        //for double or float "." must be devider "," will throw exeption.

        Integer int1 =34;
        Integer int2 =34;
        System.out.println(int1 == int2); //true
        //because value inside -128 to 127 are stored in something like stringpool numbers whick can be sotrid in byte.
        int1 =200;
        int2 =200;
        System.out.println(int1 == int2); //false


//
    }
    public  static void printScrt(Integer i){
        Integer res =i*i; // here we unpacked it and multyplied.
        System.out.println(res);
    }
    public static void printNum(int i){
        System.out.println(i);
    }

    public static void doublePrint(Double[] darr){
        for (Double aDouble : darr) {
            System.out.println(aDouble);
        }
    }
}
