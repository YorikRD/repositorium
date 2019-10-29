package Farm;

import Farm.Animals.Domestic_Animal;
import Farm.Animals.WildAnimal;
import Farm.Farmers.Farmer;
import javafx.css.Match;

import java.util.Arrays;
import java.util.Random;

public class Farm {
    int farmSize = 12;
    private Domestic_Animal[] farm = new Domestic_Animal[farmSize];
    Farmer farmer;
    private WildAnimal[] forest = new WildAnimal[3];

    public void addWild(WildAnimal...newWildAnimals){
        for (int i = 0; i < this.forest.length; i++) {
            if (this.forest[i] == null) {
                System.arraycopy(newWildAnimals, 0, this.forest,
                        i, newWildAnimals.length);
                break;
            }
        }
    }


    public void addDomest(Domestic_Animal... newDomestic_Animals) { //Многоточие в 3 точки это добавление массива
        int freeSp = 0;
        for (int i = 0; i < this.farm.length; i++) {
            if (this.farm[i] == null) {
                freeSp = freeSp + 1;
//                System.out.println(freeSp);
            }
        }
        System.out.println(freeSp);
        if (newDomestic_Animals.length > freeSp) {
            System.out.println("К сожалению в библиотеке не хватает места для добавления " + (newDomestic_Animals.length - freeSp) + "особей");
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
            farmer.consumeRes(); //Пункт 1 фермер ест.
//            System.out.println(farmer.getResource());
            if (farmer.dieFrHung()) { // проверка не умер ли он от голода
                System.out.println("Фермер " + farmer.getFarmName() + "Умер от голода" + "На "+ci +" День");
                return;
            }
            for (int i = 0; i <= farm.length - 1; i++) {
                if (farm[i] == null) {
                    break;
                }
                farmer.collect(farm[i]); //Собираем ресурс, в коллект встроена проверка на живость животного.
            }
            int hunter = (int) ( Math.random() * forest.length ); // выбираем случайного охотника из леса
            int prey = (int) ( Math.random() * farm.length ); // выбираем случайную жертву на ферме
            System.out.println("случайная жертва - животное номер " + prey);
            while (farm[prey]== null && !farm[prey].isAlive() ){ // перебираем жерт вока не найдется не нулевая и живая
                prey = (int) ( Math.random() * farm.length ); // Тут ошибка!

            }
            forest[hunter].hunt(farm[prey]); //Охотимся
        }
    }

    public Domestic_Animal[] getFarm() {
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
