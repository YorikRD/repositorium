package Farm.Animals;

public class WildAnimal extends Animal {
   protected int strength = 1;
   protected  int frigtened =0;

    public int getFrigtened() {
        return frigtened;
    }

    private void setFrigtened(int frigtened) {
        this.frigtened = frigtened;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void hunt (Domestic_Animal animal){
        if (this.speed >= animal.getSpeed()) {
            animal.setHealth(animal.getHealth()-this.strength);
        }
    }

    public WildAnimal(String name, int speed, int weight, int strength, int frigtened) {
        super(name, speed, weight);
        this.strength = strength;
        this.frigtened = frigtened;
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "strength=" + strength +
                ", frigtened=" + frigtened +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                '}';
    }
}
