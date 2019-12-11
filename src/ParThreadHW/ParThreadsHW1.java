package ParThreadHW;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParThreadsHW1 {
    public static void main(String[] args) throws IOException {
        File file = new File("resources/wp.txt");
        System.out.println(file.exists()); // проверки для себя
        System.out.println("Строк в файле " + mylineCounter(file));

        int thrInSyst= Runtime.getRuntime().availableProcessors();
        int linecounter =0;

        ArrayList<Integer> stringsToRead = new ArrayList<>();
        System.out.println(stringsToRead);
        stringsToRead.add(linecounter);
        stringsToRead.add(linecounter + mylineCounter(file)/4);
        System.out.println(stringsToRead);

        try (Stream<String> lines = Files.lines(file.toPath())) {
            lines.skip(stringsToRead.get(0)).limit(stringsToRead.get(1));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static int mylineCounter(File file) throws IOException {
        int linesnomb =0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null) linesnomb++;
        return linesnomb;
    }
    public static ArrayList<SplitThread> splitThrFact(File file,SyncContainer cont ) throws IOException {
        ArrayList<SplitThread> threads = new ArrayList<>();
        int thrInSyst= Runtime.getRuntime().availableProcessors();
        int linecounter =0;
        for (int i = 0; i<thrInSyst; i++){
            ArrayList<Integer> stringsToRead = new ArrayList<>();
            stringsToRead.add(linecounter);
            stringsToRead.add(linecounter + mylineCounter(file)/4);
            linecounter = linecounter + (mylineCounter(file)/4);
            threads.add(new SplitThread(cont, stringsToRead, file));
        } return threads;
    }

}

class SyncContainer {
    private int thrInSyst= Runtime.getRuntime().availableProcessors();
    public HashMap<String, Integer> wordsCount;

    public synchronized void  fill (List<String> words) {
        for (String word: words){
            if ( wordsCount.containsKey(word)) {wordsCount.put(word, wordsCount.get(word)+1);
            } else{wordsCount.put(word,1);
            }
        }
    }
}

class SplitThread extends Thread {
    private SyncContainer container;
    private ArrayList<Integer> stringsToRead;
    private File file;


    public SplitThread(SyncContainer container, ArrayList<Integer> stringsToRead, File file) {
        this.container = container;
        this.stringsToRead = stringsToRead;
    }

    @Override
    public void run() {
        List<String> lines = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        Path path = file.toPath();
       try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
           lines = lineStream
                   .skip(stringsToRead.get(0))
                   .limit(stringsToRead.get(1))
                   .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
       for(String line:lines){

       }
    }
}
