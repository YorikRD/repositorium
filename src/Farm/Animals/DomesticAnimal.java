package Farm.Animals;

public class DomesticAnimal extends Animal {
    protected int health = 3;
    protected int resourceOutput = 0;
    protected boolean isAlive = true;
    protected boolean isConsumable = true;
    protected int maxHp = 3;

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        if (maxHp > 0 && maxHp >= this.health ) {
            this.maxHp = maxHp;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > 0) {
            this.health = health;
        }
    }

    public int getResourceOutput() {
        return resourceOutput;
    }

    public void setResourceOutput(int resourceOutput) {
        this.resourceOutput = resourceOutput;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive() {
//        System.out.println(" Здоровье этой животины " +this.getHealth());
        if (this.getHealth() > 1) {
            System.out.println("Он жив");
            this.isAlive = true;
        } else {
            this.isAlive = false;
            System.out.println(this.getName() + "  умер");
        }
    }

    public boolean isConsumable() {
        return isConsumable;
    }

    public void setConsumable(boolean consumable) {
        isConsumable = consumable;
    }

    public DomesticAnimal(String name, int speed, int weight, int health, int resourceOutput, boolean isAlive, boolean isConsumable, int maxHp) {
        super(name, speed, weight);
        setHealth(health);
        setResourceOutput(resourceOutput);
        this.isAlive = true;
        this.isConsumable = isConsumable;
        setMaxHp(maxHp);
    }

    @Override
    public String toString() {
        return "DomesticAnimal{" +
                "health=" + health +
                ", resourceOutput=" + resourceOutput +
                ", isAlive=" + isAlive +
                ", isConsumable=" + isConsumable +
                ", maxHp=" + maxHp +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                '}';
    }
}
