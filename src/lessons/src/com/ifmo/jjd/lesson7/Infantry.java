package com.ifmo.jjd.lesson7;

public class Infantry extends BattleUnit {

    public Infantry(int healthPoints, int agilityPints, int attackPoints) {
        super(healthPoints, agilityPints, attackPoints);
    }
// realisation of attack method AttackAble interface
    @Override
    public void attack(BattleUnit unit) {
        if (this.isAlive()&&unit.isAlive()&&this.agilityPints>=unit.agilityPints) unit.minusHealth(this.attackPoints);
        if (unit.isAlive()&&this.isAlive()&&unit.agilityPints>=this.agilityPints) this.minusHealth(unit.attackPoints);
    }
    // realisation of rest method restAble interface
    @Override
    public void rest() {
        this.plusHealth(2);
    }
}
