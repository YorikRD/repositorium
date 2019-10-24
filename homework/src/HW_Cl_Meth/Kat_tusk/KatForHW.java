package HW_Cl_Meth.Kat_tusk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KatForHW {
    private String name;
    private int age;
    private  String colour;
    private String ownerAdress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Pattern patternName = Pattern.compile("(?=.[0-9a-zA-Z!,/])");
        Matcher matcherName = patternName.matcher(this.name);
        System.out.println(matcherName.find());
        if (matcherName.find()) {
            this.name = name;
        } else this.name = "Nameless";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age != 0) {
            this.age = age;
        } else this.age = 268;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        Pattern patternC = Pattern.compile("(?=.[0-9a-zA-Z!,/])");
        Matcher matcher = patternC.matcher(this.colour);
        if (matcher.find() == true ) {
            this.colour = colour;
        } else this.colour = "unkolored";
    }

    public String getOwnerAdree() {
        return ownerAdress;
    }

    public void setOwnerAdree(String ownerAdree) {
        Pattern patternA = Pattern.compile("(?=.[0-9a-zA-Z!,/])");
        Matcher matcher = patternA.matcher(this.ownerAdress);
        if (matcher.find() == true ) {
            this.ownerAdress= ownerAdress;
        } else this.ownerAdress= "ownerAdree not found";
    }
    public KatForHW(){}
    public KatForHW(String name){
        setName(name);
    }

    @Override
    public String  toString() {
        return "KatForHW{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                ", ownerAdress='" + ownerAdress + '\'' +
                '}';
    }
}
