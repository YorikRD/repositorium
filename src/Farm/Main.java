package Farm;

import Farm.Animals.Domestic_Animal;
import Farm.Animals.WildAnimal;
import Farm.Farmers.Farmer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
      Domestic_Animal cow1 = new Domestic_Animal("Cow",5,20,12,3,true, true);
        Domestic_Animal cow2 = new Domestic_Animal("Cow",5,20,12,3,true, true);
        Domestic_Animal rab1 =new Domestic_Animal("Rabbit",15,2,2,0,true, true);
        Domestic_Animal rab2 =new Domestic_Animal("Rabbit2",15,2,2,0,true, true);
        Domestic_Animal rab3 =new Domestic_Animal("Rabbit3",15,2,2,0,true, true);
        Domestic_Animal chi1 =new Domestic_Animal("Chikken1",5,2,1,1,true, true);
        Domestic_Animal chi2 =new Domestic_Animal("Chikken2",5,2,1,1,true, true);
        Domestic_Animal chi3 =new Domestic_Animal("Chikken3",5,2,1,1,true, true);
        Domestic_Animal chi4 =new Domestic_Animal("Chikken4",5,2,1,1,true, true);
        Domestic_Animal chi5 =new Domestic_Animal("Chikken5",5,2,1,1,true, true);
        Domestic_Animal cat =new Domestic_Animal("Cat",15,4,3,0,true, false);
        WildAnimal fox = new WildAnimal("Fox",16,12,3,0);
        WildAnimal wolf = new WildAnimal("Wolf",10,20,6,0);
        WildAnimal bear = new WildAnimal("Bear",6,102,30,0);




       Farmer petrovich = new Farmer("Петрович",6,true);
       Farm farm1 = new Farm(15, petrovich );
       farm1.addDomest(cow1,cow2,rab1,rab2,rab3,chi1,chi2,chi3,chi4,chi5,cat);
       farm1.addWild(fox,wolf,bear);
               System.out.println(farm1);
////        System.out.println(farm1.getFarm());
//            petrovich.collect(farm1.getFarm()[0]);
//            System.out.println(petrovich);
//            for (int i =0; i<=farm1.getFarm().length - 1;i++){
//                if (farm1.getFarm()[i] == null) {
//                    break;
//                } Domestic_Animal doy = farm1.getFarm()[i];
//                petrovich.collect(doy);
//        } //проврека методов


        farm1.dayCycle(20);
        System.out.println(petrovich);

    }

}

