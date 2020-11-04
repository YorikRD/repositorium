package com.ifmo.jjd.lesson7;

public class Application {
    public static void main(String[] args) {
        King king1 = new King(100,10);
        King king2 = new King(100,15);
        king1.generateArmy();
        king2.generateArmy();
        king1.startAttack(king2);
        king2.startAttack(king1);
        king1.addCombatUnitw();
        System.out.println(king1.getAttRes());
        System.out.println(king2.getAttRes());

    }
}
