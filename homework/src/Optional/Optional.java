package Optional;

import java.util.Arrays;

public class Optional {
    public static void main(String[] args) {
//      Задание 1 - собрать 2 слова в одно.
        String forJoin1 = "ajmdfoidashjfdhn";
//        System.out.println(forJoin1.length());
        String forJoin2 = "UGJALDYA";
//        System.out.println(forJoin2.length());
        char[] joinedChar = new char[(forJoin1.length()+forJoin2.length())/2];
//        System.out.println(joinedChar.length);
        for (int i =0; i < forJoin1.length()/2; i++) {
            joinedChar[i] = forJoin1.charAt(i);
        }
//        System.out.println(joinedChar);
        int len = forJoin2.length()/2;
        for (int i = forJoin1.length()/2 ; i <= (joinedChar.length-1); i++) {
            joinedChar[i] = forJoin2.charAt(len);
//            System.out.println(len);
//            System.out.println(joinedChar);
            len = len + 1;
        }
//        System.out.println(joinedChar);
        String joinSrt = new String(joinedChar);
        System.out.println(joinSrt);

//        String joinedStr =;



    }

}
