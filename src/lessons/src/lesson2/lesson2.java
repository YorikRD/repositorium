package lesson2;

public class lesson2 {
    public static void main(String[] args) {
        //if else
         /*
        if (boolean condition 1) {
        instructions
        } else if (boolean condition 2...) {
        instructions
        } else if (boolean condition 3...) {
        instructions
        } else { instructions if all false}
        */

         int state = 0;
         if (state ==0) {
             System.out.println("Application abbort");
         } else if(state == 1) {
             System.out.println("Aplication initialising");
         } else {
             System.out.println("Status Error");
         }

         state = 0;
         int code = 60;

         boolean isColsed = false;
        System.out.println(!isColsed);

        int count = 75;
        // 100-90 - 5
        //89-60 - 4
        //59-40 -3
        // 0-39 -2.
        if (count <= 100 && count > 0) {
            System.out.println(" Error");
        }
        else if( count >=90) {
            System.out.println(" Your grade is 5 !");
        } else if (count <=89 && count >=60){
            System.out.println(" Your grade is 4 !");
        } else if (count <=59 && count >=40){
            System.out.println(" Your grade is 3 !");
        } else {
            System.out.println(" Your grade is 2 you failed!");
        }


        /*
         switch(statenent/var)
        var types
        byte() Byte, short() Short, char() Character, int() Integer, String, enum().

         switch (statenment/var){
         case statenment1/var1:
         instr1;
        case statenment2/var2:
         instr2;
         case statenment3/var3:
          instr3;
          break;
          default:
          instr3
          break;}

          after finding matching case instruction it is applied until break;
         */


        int sum = 10000;
        int codeDisc = 9113;
        //4653 = 30%
        //5698, 5111 = 20%
        //6922. 9113. 6099 - 10%
        // else - no discount.

        switch (codeDisc) {
            case 4653:
                System.out.println("Your feee is "+(int)(sum*0.7));
                break;
            case 5698:
            case 5111:
                System.out.println("Your feee is "+(int)(sum*0.8));
                break;
            case 6922:
            case 9113:
            case 6099:
                System.out.println("Your feee is "+(int)(sum*0.9));
                break;
            default:
                System.out.println("Your feee is "+(int)(sum*1));
                break;
        }



    }
}
