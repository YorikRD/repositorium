package com.domaim.lesson6.units;

public class Knight extends BattleUnit {

    private final int maxHp = 30;
    private static int nomb = 0;

    public static int getNomb() {
        return nomb;
    }

    public static void setNomb(int nomb) {
        Knight.nomb = nomb;
    }

    public  int getMaxHp() {
        return maxHp;
    }
    @Override
    public void setHealth(int health) {
        if (health <= this.getMaxHp()) {
            super.setHealth(health);
        } else {
            this.health = this.getMaxHp();
        }
    }

    public Knight(String name, int speed, int attackScrore, int health) {
        super(name, speed, attackScrore, health);
    }
    @Override
    public void attack(Unit enemy){
        int lim = enemy.getHealth();
        if (-this.attackScrore-this.speed+enemy.getSpeed() > 0){
            System.out.println("Рыцарь атаковал  " +enemy.getName() +" Атака промазала");
        } else {
        enemy.setHealth(enemy.getHealth()-this.attackScrore-this.speed+enemy.getSpeed());
        System.out.println("Рыцарь атаковал  " +enemy.getName()+" нанеся " +(lim -enemy.getHealth()) +" урона");
        }
    }
    @Override
    public void rest(){
        this.health = this.health+2;
    }
}
