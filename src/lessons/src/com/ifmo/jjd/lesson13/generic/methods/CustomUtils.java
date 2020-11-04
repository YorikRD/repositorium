package com.ifmo.jjd.lesson13.generic.methods;

public class CustomUtils {
    //Thypized methods generic methods only Link type data!
    //may be static of nonstatic
    public static <T>  boolean inArray(T[]arr, T elem){// <T> - declares that our method  can handle any link-typed data.
        // T is not initoalised at the moment of method creation => for T- ojbjects we can use only methods od Object class.
        if (elem == null) throw new IllegalArgumentException("String elem must be not null");
        for (T s : arr) {
            if(elem.equals(s)) return true;
        }
        return false;
    }
    //if generic typed data have no restrictions in process of compilation it will be converted to object,
    // it is called type cleaning.(Стирание типов)

    public static <T extends Number,K extends Number> int compareHashCode(T first, K second ){  // extends in generic is
        //restriction of type arg. all args must be from class extending  restriction type hear Number.
        return  Integer.compare(first.hashCode(),second.hashCode());
    }
    //if restriction id declared - we can used methods available to restriction-class.
}
