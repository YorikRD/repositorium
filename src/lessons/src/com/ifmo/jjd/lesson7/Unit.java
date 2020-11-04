package com.ifmo.jjd.lesson7;
//Class Unit now impliments Restable interface, now it must realise all methods without realisation of this interface,
// we must give void rest() some realisation in {}
abstract public class Unit implements RestAble { // after adding label abstract class will be excluded from rule to realise all interfaces it imliments
    // if class is abstract it can hold methods either with ow without realisation, and it will newer have instances.
    protected int healthPoints;
    protected int agilityPints;

    protected final int maxHealth;

    public Unit(int healthPoints, int agilityPints) {
        if(healthPoints<0|| agilityPints <0)
            throw new IllegalArgumentException(" Health and agility must be >0");
        maxHealth=healthPoints;
        this.healthPoints = healthPoints;
        this.agilityPints = agilityPints;

    }

    public void plusHealth(int points) {
        if (isAlive()) {
            healthPoints = ((healthPoints + points) <= maxHealth) ? healthPoints + points : maxHealth;
        }
    }

    public void minusHealth(int points) {
        if (isAlive()) {
            healthPoints = healthPoints - points;
            if (!isAlive()) {
                healthPoints=0;
            }
        }
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }
}
