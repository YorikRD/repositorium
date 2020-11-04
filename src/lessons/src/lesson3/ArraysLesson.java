package lesson3;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        // arrays [3,-7, 12, 13] all enterties of the same type
        //array length is defined while creation< anf cannot be modified.
        // arrays are not primitive information its elements are called by index< from zerro to legth-1;
        // array cration: data type[] nameArray;


//    int[] ints1; // name reserved
        // new int[length]; crating array feelrd with null;
        int[] ints1 = new int[5];
        // base nomb  =0
        // base boolean = faulse
        //char:'\u0000'()
        // ссылочные типы: null:
        int[] ints2 = {445, 90, 152, -880, 54, 8, -221};
        ints2 = new int[]{45, 12, -221};
        //element excess
        int aq = ints2[2]; //
        ints2[1] = 12;
        // request to unecsisting index of array will cause exeption.

//        //Array size is constant.
//        System.out.println(ints2.length);
//        System.out.println(Arrays.toString(ints2));
//        // console output
        ints2 = new int[]{60, -80, 0, 200, 44};
        //
        //      data type elem :
        for (int elem : ints2) {
            System.out.println(" elem " + elem);
        } // for each itteration of cicle from 0 to last element in order. this cicle does not  call array, ir simply copies its elements to his variable.
        for (int i = 0; i < ints2.length; i++) {
            System.out.println("ints[i] = " + ints2[i]);

        }

        //arrays сравнение
        //
        ints1 = new int[]{60, -80, 0, 200, 44, 234, 42, 2356, 321, 75};
        ints2 = new int[]{60, -80, 0, 200, 44};
        System.out.println(Arrays.equals(ints1, ints2));
        // compare, compareUnsigned, mismutch
        // arrays sort.
        Arrays.sort(ints1);
        Arrays.sort(ints1, 0, 2);
        Arrays.parallelSort(ints1); // sorting via parallel streams usable only for large scales 1_000_000 ++

        ints2 = new int[]{0, 2, 3, 200, 444};
        // surch inside sorted array.
        System.out.println(Arrays.binarySearch(ints2, 2)); // returns position nomber if there is no such elenent it returns negotive value + 1 of possible position
        System.out.println(Arrays.binarySearch(ints2, 200));

        // arraycopy

        int[] newUnts = ints1; // adintional linc to ints1[] nit a coppy
        int[] copy = ints1.clone(); // creat a full copy of base array.
        int[] moreFlexible = new int[15];
        System.arraycopy(ints1, 2, moreFlexible, 0, 5);// what array to make source, from which element, to what array, to which position, how many.
        int[] copyInts = Arrays.copyOf(ints1, 3); //creates new arrau from first 3 elements of source array.

        int[][] ints3 = new int[3][4]; // elements of array ints3 are 3 arrays of length 4;
        //[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
        System.out.println(Arrays.deepToString(ints3));
        int[][] ints4 = new int[3][];
        //[null,null,null];
        ints4[0] = new int[1];
        ints4[1] = new int[2];
        ints4[2] = new int[3];
        //[[0], [0, 0], [0, 0, 0]]
        System.out.println(Arrays.deepToString(ints4));

        int[][] ints5 = {
                {3, 6, 9},
                {2, 65, 69},
                {12, -6, 52,265}
        };
        System.out.println(ints5[1][1]); //65
        System.out.println(ints5[2][3]); //265
        for (int i = 0; i < ints5.length; i++) {
         int a=  ints5[i].length;
            for (int j = 0; j < a; j++) {
                ints5[i][j]*=ints5[i][j];
            }
        }
        System.out.println(Arrays.deepToString(ints5));

        }
}
