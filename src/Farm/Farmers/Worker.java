package Farm.Farmers;

import Farm.Animals.Domestic_Animal;

public interface Worker {
     void collect ();
    public void killForRes ();
    public void feed ();
    boolean dieFrHung();

    void collect (Domestic_Animal animal);

    public void scareWild();
    public void consumeRes();
}
