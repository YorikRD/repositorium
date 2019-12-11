package wAp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WaPMain {
    public static void main(String[] args) throws IOException {
        File file = new File("resources/wp.txt");
        System.out.println(file.exists()); // проверки для себя
        System.out.println(file.canRead());  // проверки для себя
//        System.out.println(file.length());
        List<String> strL = new ArrayList<>();
        System.out.println(strL.isEmpty());
        strL.addAll(fileToStgList(file));
        wordcounter("and",strL);
        wordcounter("love",strL);
        wordcounter("war",strL);
        wordcounter("",strL);
        printXrgouped(strL, 1,2,3,4,5,6,7,8,9,10);
        mostFrequent(strL, 100);
//        System.out.println("потоков на данной машине " +Runtime.getRuntime().availableProcessors());




//        HashMap<String, Integer> wordsNumb = new HashMap<>();
//        for (int i=0; i<strL.size();i++){
//        wordsNumb.put(strL.get(i),strL.get(i).length());
//        }
//        System.out.println(strL.get(4));
//        System.out.println(strL);
//        printN(strL, 20);







    }
    public static ArrayList<String> fileToStgList (File file) throws IOException {
        String string = null;
        String[] substr;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        ){
//            System.out.println(fileInputStream.available()); // проверяем идёт ли стрим
            byte[] buf = new byte[16]; // создаём буфер для работы со стримом
            int data;
            while ((data = fileInputStream.read(buf))>0){
                outputStream.write(buf,0,data);
            }
           string = new String(outputStream.toByteArray());
            String string2 = new String();
            Pattern pattern = Pattern.compile("\\W");
            string2 =string
                    .toLowerCase()
                    .replaceAll("/", " ")
                    .replaceAll("\\p{Punct}[\\s, \\n,\\p{Punct}]", " ")
//                    .replaceAll(" \\p{Punct}\\p{Punct}", " ")
                    .replaceAll("$", "")
//                    .replaceAll("\\n ", " ")
                    .replaceAll("(?m)^[ \t]*\r?\n", "")
                    .replaceAll("\n|\r\n", " ")

            ;
            String string3 = null;
            substr = string2.split(" ");
        }
        List<String> strings3 = Arrays.asList(substr);
        ArrayList<String> strings = new ArrayList<String>();
        strings.addAll(strings3);

        cleanWords(strings);
        for (int i =0; i<strings.size(); i++){
            if (strings.get(i).equals("")){
                strings.remove(i);
            }
            }



//        System.out.println(strings);
        return strings;
    }

    public static void printN (List<?> list, int n){ //Проверочный метод ля моих RegEx
        for ( int i =0; i< n; i++){
            System.out.println(list.get(i) + " Под номером "+ i);
        }
    }

    public static void cleanWords (ArrayList<String> strL) {
//        for (int i =0; i < strL.size(); i++){
//            if (strL.get(i).equals(" ")){
//                strL.remove(i);
//            }
//        }
        Pattern pattern = Pattern.compile("^\\W");
        String replacer = null;
        Pattern pattern2 = Pattern.compile("\\W");
        Collection<String> uncleared = new ArrayList<>();
        for (int i = 0; i < strL.size(); i++) {
            Matcher matcher = pattern.matcher(strL.get(i));
            Matcher matcher1 = pattern2.matcher(strL.get(i));
            if (matcher.find()){
                replacer = new String(strL.get(i).replaceAll("\\W",""));
//                System.out.println(" Неизменённое " + strL.get(i) +" изменённое "+replacer);
                strL.remove(i);
                strL.add(i, replacer);
            }
            if (matcher1.find()){
                uncleared.add(strL.get(i));
            }
        }
//        System.out.println(uncleared);
    }

    public static Map<String, Integer> getWordsCount(List<String> words) {
        Map <String, Integer> wordmap = new HashMap<>();
        for (String word: words){
            if ( wordmap.containsKey(word)) {wordmap.put(word, wordmap.get(word)+1);
            } else{wordmap.put(word,1);
            }
        } return wordmap;
    }

    public static void wordcounter (String string, List<String> list) {
        System.out.println("Слово/словосочетание " + string +" Встречается в данном тексте " + getWordsCount(list).get(string) + " раз.");
    }

    public static LinkedHashMap<Integer, Set> woldsgr (List<String> words) { // Группировка в мап по длинне.
        LinkedHashMap <Integer, Set> wordcount = new LinkedHashMap<>();
        Set<String> set = new HashSet<>();
        set.addAll(words);
        for (String word: set){
            if (!wordcount.containsKey(word.length())){
                Set<String> set2 = new HashSet<>();
                set2.add(word);
                wordcount.put(word.length(),set2);
            } else {
                Set<String> set3 = wordcount.get(word.length());
                set3.add(word);
                wordcount.put(word.length(),set3);
            }

        }
        return wordcount;
    }
    public static void printXrgouped(List<String> list,int ...ix){ // и снова проверочный для группировки по длинне
        for (int i =0; i<ix.length; i++){
            System.out.println("В данном листе содержатся следующие слова длинны "+ix[i]+" : "+woldsgr(list).get(ix[i]));
        }

    }

    public static void mostFrequent (List<String> list, int nomb){
        Map <String, Integer> wordmap = new HashMap<>();
        wordmap = getWordsCount(list);
        TreeMap <Integer,ArrayList> nombmap = new TreeMap<>();
        Iterator<Map.Entry<String, Integer>> iterator = wordmap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry =iterator.next();
            if(nombmap.containsKey(entry.getValue())){
                if (!entry.getKey().isEmpty()){
                    String addinng = entry.getKey();
                    ArrayList<String> renewed = nombmap.get(entry.getValue());
                    renewed.add(addinng);
                    nombmap.put(entry.getValue(), renewed);}
            } else {
                ArrayList<String> newCre = new ArrayList<String>();
                newCre.add(entry.getKey());
                nombmap.put(entry.getValue(),newCre);
            }
        }
        Integer cicl =  nombmap.lastKey();
        for (int i = 0; i<nomb; i++) {
            System.out.println(" Слово/словосочениание " +" на "+(i+1) +" Месте "+nombmap.get(cicl) +" Встречается " + cicl + " Раз" );
            Integer cicl2 =  nombmap.lowerKey(cicl);
            cicl = cicl2;
        }


    }


    }

//    public static Array fileToLetters (File file) throws IOException {
//        String string = null;
//        String[] substr;
//        try (FileInputStream fileInputStream = new FileInputStream(file);
//             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
//        ) {
////            System.out.println(fileInputStream.available()); // проверяем идёт ли стрим
//            byte[] buf = new byte[16]; // создаём буфер для работы со стримом
//            int data;
//            while ((data = fileInputStream.read(buf)) > 0) {
//                outputStream.write(buf, 0, data);
//            }
//            string = new String(outputStream.toByteArray());
//            String string2 = string
//                    .toLowerCase()
//                    .replaceAll("[a-z]","");
//            Array[] arr = new Array[]{string2.toCharArray()};
//
//        }
//
//    }



//}
