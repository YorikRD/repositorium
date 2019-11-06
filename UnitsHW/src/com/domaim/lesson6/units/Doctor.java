package com.domaim.lesson6.units;

public class Doctor extends BattleUnit {
        static final int maxHp = 50;
        private static int nomb = 0;

    public static int getNomb() {
        return nomb;
    }

    public static void setNomb(int nomb) {
        Doctor.nomb = nomb;
    }

    public static int getMaxHp() {
        return maxHp;
    }


    public Doctor(String name, int speed, int attackScrore, int health) {
        super(name, speed, attackScrore, health);
    }

    @Override
    public void attack(Unit enemy){
        if (this.speed > enemy.getSpeed()&& enemy.getHealth()<enemy.maxHp) {
            int enBs = enemy.getHealth();
            enemy.setHealth(enemy.getHealth()+this.attackScrore);
            int enAft =  enemy.getHealth();
            int res = enAft - enBs;
            System.out.println("Доктор вылечил  " + enemy.getName() + " на "+res);
        } else {
            this.setHealth(this.getHealth()+this.attackScrore);
            System.out.println("Доктор вылечил самого себя после ранения");
        }
    }

    public void healersMercy(BattleUnit healed){
        this.setHealth(getMaxHp());
    }

    @Override
    public void rest(){
        this.health = this.health+7;
    }
}
