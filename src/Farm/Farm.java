package Farm;

import Farm.Animals.DomesticAnimal;
import Farm.Animals.WildAnimal;
import Farm.Farmers.Farmer;

import java.util.Arrays;

public class Farm {
    private int farmSize = 12;
    private DomesticAnimal[] farm = new DomesticAnimal[farmSize];
    private Farmer farmer;
    private WildAnimal[] forest = new WildAnimal[3];

    public void addWild(WildAnimal... newWildAnimals) {
        for (int i = 0; i < this.forest.length; i++) {
            if (this.forest[i] == null) {
                System.arraycopy(newWildAnimals, 0, this.forest,
                        i, newWildAnimals.length);
                break;
            }
        }
    }


    public void addDomest(DomesticAnimal... newDomestic_Animals) { //Многоточие в 3 точки это добавление массива
        int freeSp = 0;
        for (int i = 0; i < this.farm.length; i++) {
            if (this.farm[i] == null) {
                freeSp = freeSp + 1;
//                System.out.println(freeSp);
            }
        }
        System.out.println(freeSp);
        if (newDomestic_Animals.length > freeSp) {
            System.out.println("К сожалению на ферме не хватает места для добавления " + (newDomestic_Animals.length - freeSp) + "особей");
            return;
        }
        for (int i = 0; i < this.farm.length; i++) {

            if (this.farm[i] == null) {
                System.arraycopy(newDomestic_Animals, 0, this.farm,
                        i, newDomestic_Animals.length);
                break;
            }
        }
    }

    public void dayCycle(int cycle) {
        for (int ci = 0; ci <= cycle; ci++) { //


            if (farmer.getResource() < 5) {
                if (aliveNo() > 0) {
                    for (int i = 0; i < farmQuant(); i++) {
                        farmer.killForRes(farm[i]);
                        if (farmer.getResource() > 5) {
                            break;
                        }
                    }
                }
            }
//            System.out.println(farmer.getResource());
            if (farmer.dieFrHung()) { // проверка не умер ли он от голода
                System.out.println("Фермер " + farmer.getwName() + " Умер от голода на " + ci + " День");
                return;
            }
            farmer.consumeRes(); //Пункт 1 фермер ест.
            for (int i = 0; i <= farm.length - 1; i++) {
                if (farm[i] == null) {
                    break;
                }
                farmer.collect(farm[i]); //Собираем ресурс, в коллект встроена проверка на живость животного.
            }

            System.out.println("Идёт день номер " + ci + " У фермера " + farmer.getResource() + " Еды. На ферме " + aliveNo() + ":Живых животных");
            System.out.println(aliveNo());
            if (aliveNo() > 0) {
                int hunter = (int) (Math.random() * forest.length); // выбираем случайного охотника из леса
                System.out.println(forest[hunter].getName());
                if (forest[hunter].getFri() < 3) {

                    int prey = (int) (Math.random() * farmQuant()); // выбираем случайную жертву на ферме
                    System.out.println("случайная жертва до изменения - животное номер " + prey);
                    while (!farm[prey].isAlive()) { // перебираем жервт вока не найдется живая прерывание что живых нет выше
                        prey = (int) (Math.random() * farmQuant()); //
                        System.out.println("выбрано живое животное" + farm[prey].getName() + "  " + farm[prey].isAlive());

                    }
                    System.out.println("случайная жертва после измениея - животное номер " + prey);
//                System.out.println("Состояние жертвы до нападения " + farm[prey]);
                    forest[hunter].hunt(farm[prey]); //Охотимся
                    System.out.println("Хищник " + forest[hunter].getName() + " Напал на " + farm[prey].getName());
                    farm[prey].setAlive(); //Умираем
//                System.out.println("Состояние жертвы после нападения " + farm[prey]);
                    farmer.scareWild(forest[hunter]);
                } else {
                    System.out.println("Этот хищник " + forest[hunter].getName() + " Слишком напуган");
                }
                for (int i = 0; i < farmQuant(); i++) {
                    if (farm[i].isAlive()) {
                        farmer.feed(farm[i]);
                    }
                }
            }
        }
        System.out.println("Фермер " + farmer.getwName() + " успешно пережил все трудности.");
        for (int i = 0; i <= farm.length - 1; i++) {
            if (farm[i] != null && farm[i].isAlive()) {
                System.out.println("Выжило животное № " + i);
                System.out.println(farm[i].getName());
                System.out.println(farm[i]);
            }
        }
    }
    private int farmQuant(){
        int farmQuant = 0;
        for (int l = 0; l < farm.length; l++) {
            if (farm[l] != null) {
                farmQuant = farmQuant + 1;
            }
        } return farmQuant;

    }


    private int aliveNo(){
        int farmAlive = 0;
        for (int l = 0; l < farmQuant(); l++) {
            if (farm[l].isAlive()) {
                farmAlive = farmAlive + 1;

            }
        }return farmAlive;
    }



    public DomesticAnimal[] getFarm() {
        return farm;
    }

    public Farm(int farmSize, Farmer farmer) {
        this.farmSize = farmSize;
        this.farmer = farmer;
    }

    public WildAnimal[] getForest() {
        return forest;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "farmSize=" + farmSize +
                ", farm=" + Arrays.toString(farm) +
                ", farmer=" + farmer +
                ", forest=" + Arrays.toString(forest) +
                '}';
    }
}
