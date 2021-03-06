package Farm.Farmers;

import Farm.Animals.DomesticAnimal;
import Farm.Animals.WildAnimal;

public class Farmer extends Farm.Farmers.WorkerCl implements Farm.Farmers.Worker {
    private String wName = "Unnamed till Now";
    private int resource = 6;
    private Boolean isAllive = true;

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
                this.wName = wName;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public Boolean getAllive() {
        return isAllive;
    }

    public void setAllive(Boolean allive) {
        if (this.resource > 0) {
            this.isAllive = true;
        }
        this.isAllive = false;
    }

    @Override
    public void collect(DomesticAnimal animal) { // Первая запись класс. вторая запись конкретный экземпляр класса.
        if (animal.isAlive()) {
            this.resource = this.resource + animal.getResourceOutput();
        } // не доим мёртвый коров!
    }

    @Override
    public void scareWild(WildAnimal wildAnimal) {
//        System.out.println("Попытка пугать");
        int rand = (int) (Math.random() * 100);
        if (rand >= 75) {
            wildAnimal.setFri(wildAnimal.getFri() + 1);
//           System.out.println(wildAnimal.getName()+ "  Напуган");
        }
    }

    @Override
    public void killForRes(DomesticAnimal animal) {
        if (animal.isConsumable() && animal.isAlive()) {
            animal.setHealth(animal.getHealth() - 20);
            System.out.println("Фермер " + this.getwName() + " забрил " + animal.getName() + " Получив " + animal.getWeight() + " Пищи");
            animal.setAlive();
            this.setResource(animal.getWeight() + this.getResource());

        }
    }

    @Override
    public void feed(DomesticAnimal animal) {
        if (animal.isAlive() && animal.getHealth() < animal.getMaxHp()) {
            animal.setHealth(animal.getHealth() + 1);
        }
    }

    @Override
    public boolean dieFrHung() {
        if (this.resource <= 4) {
            return true;
        }
        return false;
    }

    @Override
    public void consumeRes() {
        this.resource = this.resource - 5;
    }

    public Farmer(String wName, int resource, Boolean isAllive) {
        this.wName = wName;
        this.resource = resource;
        this.isAllive = isAllive;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "farmName='" + wName + '\'' +
                ", resource=" + resource +
                ", isAllive=" + isAllive +
                '}';
    }
}
