package com.domaim.lesson6;
import com.domaim.lesson6.units.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Battle forTheKing = new Battle();
        forTheKing.fillArenaRand(25);
        System.out.println(forTheKing.aliveNo());
        System.out.println(forTheKing.arena.toArray().length-1);
        forTheKing.freeForAll();











    }
}
