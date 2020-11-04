package lesson1;

public class FirstLesson {
    // ctrl+/ - singlestring comment
    /*
    multystring comment (ctrl+shoft+/)
     */
    //ctrl+alt+L = code align
    // entering point method main
    public static void main(String[] args) {
//        System.out.println("Run!Run!Run!!!!");
        byte byteVar1; // its best to form a habbit to create names with meaning. creation of  var
//        variable declaration
        byteVar1 = 35; // byteVar1 get information
        byteVar1 = 12; // change var.
        byte byteVar2 = 10;
        byte byteVar3, byteVar4;
        byte byteVar5 = 10, byteVar6 = 12;
        short shortVar = -155;
        int intVar = 312;
        int intVar2 = 1_000_123_000;
        long longVar = -3000000L; // only for long
        float floatVar = 5.7f;
        double doubleVar = 2.367;

        // char (2 bytes)
        // symbol nomber in unikod table

        boolean booleanVar = true;
        booleanVar = false;

        // Type merging.(Приведение типов)
        byte someByte = 10;
        int someInt = someByte; // variable someInt war created and then feelde with 10
        someInt = 200;
//        someByte = someInt;  doesnot wark.
        // явное приведение!
        someByte = (byte) someInt;

        int a = 10;
        int b = 91;
        int c = b % a;
//        System.out.println(c + " variable c");
        short x = 56;
        short y = 397;
//        short z = x%y;  result of all operations wth byte and short is always int!!!!!!!!!
        int res = x + y;
        long res2 = x / y;
        short rezTr = (short) (x + y);
        int n =100;
        double m =200.6;
//        int zeroDiv =n/0;
//        double zeroDivD = m/0;
//        System.out.println("Integer "+zeroDiv);
//        System.out.println("Integer "+zeroDivD);
        someByte =3;
        someByte =(byte) (someByte*7);
        someByte *=7; // the same. take somebyte multiply by 7 the assignment its comfortoble but troublemaking

        someInt =10;
        someInt = someInt +20;
        someInt +=20;
        //var =(condition) ? -> if true :if false

        int k =25;
        int l = 8;
      int wrk = 256;
      int res234 = ((wrk%2) == 0) ? wrk/2: wrk*2;
        System.out.println( "итого "+res234);



    }
}
