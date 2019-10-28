package Farm.Animals;

public class WildAnimal extends Animal {
    int strength = 1;
    int frigtened =0;

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

    public WildAnimal(String name, int speed, int weight, int strength, int frigtened) {
        super(name, speed, weight);
        this.strength = strength;
        this.frigtened = frigtened;
    }
}
