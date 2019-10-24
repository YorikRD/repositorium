package HW_Cl_Meth.Kat_tusk;

public class KatForHW {
    private String name;
    private int age;
    private String colour;
    private String ownerAdress;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            this.name = "Nameless";
            System.out.println("Задайте коту имя!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            this.age = 268;
            System.out.println("Задайте возраст кота!");
        }
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        if (!colour.isEmpty()) {
            this.colour = colour;
        } else {
            this.colour = "Unknown";
            System.out.println("Укажите цвет кота!");
        }
    }

    public String getOwnerAdress() {
        return ownerAdress;
    }

    public void setOwnerAdress(String ownerAdress) {
        if (!ownerAdress.isEmpty()) {
            this.ownerAdress = ownerAdress;
        } else {
            this.ownerAdress = "Unknown";
            System.out.println("Укажите адрес владельца");
        }
    }

    public KatForHW() { // При использовании данного метода проверки не работаеют
        this.name = "Namless";
        System.out.println("Задайте коту имя!");
        this.age = 268;
        System.out.println("Задайте возраст кота!");
        this.colour ="Unknown";
        System.out.println("Укажите цвет кота!");
        this.ownerAdress = "Unknown";
        System.out.println("Укажите адрес владельца");
    }

    public KatForHW(String name) {
        setName(name);
        this.age = 268;
        System.out.println("Задайте возраст кота!");
        this.colour ="Unknown";
        System.out.println("Укажите цвет кота!");
        this.ownerAdress = "Unknown";
        System.out.println("Укажите адрес владельца");
    }

    public KatForHW(String name, int age) {
        setName(name);
        setAge(age);
        this.colour ="Unknown";
        System.out.println("Укажите цвет кота!");
        this.ownerAdress = "Unknown";
        System.out.println("Укажите адрес владельца");
    }

    public KatForHW(String name, int age, String colour) {
        setName(name);
        setAge(age);
        setColour(colour);
        this.ownerAdress = "Unknown";
        System.out.println("Укажите адрес владельца");
    }

    public KatForHW(String name, int age, String colour, String ownerAdress) {
        setName(name);
        setAge(age);
        setColour(colour);
        setOwnerAdress(ownerAdress);
    }


    @Override
    public String toString() {
        return "KatForHW{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                ", ownerAdress='" + ownerAdress + '\'' +
                '}';
    }
}
