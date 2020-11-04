package com.ifmo.jjd.lesson6;

// Bublic class name MUST match file name.
//it can be only one public class in a file.
// any number of nonpublic classes can be insiden a file.
//Public class is visible via all programm. Simple classes are visible only inside package.
public class ColoringBook {
    private String name; // default null.
    private int nombOfPict;
    private AutherClass auther;

    //
    // Default feald vlaue :
    // boolean = faulse
    //Int/long/byte = 0
    // float double = 0.0
    // link = Null
    //char uf/0000
    // eccess modifiers
    // private - only inside currient class! ,etveen its {}
    // public - ara avalible from any code point
    // package-private/default = unset modifier = fields and methofs are avalible inside package.
    //protected = are avalible as package-private and from inherited classes.
    // setters are methods inside class which allows us to modify private fields.

    public void setName (String name) { // name is String argument
        this.name=name; // this is not mandatory if  arg in method differs from class field name.
        if (name == null ||name.length()<3){
            throw new IllegalArgumentException("title must not be longer then 3!");
        }
    }

    public String getName (){
        return name; // return - point of breaking methods work.
    }

    public int getNombOfPict() {
        return nombOfPict;
    }

    public void setNombOfPict(int nombOfPict) {
        if(nombOfPict<5) throw new IllegalArgumentException(" NombOf Pict mus be 5 and more");
        this.nombOfPict = nombOfPict;
    }

    public AutherClass getAuther() {
        return auther;
    }

    public void setAuther(AutherClass auther) {
        if (auther == null)
            throw new IllegalArgumentException(" auther must not be null");
        this.auther = auther;
    }

    @Override
    public String toString() {
        return "ColoringBook{" +
                "name='" + name + '\'' +
                ", nombOfPict=" + nombOfPict +
                ", auther=" + auther +
                '}';
    }
}
