package Farm;

import Farm.Animals.Domestic_Animal;
import Farm.Farmers.Farmer;

public class Main {
    public static void main(String[] args) {
      Domestic_Animal Cow1 = new Domestic_Animal("Cow",5,20,12,3,true, true);
        Domestic_Animal Cow2 = new Domestic_Animal("Cow",5,20,12,3,true, true);
        Domestic_Animal Rab1 =new Domestic_Animal("Rabbit",15,2,2,0,true, true);
        Domestic_Animal Rab2 =new Domestic_Animal("Rabbit2",15,2,2,0,true, true);
        Domestic_Animal Rab3 =new Domestic_Animal("Rabbit3",15,2,2,0,true, true);
        Domestic_Animal Chi1 =new Domestic_Animal("Chikken1",5,2,1,1,true, true);
        Domestic_Animal Chi2 =new Domestic_Animal("Chikken2",5,2,1,1,true, true);
        Domestic_Animal Chi3 =new Domestic_Animal("Chikken3",5,2,1,1,true, true);
        Domestic_Animal Chi4 =new Domestic_Animal("Chikken4",5,2,1,1,true, true);
        Domestic_Animal Chi5 =new Domestic_Animal("Chikken5",5,2,1,1,true, true);

       Farmer petrovich = new Farmer("Петрович",3,true);
       Farm farm1 = new Farm(15, petrovich );
       farm1.addDomwest(Cow1,Cow2,Rab1,Rab2,Rab3,Chi1,Chi2,Chi3,Chi4,Chi5);


    }
}
