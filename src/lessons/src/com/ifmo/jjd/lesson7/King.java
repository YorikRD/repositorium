package com.ifmo.jjd.lesson7;

public class King extends Unit {
    protected int gold = 600;
    private BattleUnit[] army = new BattleUnit[20];

    @Override
    public void rest() {
        minisGold(20);
    }

    public void startAttack(King enemy){
        for (int i = 0; i <this.army.length ; i++) {
            int rnd =(int)(Math.random()*this.army.length);
            int rnd2 = (int)(Math.random()*enemy.army.length);
            this.army[rnd].attack(enemy.army[rnd2]);
            this.army[rnd].rest();
        }

    }

    public King(int healthPoints, int agilityPints) {
        super(healthPoints, agilityPints);
    }

    public void plusGold(int plus) {
        if (plus <= 0) return;
        this.gold += plus;
    }

    public void minisGold(int minus) {
        if (minus <= 0) return;
        if (hasgold()) {
            this.gold -= minus;
            if (!hasgold()) this.gold = 0;
        }
    }

    public boolean hasgold() {
        return (gold > 0) ? true : false;
    }

    public void generateArmy() {
        if (this.gold < 250) return;
        for (int i = 0; i < army.length; i++) {
            army[i]=BattleUnit.battleUnitFactory();
        }

        minisGold(250);
        // 3 first - infantry
        // all others - knights.
        // inheritens polymorhysm
    }

    public int getAttRes(){
        int alive =0;
        for (BattleUnit unit:army ) {
            if (unit.isAlive()) alive++;
        }
        return  alive;
    }


    public void addCombatUnitw() {
        for (int i = 0; i < army.length; i++) {
            if (this.gold >= 20 && !army[i].isAlive())
                army[i] = BattleUnit.battleUnitFactory();
        }
    }
}
