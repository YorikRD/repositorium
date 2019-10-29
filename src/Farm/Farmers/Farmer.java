package Farm.Farmers;

import Farm.Animals.Animal;
import Farm.Animals.Domestic_Animal;
import Farm.Animals.WildAnimal;
import Farm.Farm;

 public class Farmer extends WorkerCl {
     protected String farmName = "Unnamed till Now";
     protected int resource = 6;
     private Boolean isAllive = true;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
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
        if (this.resource > 0){
        this.isAllive = true;
        } this.isAllive = false;
    }

    @Override
    public void collect(Domestic_Animal animal) { // Первая запись класс. вторая запись конкретный экземпляр класса.
        if (animal.isAlive()){
        this.resource = this.resource + animal.getResourceOutput();
        } // не доим мёртвый коров!
    }

    @Override
    public void scareWild(WildAnimal wildAnimal) {
//        System.out.println("Попытка пугать");
        int rand =(int) (Math.random()*100);
        System.out.println(rand);
        if (rand >= 75){
           wildAnimal.setFri(wildAnimal.getFri()+1);
//           System.out.println(wildAnimal.getName()+ "  Напуган");
        }
    }

    @Override
    public void killForRes(Domestic_Animal animal) {
        if (animal.isConsumable()&& animal.isAlive()) {
            animal.setHealth(animal.getHealth() - 20);
            animal.setAlive();
            this.setResource(animal.getWeight() + this.getResource());
            System.out.println("Фермер " + this.getFarmName() + " забрил " + animal.getName() + " Получив " + animal.getWeight() + " Пищи");
        }
    }

     @Override
     public void feed(Domestic_Animal animal) {
         if (animal.isAlive() && animal.getHealth()<animal.getMaxHp()){
             animal.setHealth(animal.getHealth()+1);
         }
     }

     @Override
    public boolean dieFrHung() {
        if (this.resource < 0){
            return true;
        } return false;
    }

    @Override
    public void consumeRes() {
        this.resource = this.resource  - 5;
    }

    public Farmer(String farmName, int resource, Boolean isAllive) {
        this.farmName = farmName;
        this.resource = resource;
        this.isAllive = isAllive;
    }

     @Override
     public String toString() {
         return "Farmer{" +
                 "farmName='" + farmName + '\'' +
                 ", resource=" + resource +
                 ", isAllive=" + isAllive +
                 '}';
     }
 }
