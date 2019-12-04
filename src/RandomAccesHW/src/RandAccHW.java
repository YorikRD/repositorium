import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class RandAccHW {
    public static void main(String[] args) {
        fileCrRand("Basic22");
        File file =new File("src/Basic22.txt");





    }

    public static void fileCrRand(String randname) {
        File baseFile = new File(randname + ".txt");
        try {
            baseFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fileOutput = new FileOutputStream(baseFile, true)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 21; i++) {
                ArrayList randnInp = new ArrayList();
                int len = (int) (Math.random() * 326) + 2;
                for (int id = 0; id < len; id++) {
                    Random r = new Random();
                    char c = (char) (r.nextInt(26) + 'a');
                    randnInp.add(c);
                }
                char[] mid = new char[randnInp.size()];
                for (int sun =0; sun < mid.length; sun++){
                    mid[sun] =(char)(randnInp.get(sun));
                }
                String str2 = String.copyValueOf(mid,0,randnInp.size());
                sb.append("Line ").append(i).append("\t").append(str2).append("\n");
            }
            byte[] bytes = sb.toString().getBytes();
            fileOutput.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void fileSplitter (File baseFile) throws IOException {
        File cutFile1 = new File(baseFile.getName()+"Spl1" + ".txt");
        File cutFile2 = new File(baseFile.getName()+"Spl2" + ".txt");
        try (FileInputStream inputStream = new FileInputStream(baseFile),
             FileOutputStream outpStream1 = new FileOutputStream(cutFile1),
        FileOutputStream outpStream2 = new FileOutputStream(cutFile2)
        ) {

        }


    }
}
