package com.ifmo.jjd.lesson19;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Class of ....
 * @author АЛексей
 * @version 1.1
 */
public class IOLesson {
    /**
     * String data is... bla bla bla
     */
    private String data;

    /**
     * Constructor of... with or witout data some opertions
     * @param data what parametrs it rakes
     * @see IOLesson#IOLesson(String)  a link to another place in documetation  // hear we put link to a constructor which recives String arg.cgfcb
     */
    public IOLesson(String data) {
        this.data = data;
    }

    //IO/NIO packages
    //IO allows to input and outpet data via sequence od bytes or chars
    //


    public static void main(String[] args) {

        File file = new File("somefile.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file.exists()); // is created
        System.out.println(file.isDirectory()); // if it is directory
        System.out.println(file.isFile());  //is file bolean as ^
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        File[] files = new File("sources").listFiles();
        //Class file has a limited methods.
        //If there is going large ammout of work with filesystem the better way is to work with Io package files.

        File lessonFile = new File("sources/lesson19.txt");
        // if we a writing in to non existing file, the file will be created.Directoryu will be created.
        // The path wiil be created by default from the root of project.
        // if we are going to read from ninexistent file it will throw exeption.
        //1.if programm gives data we use childs classes of OutputStream
        //2. If programm  gets data we use childs of InputStream
        try {
            writeToFile(lessonFile, "Data to write", false);
        } catch (IOException e) {
            e.printStackTrace();
            // If we need to stop progremm working hear we throw new exeption in catch block
        }

    }
    /* Multy dtring commentary
     *
     */

    /**
     * Documentation declared (**)
     *
     * @param file   - File to write to
     * @param data   - String to write into a file
     * @param append - flag< if true - write to the end. if false - write to begining/
     * @throws IOException - file can not be found, problems with writing. // @return will explain what kind of data the method returns,  hear void.
     **/

    private static void writeToFile(File file, String data, boolean append) throws IOException { //the last is to the begining(rewriting) or not
        //try () - try-with-sources
        // new FileOutputStream(file - Where to write, append method faulse = to the ))
        // then running try block in () afte finishing block all objects created in () will run close() method.
        //For creating objects in() is nescessary implimentation of AutoCloseble interface. and realisation of method close()
        // The alternative is using block finaly< after try cath.
        // if finaly closing havent been done we memory leack will cause

        // if hear will be thrown an exeption< first the close() will be  renned before cath bloxk
        // if the closing will be realised in finaly block, first will run catch block after< th objects will be closed.
        try (FileOutputStream outputStream = new FileOutputStream(file, append)) {
            byte[] bytes = data.getBytes();
            outputStream.write(bytes); // method write byte, byte[], ar byte arr with nomer of bytes send,
        }
        SomeIODecorator someIODecorator = new SomeIODecorator (new BufferedOutputStream(new FileOutputStream(file)));
        someIODecorator.write("dds".getBytes());
    }

    // program -> file
    // program -> buffer(collecting data untill reaching limit the sen to file) ->file.

    private static void writeWithBuffer(File file) throws IOException {
        //by default the flag in (write to end) is false.
        try (FileOutputStream outputStream2 = new FileOutputStream(file);
             // ufferedOutputStream(OutputStream out, int size) if we need special buffer size
             // by default 8192 byte.
             BufferedOutputStream buffer = new BufferedOutputStream(outputStream2)
             //BufferedOutputStream decorates the main finctions ( FileOutputStream(file))
             // IO allows to create decorators
        ) {
            for (int i = 0; i < 100_000; i++) {
                buffer.write((i + " ").getBytes());
            }
        }
    }

    /**
     *
     * @param file File from which we are reading
     * @return String which we get from methods work.
     * @throws IOException while not founding file, or unable to read from it.
     */
    private static String readFromFile(File file) throws IOException{
        String res =  null;
        try(FileInputStream inputStream=new FileInputStream(file);
//        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ) {
           byte[] bytes  = new byte[300];
           int data;
           //read returns nomber of readen bytes, or -1 if there is nothing to read
           while ((data = inputStream.read(bytes))!=-1){
               byteArray.write(bytes,0,data);
           }
           res = new String(byteArray.toByteArray());
        }
        return res;
        // the method read from inputsteram reads data to some structure i.e byte[}
    }

    //while creating our own decorators for io packages must be children of FilterOutputStream, FilterInputStream

    public static boolean byteArrayToImg(File file, byte[] bytes) throws IOException{
        try(ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes)) {
            BufferedImage image = ImageIO.read(inputStream);
            return ImageIO.write(image,"jpg",file);
        }
    }
    public static byte[] inmgToByteArray(File file) throws IOException {
        BufferedImage image =ImageIO.read(file);
        ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
        ImageIO.write(image,"jpg",outputStream);
        return outputStream.toByteArray();
    }


}
class SomeIODecorator extends FilterOutputStream{
    public SomeIODecorator(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        // шифрование xor^ //ourselves find how.
        out.write(b);
    }
}

class SomeInpurDecorator extends FilterInputStream{
    protected SomeInpurDecorator(InputStream in) {
        super(in);
    }
// file inputstream takes some data puts int to array.
    // we iterate array. and return nomber of readed bytes.
    @Override
    public int read(byte[] b) throws IOException {
        in.read(b);// returns nomber of readed bytes. for array it is a void method.
        // iter b.

        return 22 ; // nomber of readed bytes;
    }
}

// img - send between programs.
//img -> byte[] ---передача--- -> byte[]-> img.
