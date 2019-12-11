package ParThreadHW;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParThreadsHW1 {
    public static void main(String[] args) throws IOException {
        File file = new File("resources/wp.txt");
        System.out.println(file.exists()); // проверки для себя
        System.out.println("Строк в файле " + mylineCounter(file));
        int linecounter =0;

        ArrayList<Integer> stringsToRead = new ArrayList<>();
        System.out.println(stringsToRead);
        stringsToRead.add(linecounter);
        stringsToRead.add(linecounter + mylineCounter(file)/4);
        System.out.println(stringsToRead);

        SyncContainer container = new SyncContainer();
        System.out.println(container.wordsCount.isEmpty());
        ArrayList<SplitThread> splitThreads = splitThrFact(file,container);

        for(SplitThread thread:splitThreads){
            thread.start();
        }for(SplitThread thread:splitThreads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(" Общий подсчёт :");
//        mostFrequent(container.wordsCount,100);



    }
    public static void mostFrequent ( Map <String, Integer> wordmap, int nomb){
        TreeMap<Integer,ArrayList> nombmap = new TreeMap<>();
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
    public static int mylineCounter(File file) throws IOException { // отдельно вынесенный метод считающий количество стро в файле
        int linesnomb =0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null) linesnomb++;
        return linesnomb;
    }
    public static ArrayList<SplitThread> splitThrFact(File file,SyncContainer cont ) throws IOException { // метод создающий массив потоков.
        ArrayList<SplitThread> threads = new ArrayList<>();
        int thrInSyst= Runtime.getRuntime().availableProcessors();
        int linecounter =0;
        for (int i = 0; i<thrInSyst; i++){
            ArrayList<Integer> stringsToRead = new ArrayList<>();
            stringsToRead.add(linecounter);
            stringsToRead.add(linecounter + mylineCounter(file)/4);
            linecounter = linecounter + (mylineCounter(file)/4+1);
            threads.add(new SplitThread(cont, stringsToRead, file));
        } return threads;
    }

}

class SyncContainer { // Класс являющийся синхронизирующим элементом
    private int thrInSyst= Runtime.getRuntime().availableProcessors();
    public HashMap<String, Integer> wordsCount = new HashMap<>();

    public int getThrInSyst() {
        return thrInSyst;
    }

    public HashMap<String, Integer> getWordsCount() {
        return wordsCount;
    }

    public synchronized void  fill (Map<String, Integer> words) throws InterruptedException { // синхронизирующий методо который собирает из потоковых мап нормальную.
        for (Map.Entry<String, Integer> entry :words.entrySet()) {
            if (wordsCount.containsKey(entry.getKey())) {
                wordsCount.put(entry.getKey(), (wordsCount.get(entry.getKey()) + entry.getValue()));
            } else {
                wordsCount.put(entry.getKey(), entry.getValue());
            }
        }
    }
}

class SplitThread extends Thread { // Огромный и переусложнённый метод потока но я ещё не догнал как его упростить
    private SyncContainer container;
    private ArrayList<Integer> stringsToRead;
    private File file;

    public SplitThread(SyncContainer container, ArrayList<Integer> stringsToRead, File file) {
        this.container = container;
        this.stringsToRead = stringsToRead;
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println("Поток"+Thread.currentThread().getName() +" начинает свою работу он работает со строками c " + stringsToRead.get(0) +" -ой по " +stringsToRead.get(1));
        List<String> lines = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        Path path = file.toPath();
       try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
           if (stringsToRead.get(1)<=(ParThreadsHW1.mylineCounter(file)/container.getThrInSyst()*(container.getThrInSyst()-1))) // Проверка не последний ли кусок файла читаем
           {
               lines = lineStream
                       .skip(stringsToRead.get(0)) // Косяк тут, работает некорректно
                       .limit(stringsToRead.get(1)) // Косяк тут, работает некорректно
                       .collect(Collectors.toList());
           } else { // у последнего читаем строки до конца чтобы не потерять остаток строк не кратно делящийся на процессор. В случае моей машины 3 строки в конце.
               lines = lineStream
                       .skip(stringsToRead.get(0))
                       .collect(Collectors.toList());
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" has lenth of list string " + lines.size());
       for(String line:lines){
           String lineClear = new String();
           lineClear = line.toLowerCase()
                   .replaceAll("/", " ")
                   .replaceAll("\\p{Punct}[\\s, \\n,\\p{Punct}]", " ")
                   .replaceAll("$", "")
                   .replaceAll("(?m)^[ \t]*\r?\n", "")
                   .replaceAll("\n|\r\n", " ")
                   .trim();
           String[] substr = lineClear.split(" ");
           for (String string:substr){
               if (!string.equals("")&&!string.isEmpty()) {
                   if (wordsMap.containsKey(string)) {
                       wordsMap.put(string, wordsMap.get(string) + 1);
                   } else {
                       wordsMap.put(string, 1);
                   }
               }
           }
       }
//        System.out.println( Thread.currentThread().getName());
//       ParThreadsHW1.mostFrequent(wordsMap, 5);
//        System.out.println(wordsMap);
        try {
            container.fill(wordsMap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
