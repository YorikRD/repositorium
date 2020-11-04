package com.ifmo.jjd.lesson6;

public class Application {
    public static void main(String[] args) {
        ColoringBook mursilka = new ColoringBook(); // here we call the constructor.
        ColoringBook mursilka2 = new ColoringBook();// here we call the constructor. again
        mursilka.setName("Super Book!");
        mursilka2.setName("Flowers");
        System.out.println(mursilka.getName());
        System.out.println(mursilka2.getName());
        AutherClass auther1 = new AutherClass();
        auther1.setFirstNname("Ivan");
        auther1.setSurname("Petrov");
        System.out.println(auther1.getfullName());
        mursilka.setAuther(new AutherClass("IVAN","dURAK"));
        System.out.println(mursilka.getAuther().getfullName());
        System.out.println(mursilka);
        ColouringShelf shelf = new ColouringShelf("blue",15);
        System.out.println(shelf);
        shelf.putColourBook(mursilka);
        shelf.putColourBook(mursilka2);
        System.out.println(shelf);
        System.out.println(shelf.getBooksInfo());
        shelf.addColouring(mursilka,mursilka2);




    }


}
