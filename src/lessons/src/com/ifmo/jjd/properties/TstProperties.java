package com.ifmo.jjd.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TstProperties {
    public static void main(String[] args) {
        //based on a hashtable
        //Rmb on project name create new directory.
        //Mark directory as resourcess root
        // data in perperie files is stored in paurs key- valet/
        // key is string , value is string
        Properties properties = new Properties();
        properties.setProperty("somekey", "somevalue");
        System.out.println(properties.get("somekey"));
        System.out.println(properties.getOrDefault("somekey2","default"));

        // try() is for automatical opening-and-closing-after-use of class
        try(InputStream input = TstProperties.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("status"));
        System.out.println(properties);
        //Everything hear is a String. to work with thise data we must parse it in value string.

    }



}
