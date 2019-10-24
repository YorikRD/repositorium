package Optional;

import HW_Cl_Meth.Kat_tusk.KatForHW;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String empyStr = new String();
        System.out.println(empyStr);
        String vasil23iy = new String("Vasil23iy");
        System.out.println(vasil23iy);
        Pattern pattern = Pattern.compile("(?=.[0-9a-zA-Z!,/])");
        Matcher vasCH = pattern.matcher(vasil23iy);
        System.out.println(vasCH.find());
        vasCH.find();
//        Matcher matcher = pattern.matcher(joinSrt);
//        System.out.println(matcher.find());
        Matcher matcher1 = pattern.matcher(empyStr);
        System.out.println(matcher1.find());
        System.out.println("Пустая строка пуста " + empyStr.isEmpty());

//        KatForHW vaska = new KatForHW();
//        vaska.setName("Vasiliy");
//        System.out.println(vaska);
        KatForHW borka = new KatForHW();
        System.out.println(borka);
        KatForHW sun_ku =new KatForHW("sun_ku");
        System.out.println(sun_ku);
        KatForHW sun_ku2 =new KatForHW("sun_ku2", 3);
        System.out.println(sun_ku2);
        KatForHW sun_ku3 =new KatForHW("sun_ku3",3, "white");
        System.out.println(sun_ku3);
        KatForHW sun_ku4 =new KatForHW("sun_ku4",12,"Black", "Hell");
        System.out.println(sun_ku4);
        KatForHW sun_ku5 =new KatForHW("",0,"Black", "Hell");////
        System.out.println(sun_ku5);




//        String joinedStr =;



    }

}
