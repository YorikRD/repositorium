package com.domaim.lesson6.units;

public class Worrior extends BattleUnit {
    private final int maxHp = 30;
    private static int nomb = 0;

    public static int getNomb() {
        return nomb;
    }

    public static void setNomb(int nomb) {
        Worrior.nomb = nomb;
    }

    public  int getMaxHp() {
        return this.maxHp;
    }

    public Worrior(String name, int speed, int attackScrore, int health) {
        super(name, speed, attackScrore, health);
    }

    @Override
    public void attack(Unit enemy){
        if(enemy instanceof BattleUnit){
            enemy.setHealth(enemy.getHealth()+((BattleUnit) enemy).getAttackScrore()-this.getAttackScrore());
            System.out.println("Воини атаковал противкника  " +enemy.getName()+ " Нанеся "+ (this.getAttackScrore()-((BattleUnit) enemy).getAttackScrore()) );
        } else {
            enemy.setHealth(enemy.getHealth() - this.getAttackScrore());
            System.out.println("Воин атаковал беззащитного  " + enemy.getName());
        }

    }
    @Override //Переопределение метода. Может менять реализацию но
    public void rest(){
        this.health = this.health+1;
    }
    @Override
    public void setHealth(int health) {
        if (health <= this.getMaxHp()) {
            super.setHealth(health);
        } else {
            this.health = this.getMaxHp();
        }
    }


}
