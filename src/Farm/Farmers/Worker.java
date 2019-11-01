package Farm.Farmers;

import Farm.Animals.DomesticAnimal;
import Farm.Animals.WildAnimal;

public interface Worker {
    public void collect (DomesticAnimal animal);
    public void killForRes (DomesticAnimal animal);
    public void feed (DomesticAnimal animal);
    boolean dieFrHung();
    public void scareWild(WildAnimal animal);
    public void consumeRes();
}
