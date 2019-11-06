package com.domaim.lesson6;
import com.domaim.lesson6.units.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println(" Укажите тип перснажа");
//        String userChoice = in.nextLine();
//
//        //worrior knigt doctor
//        BattleUnit battleUnit = null;
//        if ("worrior".equals(userChoice)) {
//            battleUnit = new Worrior("Воин", 20, 16, 20);
//        } else if ("Knight".equals(userChoice)) {
//            battleUnit = new Knight("knight",15,12,30);
//        } else if ("Doctor".equals(userChoice)){
//            battleUnit = new Doctor("Doctor",18,6,50);
//        } else {
//            System.out.println("Юнит недопустимого типа, вам будет создан воин по умолчанию");
//            battleUnit = new Worrior("Воин", 3, 5, 20);
//        }
//        battleUnit.run();

        BattleUnit dewj = BattleUnit.bUCrt("Doctor");
        System.out.println(dewj);
        BattleUnit wer = BattleUnit.bUCrt("34");
        System.out.println(wer);
        BattleUnit wer2 = BattleUnit.bUCrt("44");
        System.out.println(wer2);
        BattleUnit wer3 = BattleUnit.bUCrt("34");
        System.out.println(wer3);

        wer.attack(wer2);
        wer2.attack(wer);
        wer3.attack(dewj);
        dewj.attack(wer3);

        if (wer.getHealth()>wer2.getHealth()&& wer.getHealth()>wer3.getHealth() && wer.getHealth()>dewj.getHealth()){
            Unit king1 = King.kingCoronation(wer);
            System.out.println(king1);
        } else if (wer2.getHealth()>wer.getHealth()&& wer2.getHealth()>wer3.getHealth() && wer2.getHealth()>dewj.getHealth()) {
            Unit king2 = King.kingCoronation(wer2);
            System.out.println(king2);
        }  else if (wer3.getHealth()>wer.getHealth()&& wer3.getHealth()>wer2.getHealth() && wer3.getHealth()>dewj.getHealth()) {
            Unit king3 = King.kingCoronation(wer3);
            System.out.println(king3);
        } else {
            Unit king4 = King.kingCoronation(dewj);
            System.out.println(king4);
        }









    }
}
