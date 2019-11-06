package com.domaim.lesson6.units;

public class King extends Unit {

    static final int maxHp = 30;
    private static int nomb = 0;

    public static int getNomb() {
        return nomb;
    }

    public static void setNomb(int nomb) {
        King.nomb = nomb;
    }

    public static int getMaxHp() {
        return maxHp;
    }

    public static King kingCoronation (BattleUnit annoiter){
        King newKing = new King("324",12,22);
        newKing.setName("Crowned by "+annoiter.getName()+" is " +getNomb() +"the world");
        King.setNomb(King.getNomb()+1);
        newKing.setSpeed(25+10-(int)(Math.random()*15));
//        newKing.setHealth(16+10-(int)(Math.random()*15));  а вот здесь какой- то баг
        return newKing;
    }

    private King(String name, int speed, int health) {
        super(name, speed);
        this.health = health;
    }


    @Override
    public void rest(){
        this.health = this.health+7;
    }


    @Override
    public String toString() {
        return "King{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }

}
