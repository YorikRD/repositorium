package Farm.Farmers;

import Farm.Animals.Domestic_Animal;

abstract public class WorkerCl implements Worker {
    @Override
    public void collect() {

    }

    @Override
    public void killForRes() {

    }

    @Override
    public void feed() {

    }

    @Override
    public boolean dieFrHung() {
        return false;
    }

    @Override
    public void collect(Domestic_Animal animal) {

    }

    @Override
    public void scareWild() {

    }

    @Override
    public void consumeRes() {

    }
}
