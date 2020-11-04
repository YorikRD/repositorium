package com.ifmo.jjd.lesson13.generic.methods;

public class TstGenericMethods {
    public static void main(String[] args) {
        String[] strings ={"qwe","asd","zxc"};
        String  s = "qwe";
        System.out.println(CustomUtils.inArray(strings,s));

        Integer[] integers = {45,67,89};
        int intvar=34;
        System.out.println(CustomUtils.inArray(integers,intvar));

        Double aDouble =34.7;
        System.out.println(CustomUtils.<Integer,Double>compareHashCode(intvar,aDouble)); // we asked compilator to check arg types for wis method call


    }
}
