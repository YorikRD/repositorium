package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;

public class TstGarage {
    public static void main(String[] args) {
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        Train train = new Train("Спб", "Москва", "23-Ф", 12);
        Garage<Bus> garage1 = new Garage<>(); //type of field is bus
        garage1.setCarOnSrevice(bus);
        System.out.println(garage1.getCarOnSrevice().isWiFi());// so we can call bus methods
        Garage<Transport> garage2 = new Garage<>();
        garage2.setCarOnSrevice(bus); // hear bus is stored as trunsport
        bus =(Bus)garage2.getCarOnSrevice(); // hear is is brought to bus if we are tying to bring to wrong class- it will caus Classcast exeption.
        System.out.println(bus.isWiFi());


    }
}