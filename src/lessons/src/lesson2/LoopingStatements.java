package lesson2;

import java.util.Scanner;

public class LoopingStatements {
    // i++  returns value of then increase i value by 1
    // i-- returns value of then increase i value by 1
    // ++i  increase i value by 1 then returns value of
    // --i  decrease i value by 1 then returns value of
    public static void main(String[] args) {
        //while cicle
        /*
        while(condition boolean){
        instructions
        }
        */
        int read =55;
        while (read<=78){
            System.out.println(read);
            read++;
        }

        Scanner scanner = new Scanner(System.in);

        int num2 =1;
//        while (num2 !=0) {
//            System.out.println("Введите целое число");
//            num2 =scanner.nextInt();
//            if (num2!=0){
//            System.out.println("Введённое число увеличенное на 2 = "+(num2+2));}
//            else {
//                System.out.println("Завершение цикла по команде");
//            }
//        }

////
//
//         do {
//             System.out.println("Введите целое число, введение 0 завершает работу");
//             num2 =scanner.nextInt();
//             System.out.println("Введённое число увеличенное на 2 = "+(num2+2));
//         } while (num2 !=0);
//        System.out.println("Завершение цикла по команде 0 ");
//        for (int i = 0; i < 9; i++) {
//
//        }
    }
}
