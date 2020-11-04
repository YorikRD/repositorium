package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;

public class Garage <T extends Transport&Repairing> { // we declare that carOnSrevice must be of transport type.
    // it can call methods only method of thise class
    // all aditional restrictions throu & only one class and any number of interfaces
    // the caronservisce class must realise declared interface.
    private T carOnSrevice;

    public T getCarOnSrevice() {
        return carOnSrevice;
    }

    public void setCarOnSrevice(T carOnSrevice) {
        this.carOnSrevice = carOnSrevice;
    }

    public void serve(){
        carOnSrevice.repair();

    }
}
