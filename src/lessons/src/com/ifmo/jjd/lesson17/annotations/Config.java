package com.ifmo.jjd.lesson17.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // we anotate classes
@Retention(RetentionPolicy.RUNTIME) // it must be kept untill the end of run.
public @interface Config {
    //paremeters Primitive(not wrappers), string, enum
    String desc();// without default value we must mark it then declaring for a file. Hear we must
    int version() default 1; // without default value we must mark it then declaring for a file.
}

