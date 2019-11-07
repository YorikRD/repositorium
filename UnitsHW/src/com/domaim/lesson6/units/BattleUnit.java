package com.domaim.lesson6.units;

abstract public class BattleUnit extends Unit implements AttackAble{
   protected int attackScrore;



    public int getAttackScrore() {
        return attackScrore;
    }

    public void setAttackScrore(int attackScrore) {
        this.attackScrore = attackScrore;
    }

    public BattleUnit(String name, int speed, int attackScrore, int health) {
        super(name, speed); //Вызов конструктора родителя.
        this.health = health;
        this.attackScrore = attackScrore;
    }

    public static BattleUnit bUCrt(String type){
        if (type.equals("Doctor")){
            BattleUnit doc = new Doctor("Dsas",18-(int)(Math.random()*15),16-(int)(Math.random()*7),20+10-(int)(Math.random()*15));
            doc.setName("Doctor " +Doctor.getNomb());
            Doctor.setNomb(Doctor.getNomb()+1);
            return doc;
        } else if(type.equals("Knight")){
            BattleUnit knig = new Knight("knight",18+10-(int)(Math.random()*15),12+10-(int)(Math.random()*15),30+10-(int)(Math.random()*15));
            knig.setName("Knight " +Knight.getNomb());
            Knight.setNomb(Knight.getNomb()+1);
            return  knig;
        } else if(type.equals("Worrior")){
            BattleUnit warr = new Worrior("worrior",20-(int)(Math.random()*15),45-(int)(Math.random()*15),20+10-(int)(Math.random()*15));
            warr.setName("Worrior "+ Worrior.getNomb());
            Worrior.setNomb(Worrior.getNomb()+1);
            return  warr;
        } else {
            System.out.println("Введен недопустимый тип юнита вам будет создан воин по умолчанию");
            BattleUnit warr = new Worrior("worrior"+Worrior.getNomb(),20-(int)(Math.random()*15),16+10-(int)(Math.random()*15),20+10-(int)(Math.random()*15));
            warr.setName("Worrior "+ Worrior.getNomb());
            Worrior.setNomb(Worrior.getNomb()+1);
            return  warr;
        }
    }

    @Override
    public String toString() {
        return "BattleUnit{" +
                "attackScrore=" + attackScrore +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }

    @Override
    public void rest() {

    }

    @Override
    public void escapeBattleField() {

    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }
}
