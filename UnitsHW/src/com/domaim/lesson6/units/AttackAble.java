package com.domaim.lesson6.units;

public interface AttackAble {
    void attack(Unit enemy);
    default void escapeBattleField() {
        System.out.println("Юнит сбержал с поля боя");
    }
}
