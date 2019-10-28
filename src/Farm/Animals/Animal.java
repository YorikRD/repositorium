package Farm.Animals;

public class Animal {
    protected String name = "Без кличнки";
    protected int speed = 1;
    protected int weight = 2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Animal(String name, int speed, int weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
    }
}
