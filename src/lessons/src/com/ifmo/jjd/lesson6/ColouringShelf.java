package com.ifmo.jjd.lesson6;

import java.util.Arrays;

public class ColouringShelf {
    private String colour = "red";
    private ColoringBook[] coloring;

    public ColouringShelf(int count) {
        if (count<10)
            throw new IllegalArgumentException("count mus be more");
        coloring = new ColoringBook[count];
    }

    public ColouringShelf(String colour, int count) {
       this(count); //сall first Constructor! "this" = call constructoк with (args)
        setColour(colour);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        if (colour == null || colour.strip().length()<3){
            throw new IllegalArgumentException("colour must not be longer then 3!");
        }
        this.colour = colour;
    }

    public void putColourBook(ColoringBook book){
        for (int i = 0; i < coloring.length; i++) {
            if (coloring[i] == null){
                coloring[i] = book;
                return;//return in void methods is used to stop method. Here we can use aither break or return, Return will stop method, break will stop only cycle.
            }
        }
    }

    public void addColouring(ColoringBook ...books){

    }

    public String getBooksInfo(){
        StringBuilder afd = new StringBuilder();
        for (ColoringBook book: coloring){
            if(book != null) {
                afd.append(book.getName())
                        .append(" ")
                        .append(book.getNombOfPict())
                        .append("\n");
            }
        }
        return afd.toString();
    }

    @Override
    public String toString() {
        return "ColouringShelf{" +
                "colour='" + colour + '\'' +
                ", coloring=" + Arrays.toString(coloring) +
                '}';
    }
}
