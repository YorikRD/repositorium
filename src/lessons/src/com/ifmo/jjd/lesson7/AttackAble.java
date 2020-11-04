package com.ifmo.jjd.lesson7;

public interface AttackAble {
    //method without realisation.
    void attack(BattleUnit unit);

    default void run(){
        System.out.println("run AttackAble");
    }
}
