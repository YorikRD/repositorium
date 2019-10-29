package Farm.Farmers;

import Farm.Animals.Animal;
import Farm.Animals.Domestic_Animal;
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
    public void scareWild() {

    }

    @Override
    public void killForRes() {

    }

     @Override
     public void feed() {
         super.feed();
     }

     @Override
    public boolean dieFrHung() {
        if (this.resource <= 0){
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
