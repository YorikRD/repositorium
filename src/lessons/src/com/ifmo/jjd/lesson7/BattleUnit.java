package com.ifmo.jjd.lesson7;

abstract public class BattleUnit extends Unit implements AttackAble { //extends Unit milty inheritens is prohibited!
    // here we call battleunit abstract as we dont create instances of this class
    //class CombatUnit extends class unit
    //CombatUnit is a child class()subclass
    //class unit is Parent class.
    //Child class fas an access to parent class private fields and methods> but not shurely to packageprivate (default)
    protected int attackPoints;

    public BattleUnit(int healthPoints, int agilityPints, int attackPoints) {
        super(healthPoints, agilityPints); // call parents constructor.
        if (attackPoints <= 0) throw new IllegalArgumentException("Attack must be >0");
        this.attackPoints = attackPoints;
    }

    // class BattleUnits inherits method run from to sources, so we must override it!
    // Overide rules: excess modifiers must stay the same, or become wider. i.e. private -> public is ok. reverse is impossible.
    // same arguments
    @Override
    public void run() {
        System.out.println("Run realisation");
    }

    public static BattleUnit battleUnitFactory(){
        BattleUnit unit = null;
        String[] types ={"knight","infantry"};
        switch (types[(int)(Math.random()*types.length)]){
            case "knight":
                unit = new Knight(
                        (10 + (int) (Math.random() * 41)),
                        (5 + (int) (Math.random() * 11)),
                        (8 + (int) (Math.random() * 11)));
                break;
            case "infantry":
                unit = new Infantry(
                        (20 + (int) (Math.random() * 41)),
                        (5 + (int) (Math.random() * 11)),
                        (5 + (int) (Math.random() * 11)));
                break;
        }
        return unit;
    }
}
