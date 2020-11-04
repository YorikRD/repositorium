package com.ifmo.jjd.lesson7;

public class Knight extends BattleUnit {
    final private int addirionalAt =2;

    public Knight(int healthPoints, int agilityPints, int attackPoints) {
        super(healthPoints, agilityPints, attackPoints);
    }

    @Override
    public void attack(BattleUnit unit) {
        if (this.isAlive()&&unit.isAlive()&&this.agilityPints>=unit.agilityPints) unit.minusHealth(this.attackPoints+addirionalAt);
        if (unit.isAlive()&&this.isAlive()&&unit.agilityPints>=this.agilityPints) this.minusHealth(unit.attackPoints);

    }

    @Override
    public void rest() {
        plusHealth(3);

    }
}
