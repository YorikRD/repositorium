package lesson5;

import java.util.Arrays;
import java.util.Objects;

public class StringLesson {
    //char - 16 bite simbol uninicode
    // from 0 to 65536 from "'\u0000' to '\uffff'
    public static void main(String[] args) {
        char char1 = 'J'; // symbol itself 'J'
        char char2 = 74; // symbol nomber 'J'
        char char3 = '\u0044'; // symbol nomber in 16' system 'D'
        System.out.println(char1); //J
        System.out.println(char2); //J
        System.out.println(char3); //D
        System.out.print(char1 + char2 + char3); // 216 as int value

        System.out.println("\nString");
        //string is symbols structure Class String!
        //Strings are created:
        // " fkgsdviv "
        // or :
        // new String() .... - but its only in sittuations where its unavoidable.
        // Strings cant be changed bur its possible to create new with base of previous.
        // All string literals , such as System.out.println("String") - an exepmlar of String class is created but we may have no access to it.

        char[] jjfds = {'\u0000', '\u004A', '\u0044',};
        String wsdgsd = new String(jjfds);
        wsdgsd = "\u0000\u004A\u0044";
        System.out.println(wsdgsd.length());

        char[] frogChars ={'\uD83D','\uDC38'};
        String frogString =new String(frogChars);
        frogString ="\uD83D\uDC38";
        System.out.println(frogString); // 🐸 2 bytes create one symbol. one symbol of length 2 string.
        System.out.println(frogString.length()); // 2 length
        System.out.println(frogString.codePoints().count()); // 1 codepoint.

        //any symbol unicode may be writen via one or pair (surrogate paire) chars.
        // String storage untill java 9 char[] with code UTF-16,
        // any char was written in two bytwes.
        //tsrting in java 9 by default : byte[] + code UTF-16 orr LATIN1 // compact strings.
        // now all Srings are kept as []byte. + coder. If UTF = 2 bytes for symbol 1bytes for LATIN1.

        System.out.println("String pool");
        // nowadays is sotred if heap memory
        // it stories an ecsemplar of each string.
        String string1 ="String";
        String string2 ="String"; // for both strings only one memory space is used!!
        System.out.println(string1.hashCode()==string2.hashCode()); // true
        String string3 = new String("String"); // String object is created in heap, not in string pool.
        System.out.println(string1.hashCode()==string3.hashCode()); //faulse
        System.out.println(string1 == string2);
        System.out.println(string1 == string3);

        // method inrern() creates one coppy of exempalar String Class.
        System.out.println(" Method Intern");
        String internStr = string3.intern();  // method returns a link to existing object  in pool strings
        System.out.println(string1 == string2); //true
        System.out.println(string1 == internStr); //true
        System.out.println(string3 == internStr); //false
        System.out.println("String matching"); // method equals
        string1 ="String";
        string2 ="String";
        System.out.println(string1.equals(string2));
        System.out.println("string".equals(string1));
        System.out.println("string".equalsIgnoreCase(string1));
        //
        string1.equals("string"); // it is bad variant
        "string".equals(string1); // better
        String nullStr = null;
        System.out.println("string".equals(nullStr)); // false
//        System.out.println(nullStr.equals("string")); // java.lang.Nullpointerexeption.
        // its better to call methods in shurely existing objects
        System.out.println(nullStr == null); // we always can check for null.
        System.out.println(Objects.nonNull(nullStr));
        System.out.println(Objects.isNull(nullStr));
        System.out.println(null == null);


        String[] animals ={" cat", "dog","guss"};
        String[] animals2 = new String[animals.length*2];
        for (int i = 0; i < animals2.length; i++) {
            animals2[i]=animals[(int) (Math.random()*animals.length)];
        }
        System.out.println(Arrays.deepToString(animals2));

        System.out.println("Strings concatenation");
        string1="java";
        string1="pyton";
        System.out.println(string1+" "+string2);
        String concatStr = string1.concat(" :: ")
                .concat(string2); // fuccing cunning method to avoid +  sinthacsis but better optimised;

        // String.join(delimiter,string1,string2..)
        concatStr =String.join(" ", string1,string2);
        System.out.println("String bufferisation");
        concatStr = " ";
        for (int i = 0; i < 10; i++) {
            concatStr = " "+i;
        }
        // all methods higher are NOT ALLOWED IN CICLES to much memeoru used.
        //StringBuilder - works faster, but is not thread safe
        //StringBuffer - slow bu thread safe.

        StringBuilder stringBuilder = new StringBuilder(string1);
        stringBuilder.append(string2).append(string3);
        System.out.println(stringBuilder.toString());

       StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder2.append(" ").append(i);
        }
        System.out.println(stringBuilder2);
        // comparing strings.
        string1 = "string";
        string2 = "String";
        System.out.println(string1.compareTo(string2)+" this!");
        System.out.println(string1.compareToIgnoreCase(string2));
        // start/end.
        string1="JDK";
        System.out.println(string1.startsWith("J"));
        System.out.println(string1.startsWith("J",2)); //false
        System.out.println(string1.endsWith("K"));

        // reg change
        string1 = string1.toUpperCase();
        System.out.println(string1);
        string1 = string1.toLowerCase();
        System.out.println(string1);
        // замена
        string1 = "jfkfjjkf";
        string1 = string1.replace("j","1");
        System.out.println(string1);
        string1 = "jfkfjjkf";
        System.out.println(string1);
        string1=string1.replaceAll("j","!");
        System.out.println(string1);
        string1=string1.replaceFirst("!","J");
        System.out.println(string1);
        System.out.println(string1.contains("J"));

        String[] sd = string1.split("k");
        System.out.println(Arrays.toString(sd));

        // subString (from to)
        // Remove space
        //trim()/strip()/stripLeading/stripTrailing
        string1.strip();
        string1.stripLeading();
        string1.stripTrailing();
        // trim - rmoves space wit length <= \u0020;
        //strip()removes any space
        //.stripLeading removes in the begining of string
        //.stripTrailing() removes in the enf od string










    }
}
