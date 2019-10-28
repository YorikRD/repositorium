package Farm;

import Farm.Animals.Domestic_Animal;
import Farm.Farmers.Farmer;

import java.util.Arrays;

public class Farm {
    int farmSize = 12;
    private Domestic_Animal[] farm = new Domestic_Animal[farmSize];
    Farmer farmer;

    public void addDomwest(Domestic_Animal... newDomestic_Animals) { //Многоточие в 3 точки это добавление массива
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

    public void dayCycle(int Cycle){
        farmer.consumeRes();
        System.out.println(farmer.getResource());
        if (farmer.dieFrHung()){
            System.out.println("Фермер " +farmer.getFarmName() + "Умер от голода" );
            return;
        }
        for (int i=0;i<= farmSize-1; i++){
            farmer.collect(farm[i]);
        }
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
