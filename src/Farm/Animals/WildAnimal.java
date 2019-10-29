package Farm.Animals;

public class WildAnimal extends Animal {
   protected int strength = 1;
   protected int fri =0;

    public int getFri () {
        return fri;
    }

    public void setFri (int frigtened) {
        this.fri = frigtened;
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

    public WildAnimal(String name, int speed, int weight, int strength, int fri) {
        super(name, speed, weight);
        this.strength = strength;
        this.fri = fri;
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "strength=" + strength +
                ", frigtened=" + fri +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                '}';
    }
}
