package homework_1;

import java.util.Arrays;

public class Home_work_1 {
    public static void main(String[] args) {
        // Задние номер №1 наибольший общий делитель (целый)
        int del1 = 368; //ввести число для поиска НОД
        int del2 = 69; // ввести число для поиска НОД
        int del3;
        if (del1 >= del2) {
            del3 = del2;
        } else del3 = del1;
        int w = 0;
        for (int i = del3; w == 0; i--) {
            if (del1 % i == 0) {
                if (del2 % i == 0) {
                    w = w + 1;
                    System.out.println("наибольшией общий делитеь  " + i);
                } else {
                    w = w + 0;
                }
                ;
            } else {
                w = w + 0;
            }
            ;
        }
//
//
//
//
//
//
//        // Задание №2 перевод из десятичной в двоичную и шеснадцетиричную системы:
        int b = 16; // Объявляем систему исчисления в котрую будем переводить число
        int arg = 156;// Объявлем число в десятичной системе исчисления
        int arg2 = arg;  //Создаём дубликат числа для перевода
        int arg3 = arg;  // Создаём ещё один дубликат.
        int arg4 = arg;  // Создаём ещё один дубликат.
        int ost2; // Ввводим переменную "остаток"
        int Por = 1; // Вводим переменную "порядок"
        while (arg >= b) { // Вычисляем переменную порядок для последующего создания масива
            arg = arg / b;
            Por = Por + 1;
        }
//        System.out.println(" Порядок " + Por); // Выводим переменную порядок, для проверки
        int[] aee = new int[Por]; // Создаем массив aee c и длинной порядок.
        for (int i = 0; arg2 >= b; i++) {
            ost2 = arg2 % b;
            arg2 = arg2 / b;
            aee[i] = ost2; // Заполняем массив aee тем самым воспрозводя стандартную операцию по переводу из десятичной
            //системы в иную (в нашем случа b) при этом  теряется последнее значние (самый больший разряд)
//            System.out.println("Аргументы " + arg); // Проверочный вовод пошагово
//            System.out.println("Остатки " + ost2); // Проверочный вовод пошагово
//            System.out.println("Шаг " + i);// Проверочный вовод пошагово
        }
        int z = 0; // Ввводим пременуую z для вычисления значния в последнем самом большем разряде
        while (z < (Por - 1)) { // Вычисляем это значение.
            arg3 = arg3 / b;
            z = z + 1;
        }
        aee[(Por - 1)] = arg3; // Записываем в последний индекс массива вычесленное значение.
//        for (int i = 0; i < Por; i++) {
//            System.out.println(aee[i]);
//        }
        int eea[] = new int[Por]; // Создем массив с нормаль под не развернутую последовательность
        for (int i = 0; i < (Por - 1); i++) {
            eea[i] = aee[((Por - 1) - i)];
        }
        eea[(Por - 1)] = aee[0]; // Опять записываем последнее теряемое
        for (int i = 0; i < Por; i++)
            System.out.println(eea[i]); //проверяем перевод
        char out[] = new char[Por]; // объяаляем массив с типом char и нужной длинны
        for (int i = 0; i <= (Por - 1); i++) { //заполняем его символьными переменными цикл заполнент для 16ричной системы
            if (eea[i] == 1) {
                out[i] = '1';
            } else if (eea[i] == 0) {
                out[i] = '0';
            } else if (eea[i] == 2) {
                out[i] = '2';
            } else if (eea[i] == 3) {
                out[i] = '3';
            } else if (eea[i] == 4) {
                out[i] = '4';
            } else if (eea[i] == 5) {
                out[i] = '5';
            } else if (eea[i] == 6) {
                out[i] = '6';
            } else if (eea[i] == 7) {
                out[i] = '7';
            } else if (eea[i] == 8) {
                out[i] = '8';
            } else if (eea[i] == 9) {
                out[i] = '9';
            } else if (eea[i] == 10) {
                out[i] = 'A';
            } else if (eea[i] == 11) {
                out[i] = 'B';
            } else if (eea[i] == 12) {
                out[i] = 'C';
            } else if (eea[i] == 13) {
                out[i] = 'D';
            } else if (eea[i] == 14) {
                out[i] = 'E';
            } else if (eea[i] == 15) {
                out[i] = 'F';
            } else {
                out[i] = '#';
            }
        }
        System.out.printf("Число %s в десятичной в системе %s запись выглядит как ", arg4, b);
        System.out.println(out);

        System.out.println("Симовол # озанчает что выбрана система более 16-тиричной и на вывод её символов программа не рассчитана");
        // Задание 4 - решено частично. находлит только одну нужную пару.

        int[] forSort = new int[]{2, 7, 3, 12, -7, 0, -6, 5,};
        int dl = forSort.length;
        System.out.println(Arrays.toString(forSort)); // проверочные выводы
        System.out.println(dl);// проверочные выводы
        Arrays.sort(forSort, 0, (dl - 1));
        System.out.println(Arrays.toString(forSort)); // проверочные выводы
//        for (int iter = 0; iter <= dl-1; iter++)
        int source;
        for (int iter = 0; iter <= (dl - 1); iter++) {
            source = 7 - forSort[iter];
            int firI = 0;
            int LasI = dl - 1;
//            System.out.println(" ПОСЛЕДНЕЕ " + LasI);
            while (firI <= LasI) {
                int MidI =(firI + LasI) / 2;
//                System.out.println("Cреднее " + MidI);
                if (forSort[MidI] == source) {
                    System.out.printf(" Нужные пары чисел %s + %s", forSort[iter], forSort[MidI]);
                    break;
                } else if (forSort[MidI] < source) {
                    firI = MidI + 1; // и вот здесь взрывается на 2 цикле выдаёт вместо 4 9
//                    System.out.println("После увеличиения выдали" + firI);
                } else if (forSort[MidI] > source) {
                    LasI = MidI - 1;
//                    System.out.println("После уменьшения выдали" + LasI);
                    }
                }

            }
        }
    }








