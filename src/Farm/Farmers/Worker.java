package Farm.Farmers;

import Farm.Animals.Domestic_Animal;
import Farm.Animals.WildAnimal;

public interface Worker {
    public void collect (Domestic_Animal animal);
    public void killForRes ();
    public void feed (Domestic_Animal animal);
    boolean dieFrHung();
    public void scareWild();
    public void consumeRes();
}
