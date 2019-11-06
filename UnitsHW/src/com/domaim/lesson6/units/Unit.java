package com.domaim.lesson6.units;

abstract public class Unit implements RestAble {
    protected String name; // protected = можно обратиться к свойству внутни данного класса и у его дочерних классов
    protected int health;
    protected int speed;
    protected int maxHp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name != null && !this.name.isEmpty() ) {
            this.name = name;
        } else {
            this.name = "Unnamed";
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= this.maxHp && health>0) {
            this.health = health;
        } else {
            this.health = this.maxHp;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Unit(String name, int speed) {
        setName(name);
        setSpeed(speed);
    }

    public boolean isAlive() { //возвращает труфолс
        return health > 0;
    }

    public void run() {
        System.out.println("Юнит перемещается со скоростью " + speed);
        getSpeed();
    }

}
