package Farm.Farmers;

import Farm.Animals.DomesticAnimal;
import Farm.Animals.WildAnimal;

abstract public class WorkerCl implements Worker {
    private String wName = "Unnamed till Now";
    private int resource = 6;
    private Boolean isAllive = true;
    @Override
    public void collect(DomesticAnimal animal) {

    }

    @Override
    public void killForRes(DomesticAnimal animal) {

    }

    @Override
    public void feed(DomesticAnimal animal) {

    }

    @Override
    public boolean dieFrHung() {
        return false;
    }

    @Override
    public void scareWild(WildAnimal animal) {

    }

    @Override
    public void consumeRes() {

    }
}


