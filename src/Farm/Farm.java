package Farm;

import Farm.Animals.Domestic_Animal;
import Farm.Farmers.Farmer;

import java.util.Arrays;

public class Farm {
    int farmSize = 12;
    private Domestic_Animal[] farm = new Domestic_Animal[farmSize];
    Farmer farmer;

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
            System.out.println("К сожалению в библиотеке не хватает места для добавления " + (newDomestic_Animals.length - freeSp) + " Книг");
            return;
        }
        for (int i = 0; i < this.farm.length; i++) {
//            System.out.println(this.books.length);

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
            int alive = 0;
            for (int i=0;  i <= farm.length - 1; i++){
                if (farm[i].isAlive()){
                    alive++;
                }
            }
            Domestic_Animal[] huntGr = new Domestic_Animal[alive]; // Создаем массив живых животных для охоты.




        }
    }

    public Domestic_Animal[] getFarm() {
        return farm;
    }

    public Farm(int farmSize, Farmer farmer) {
        this.farmSize = farmSize;
        this.farmer = farmer;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "farmSize=" + farmSize +
                ", farm=" + Arrays.toString(farm) +
                ", farmer=" + farmer +
                '}';
    }
}
