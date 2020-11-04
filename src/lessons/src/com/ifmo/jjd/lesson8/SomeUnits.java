package com.ifmo.jjd.lesson8;
// key words:
// "final"  may be used
//classes - final classes can not be extended. no child classes.
//methods - final methods cannot be Overrided in child methods.
//method(arguments) - final args are avalible only for reading. we can use it in method but we can newer change it.
// fields/prop - cannot be changed after creation/declaration.
//variable

//"static" may be used
//Static is not object but a class smth.
// classes but only with classes inside another classes (read later)
//fields/proprties it is some value inside class common for all its instances
//methods

//final and stathic may be used simultaniusly
// i.e. final stathic

final public class SomeUnits {

    private final String PREFIX;
     static double PI_VAR=3.14;
     static double someVar;
     private static final int E_VAR=12;
     static { // static block
         someVar=90;
     }
    public SomeUnits(String PREFIX, double PI_VAR) {
        this.PREFIX = PREFIX;
    }

    public  void someVoid(final int num, final int[] nums){
        System.out.println(num); // ok

//        num = 12; // impossible
        // on link type we cannot chang link, but we can call any its method and it can change we object.
        // i.e. Iron iron = new Iron - impossible
        // iron.melt - no problemm method will work.
//        nums = new int[]{}; impossible
        nums[0]=122; // no problemm.
    }
    public static int summ (int a, int b){ // this method cannot call objects fields
        return a+b;
    }
    public static int random(int min,int max){
        return (int)(Math.random()*(max-min+1))+min ;
    }

    public static void main(String[] args) {
        SomeUnits.summ(12,22);
        for (int i = 0; i < 12; i++) {
            System.out.println(SomeUnits.random(0,5));
        }

    }
}
