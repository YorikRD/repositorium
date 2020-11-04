package com.ifmo.jjd.lesson13.generic.wildcard;

import com.ifmo.jjd.lesson13.generic.types.PairContainer;

public class TstWildCards<T> {
    public static void main(String[] args) {
        Animal animal = new Cat();
        Cat cat = new Cat();
        Dog dog = new Dog();

        PairContainer<Integer, Cat> catsContainer = new PairContainer<>(1,cat);

        PairContainer<Integer, Animal> catsContainer1 = new PairContainer<>(1,cat);
        PairContainer<Integer, Dog> dogsContainer1 = new PairContainer<>(1,dog);

        copyValue(catsContainer, catsContainer1);
        TstWildCards.<Animal>copyValue(catsContainer,catsContainer1); // sintacsis with declared generic

    }
    //method takes PairContainer object who has T - integer type, a type K -(? extends M) and second which is <Integer , ? super M>
    public  static <M> void copyValue(PairContainer<Integer,?extends M> from, PairContainer<Integer, ?super M> to){
        //first type of "from" must be narrow or equals to secon type of "to"
        to.setValue(from.getValue());

        //in super (to) we cam call omly object methods< to use some more specific methods we have to bring object to nescessary daatypes
     }

    // usaly ? extends is used for data get from.
    // usale ? super is uesed for data set to.


//    public  static T getvalue(){
//        return null;
//    }
// static T declared in the moment of object creation willnot work. generics+constructors do not work with Arrays(out of args)

}
