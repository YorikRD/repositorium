package com.domaim.lesson6.units;

public class Knight extends BattleUnit {

    static final int maxHp = 30;
    private static int nomb = 0;

    public static int getNomb() {
        return nomb;
    }

    public static void setNomb(int nomb) {
        Knight.nomb = nomb;
    }

    public static int getMaxHp() {
        return maxHp;
    }

    public Knight(String name, int speed, int attackScrore, int health) {
        super(name, speed, attackScrore, health);
    }
    @Override
    public void attack(Unit enemy){
        enemy.setHealth(enemy.getHealth()-this.attackScrore-this.speed+enemy.getSpeed());
        System.out.println("Рыцарь атаковал  " +enemy.getName());
    }
    @Override
    public void rest(){
        this.health = this.health+7;
    }
}
