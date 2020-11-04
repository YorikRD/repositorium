package com.ifmo.jjd.lesson12;

import java.io.IOException;

public class Lesson12Exeption {
    public static void main(String[] args) {
/* All Errors and exeptions are exeplars of some class impliments interface od serialiseble and throwble.
Error - something coonectrd to jvm, its absolutely useles to check and deal, we must get rid of their creation.

Exeption - "исключения " is is possible to process all, its necessary to process some of them.

All exeptions are coverd with:
1 - RuntimeExeption and its childrenclasses
unchecked/необрабатываемые/неотслеживаемые/неконтролируемыею
Exeptions of thise type can be dealed in programm, and can be left andealed.
2 - All others (not childclasses to RuntimeExeption ) Exeption in time of interpritation
checked/ обрабатываемые/отслеживаемые/контролируемыею/ исключения времени компиляции
thise type of exeption MUST be processed in programm. Exeption in time of compilation.

* */
        int a = 30;
        int b = 0;
        int res;
//res = a/b;  Runtime exeption
        String s = null;
        int[] ints = new int[3];
//        s.equals("data"); nullpointe exeption.
        Object data ="126";
//        Integer integer =(Integer)data; //java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer
        // Exeption dealing (checked and unchecked)
        // "try catch" block and "finaly" block
        try{ // hear we put block of code which can lead some kind of exeption
            res=a/b; //hear       Arithmethic exeption will be created    in thise moment / -   we prograam will go to catch block

        } catch (ArithmeticException ariEx) //here is arg whick is ready to catch exeption of specific type or his child types (ArithmeticException) hear,
        // it is inicialised as ariEx - hear object.
        {
            System.out.println(ariEx.getMessage());   // data concerning exeption.
            ariEx.printStackTrace();
            res =10;

            //in thise block we write the instructions which programm will follow in case of listed in brackets exeption
        }
        System.out.println(" I am steel alive!" + res);
        //joining catch blocks for dealing with several exeptions.
        // Vars:
        //1 1. several catch blocks allowing us to deal with different exeptions with different code blocks

        try {
            if (System.currentTimeMillis()%2 ==0)data = (Integer)data;
            else ints[100] =90;
        } catch (ClassCastException e){ // catch ClassCastException and all its childrenclasses
            System.out.println(" Problems with bringing");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Problems with Array");
        }
        //Thise is created to deal with different ways to different exeption in common block of code.

        //2. all Exaptions must be dealed witk single way.
        try{
            if (System.currentTimeMillis()%2 ==0)data = (Integer)data;
        else ints[100] =90;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e){ // hear we are ready to cath in order two types of exepltion and
            // in finding first it will put in to "e"
            System.out.println("Problemm in array or bringing");
        }

        //3. throu common parrent class

        try{
            if (System.currentTimeMillis()%2 ==0)data = (Integer)data;
            else ints[100] =90;
        } catch (RuntimeException e){ // hear we are ready to cath in order two types of exepltion and
            // in finding first it will put in to "e"
            System.out.println("Problemm in Runtime");
        }

        try{
            if (System.currentTimeMillis()%2 ==0)data = (Integer)data;
            else ints[100] =90;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e){ // hear we are ready to cath in order two types of exepltion and
            // in finding first it will put in to "e"
            System.out.println("Problemm in array or bringing");
        } catch (RuntimeException e) {
            System.out.println("Problemm in smth else");
        } // thise is possible if order child->parent order not in reverse.


        finally {
            //code written in block  will run in case of any exeption , even not listed in catch block.
            //also is runned after cath block. in most case it is closing connection restoring some data to default values.
            System.out.println("Recource closing");
        }
        try {
            voidWithCheckedEx("file.json");
        } catch (IOException e) {
            e.getStackTrace();
        }

        Message message;
        try {
           message =new Message("te");
        } catch (ChatExaption e) {
            System.out.println(e.getMessage());
            try {
                throw  new ChatExaption("in catch",e);
            } catch (Throwable chatExaption) {
                chatExaption.printStackTrace();
            }
        }

        //any exeption may be generated with throw new ....



    }

    public static void voidWithCheckedEx(String filename ) throws IOException {
        if (filename.endsWith("json"))
            //generate and throw new Compilaton (type2) exeption. If not dealed it will not allow to compile code.
            throw new IOException("Problemm with file");
        //then we add exeption to method signature like hear, and we lay the responsibility for calling we
        // method with exaption to we one who calls thise method.
    }
}
