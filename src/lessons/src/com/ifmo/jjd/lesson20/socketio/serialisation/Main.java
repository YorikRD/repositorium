package com.ifmo.jjd.lesson20.socketio.serialisation;

import java.io.*;

public class Main  {
    public static void main(String[] args) {

        Pupil pupil1 = new Pupil();
        pupil1.setAge(7);
        pupil1.setName("pupil1");
        pupil1.setGroup(new Group("Химия", 12));
        pupil1.learn();

        Pupil pupil2 = new Pupil();
        pupil2.setAge(8);
        pupil2.setName("pupil2");
        pupil2.setGroup(new Group("Биология", 22));
        pupil2.learn();

        Director director = new Director("Super Speech");
        director.setAge(44);
        director.setName("director");
        director.setRating(2);

        System.out.println(pupil1);
        System.out.println(pupil2);
        System.out.println(director);

        File file = new File("school.bin");
        objecttoFile(file,pupil2);
        Pupil pupilFromFile = (Pupil)objectFromFile(file);
        System.out.println(pupilFromFile);

        Pupil pupilFromFile2= (Pupil)objectFromFile(file);
        System.out.println(pupilFromFile);


        // To sirialize or desitailise an object it meust impliment a java.io.Serializable (marker type interface) interface( var 1)
        // the second var is  java.io.Externalizable
        // The difference:
        // implimimintation of Serializable allows to exclude some fields (default all included) but we can add
        // a (transient)  modifier to them> making them excluded, after desirialisation this fields valued will be default.
        // If Serialisation implimented in child class, all fields declared in parrent class would not be serialised
        // and after serialisation the will be in default values
        // if a parrent is serialisable, all his children will be also serialisable
        // if in serialisable class is an class without serialisation or Extrnalisable, will cause an exeprtion od serialisation
        // in preocess of S a version of class is saved. if deserialisation founds a difference between versions - will throw Runtime exaption
        // The data is saved:
        // class self
        // parrent(a graff of objects) all links (all linked must be S or E)
        // fields
        //version of a class


        // implimimintation of Externalizable doesnot include any fields< but we cam mark some fields as serialisable
        // All classed in java impliments java.io.Serializable

        // if Interfaces has no methods -> i.e. its empty, it is called marker type interface.
        //To avoid exeptions in serialisation/deserialisation we shoud use generic


    }

    private static void objecttoFile(File file, Object object){
        try(FileOutputStream fileOutput = new FileOutputStream(file, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput)
        ) {
            objectOutputStream.writeObject(object);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException io) {
            System.out.println("IOExeption");
        }
    }

    private  static Object objectFromFile(File file){
        Object o = null;
        try(FileInputStream inputStr = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStr)
        )
        {
            o = objectInputStream.readObject();
        } catch (FileNotFoundException ignored){

        } catch (IOException io){
            io.printStackTrace();
        } catch (ClassNotFoundException cl){
            cl.printStackTrace();
        }

        return o;
    }

}
