package com.domaim.lesson6.units;

public interface RestAble {
    void rest ();
    default void escapeBattleField() {
        System.out.println("Юнит сбержал с поля боя");
    }
}
