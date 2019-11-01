package Farm;

import Farm.Animals.DomesticAnimal;
import Farm.Animals.WildAnimal;
import Farm.Farmers.Farmer;

public class Main {
    public static void main(String[] args) {
        DomesticAnimal cow1 = new DomesticAnimal("Cow", 5, 20, 12, 3, true, true, 12);
        DomesticAnimal cow2 = new DomesticAnimal("Cow", 5, 20, 12, 3, true, true, 12);
        DomesticAnimal rab1 = new DomesticAnimal("Rabbit", 15, 2, 2, 0, true, true, 2);
        DomesticAnimal rab2 = new DomesticAnimal("Rabbit2", 15, 2, 2, 0, true, true, 2);
        DomesticAnimal rab3 = new DomesticAnimal("Rabbit3", 15, 2, 2, 0, true, true, 2);
        DomesticAnimal chi1 = new DomesticAnimal("Chikken1", 5, 2, 1, 1, true, true, 1);
        DomesticAnimal chi2 = new DomesticAnimal("Chikken2", 5, 2, 1, 1, true, true, 1);
        DomesticAnimal chi3 = new DomesticAnimal("Chikken3", 5, 2, 1, 1, true, true, 1);
        DomesticAnimal chi4 = new DomesticAnimal("Chikken4", 5, 2, 1, 1, true, true, 1);
        DomesticAnimal chi5 = new DomesticAnimal("Chikken5", 5, 2, 1, 1, true, true, 1);
        DomesticAnimal cat = new DomesticAnimal("Cat", 15, 4, 3, 0, true, false, 3);
        WildAnimal fox = new WildAnimal("Fox", 16, 12, 3, 0);
        WildAnimal wolf = new WildAnimal("Wolf", 10, 20, 6, 0);
        WildAnimal bear = new WildAnimal("Bear", 6, 102, 30, 0);

        DomesticAnimal[] farm2 = new DomesticAnimal[18];


        Farmer petrovich = new Farmer("Петрович", 6, true);
        Farm farm1 = new Farm(15, petrovich);
        farm1.addDomest(cow1, cow2, rab1, rab2, rab3, chi1, chi2, chi3, chi4, chi5, cat);
        farm1.addWild(fox, wolf, bear);
        System.out.println(farm1);
////        System.out.println(farm1.getFarm());
//            petrovich.collect(farm1.getFarm()[0]);
//            System.out.println(petrovich);
//            for (int i =0; i<=farm1.getFarm().length - 1;i++){
//                if (farm1.getFarm()[i] == null) {
//                    break;
//                } DomesticAnimal doy = farm1.getFarm()[i];
//                petrovich.collect(doy);
//        } //проврека методов


        farm1.dayCycle(50);
//        System.out.println(petrovich);

    }

}

