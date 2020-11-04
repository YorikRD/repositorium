package com.ifmo.jjd.lesson10.sometask.taskFl;

public class Bouquet {
    private Flower[] flowers = new Flower[5];
    private int price = 0;
    private int date = 0;
    private static int count=0;

    public Flower[] getFlowers() {
        return flowers;
    }

    public int getPrice() {
        return price;
    }

    public int getDate() {
        return date;
    }

    public Bouquet() {

    }

    public void addFl(Flower... floweradd) {

        int b = 0;
        for (int i = 0; i < flowers.length&&b<floweradd.length; i++) {
            if (flowers[i] == null){
                if (floweradd[b]!= null){
                    flowers[i] = floweradd[b];
                    b++;
                }
            }

        }
        updateprice();
    }
    public void updateprice(){
        price =0;
        for (Flower fl: flowers ) {
                        if (fl != null){
                            price += fl.getPrice();
                        }
        }
    }

    public void sellBuq(int money){
        if (money>=this.price) System.out.println("The Bouquer is sold");
        count++;
    }

    public static int getSold(){
        return count;
    }
}
