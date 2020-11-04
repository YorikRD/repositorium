package com.ifmo.jjd.lesson11;

import java.util.Arrays;

public class EnumLessons {
    public static void main(String[] args) {
        Article article = new Article("Travell");
        article.setText("Txt");
        article.setCountry(Article.Country.AUSTRALIA);
        Article uk = new Article("Britany Joureney");
        uk.setCountry(Article.Country.UK);
        //enum methods
        Article.Country[] countries = Article.Country.values();
        System.out.println(Arrays.toString(countries));
        System.out.println(Article.Country.AUSTRALIA.ordinal());
        for (Article.Country country : countries) {// iter!!!!!
            System.out.println("country: " + country);
        }
        // returning enum instance by string
        System.out.println(Article.Country.valueOf("USA")); //Case upper/lower Matters if not present throw exeption.
        Article.Country byString = Article.Country.valueOf("USA");
        String cuntry = Article.Country.AUSTRALIA.name();
        cuntry = Article.Country.AUSTRALIA.toString();

        int highCode = Priority.HIGH.getCode();
        Priority.LOW.setCode(12);
        System.out.println(Priority.LOW.getCode());

        System.out.println(Operation.MULTIPLICATION.action(2, 6));
    }
}

enum Priority { //outside class!
    HIGH(100), MIDDLE(50), LOW(1);//without declaring arguments listed on constructor objects cannot be created.
    private int code;

    Priority(int code) { // constructors follow standart rules.
        this.code = code;
    }

    public int getCode() { // method is available to all elements of enum Prioeyrty any types of methods are available to create heare.Hi
        return code;
    }

    public void setCode(int code) { // method is available to all elements of enum Prioeyrty
        this.code = code;
    }

}

enum Operation { //outside class!
    SUM {
        @Override
        int action(int a, int b) {
            return a + b;
        }
    }, MULTIPLICATION {
        @Override
        int action(int a, int b) {
            return a * b;
        }
    };

    abstract int action(int a, int b);


}

// declare enum, group of logicaly linced constants.
// elements are given with , literal.
// if nothing is written before conctsnts ; literal is not nescessary.
//the constants are not Strings their type is declared after letters enum.
//the can be transported to string.
//their sintacsis is type. starting with upper letter.
//their text all with uppercase and woth _ instead od space
// Defualt for enum is default = package private.


class SomeClass {
    private EnunInClass enunInClass;

    public SomeClass(EnunInClass enunInClass) {
        this.enunInClass = enunInClass;
    }

    private enum EnunInClass { //no call oustside class. Getters are impossible(for enum as whole)
        TREE, SUN;
    }
}
