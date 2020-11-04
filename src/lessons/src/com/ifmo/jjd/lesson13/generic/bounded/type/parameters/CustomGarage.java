package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;

public class CustomGarage extends Garage {
    public void checkItem() {
        //hear getCarOnService  returns Transport
        //as it is typede in Garage class. <T extends Transport&Repairing>
        System.out.println(this.getCarOnSrevice().getNum());
    }

}

class CustomGarage2 extends Garage<Transport> {
    public void checkItem() {
        //hear getCarOnService  returns Transport
        //as it is type is declared hear!!
        System.out.println(this.getCarOnSrevice().getNum());

    }
}

class CustomGarage3 extends Garage<Bus> {
    public void checkItem() {
        //hear getCarOnService  returns Bus
        //as it is type is declared hear!!
        System.out.println(this.getCarOnSrevice().isWiFi());

    }
}
