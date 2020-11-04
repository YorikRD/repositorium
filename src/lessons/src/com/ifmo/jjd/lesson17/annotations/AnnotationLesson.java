package com.ifmo.jjd.lesson17.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationLesson {
    public static void main(String[] args) {
        //all annotations nwork only with primitives.
        Class<SomeCLass> someCLass = SomeCLass.class;

        Annotation[] annotations = someCLass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        //check for an annotation
        if(someCLass.isAnnotationPresent(Config.class)){
            System.out.println("Config.class");
            Config config = someCLass.getDeclaredAnnotation(Config.class);
            System.out.println(config.desc());
            System.out.println(config.version());
        }

        //if class is annotated as @Config< create an instance of thise class by reflective method.
        // if any fields are annotated with nescessary methods


        Field[] field = someCLass.getFields();
        for (Field field1 : field) {
            if (field1.isAnnotationPresent(Required.class)){
                System.out.println("Reqired.class");
                //stringdata -> setStringData
                //age -> setAge
            }
        }
    }
}
