package com.domaim.lesson6;

import com.domaim.lesson6.units.BattleUnit;
import com.domaim.lesson6.units.King;
import com.domaim.lesson6.units.Unit;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    ArrayList<Unit> arena = new ArrayList<>();

    public void fillArenaRand (int quant){
        for (int i = 0; i <= (quant - 1); i++) {
            int rand = (int) (Math.random() * 3) + 1;
            if (rand == 1) {
                arena.add(BattleUnit.bUCrt("Doctor"));
            } else if (rand == 2) {
                arena.add(BattleUnit.bUCrt("Knight"));
            } else if (rand == 3) {
                arena.add(BattleUnit.bUCrt("Worrior"));
            }

        }
    }

    public void freeForAll() {
        while (this.aliveNo() >= 2) {
            for (int a = 0; a <= arena.size() / 2; a++) {
                if (arena.get(a) instanceof BattleUnit && arena.get(a).isAlive()) {
                    int enemy = arena.size() - a - 1;
                    if (!arena.get(enemy).isAlive()) {
                        enemy = enemy - 1;
                    }
                    if (enemy==a){
                        enemy = enemy - 1;
                    }
                    ((BattleUnit) arena.get(a)).attack(arena.get(enemy));
                    if (arena.get(enemy) instanceof BattleUnit && arena.get(enemy).isAlive()) {
                        ((BattleUnit) arena.get(enemy)).attack(arena.get(a));
                    }
//                    if (!arena.get(a).isAlive()){
//                        arena.remove(a);
//                    }
//                    if (!arena.get(enemy).isAlive()){
//                        arena.remove(enemy);
//                    }
                } for (int i=0; i< arena.size(); i++){
                    if (!arena.get(i).isAlive()){
                        arena.remove(i);
                    }
                }
            }
        }
        System.out.println(this.aliveNo());
        System.out.println(arena);
        for ( int i =0; i<arena.size();i++) {
            if (arena.get(i) instanceof BattleUnit) {
                Unit newKing = King.kingCoronation((BattleUnit)arena.get(i));
                System.out.println(newKing);
            }
        }

    }

    public int aliveNo(){
        int alive=0;
        for (int i =0; i<arena.size(); i++){
            if(arena.get(i).isAlive()){
//                System.out.println(arena.get(i));
                alive++;}
        } return alive;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "arena=" + arena +
                '}';
    }
}
