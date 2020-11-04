package com.ifmo.jjd.lesson17.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            NoSuchFieldException {
        /*
        *  Rglection is a mechanism , which allows us to modify and get information concurning classes , fields and methods while
        * running programm
        * Reflection API  allows creation new instancess of thise classes, get and swt fields values
       */
        // in Java all classes are objects of  Class type.
        // so we can get a linc to it

        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        Class integerckass = int.class;
        System.out.println(integerckass);

        Class<TextMessage> textMessageClass = TextMessage.class;
        TextMessage textMessage1 = new TextMessage("Message");
        textMessage1.setText("Reflection");
        Class tmClas = textMessage1.getClass();
        Class<? extends TextMessage> tmclass2 = textMessage1.getClass();
        System.out.println(tmclass2);

      // Basic methods
        String classname = textMessageClass.getName();
        String packageName = textMessageClass.getPackageName();
        // Interfaces implimented by class
        Class[] intefaces = textMessageClass.getInterfaces(); //returns an array of links to interfaces imlimented by class. Dirrectly not by his parrnts.
        System.out.println(Arrays.toString(intefaces));

        System.out.println(textMessageClass.getSuperclass()); // Message
        System.out.println(textMessage1.getClass().getSuperclass().getSuperclass().getSuperclass()); // null parent of Object.

        // Exes to class components.
        /*1 - fields of a class - Included inherited from parrents but NOT INCLUDED private and protected
        constructors
        methods
        * */
        Field[] fields = textMessageClass.getFields();
        System.out.println(Arrays.toString(fields));
        Field[] fieldsAll = textMessageClass.getDeclaredFields(); // Not included parrent< but ignoring private and protected
        System.out.println(Arrays.toString(fieldsAll));

        // Methods:
        Method[] methodsPublicButWithParrents = textMessageClass.getMethods();
        Method[] methodsDeclared = textMessageClass.getDeclaredMethods();
        System.out.println(Arrays.toString(methodsPublicButWithParrents));
        System.out.println(Arrays.toString(methodsDeclared));

        // Constructors
        Constructor[] constructors = textMessageClass.getConstructors();
        //

        Constructor<? extends TextMessage> tmConstructor = tmclass2.getConstructor(String.class); // the fucking trick is in arg types and their order.

        // Declared an object of TM type and inicialised it is with .newInstance("Blaaaaa" - args of apropriate type);
        TextMessage reflectmessage = tmConstructor.newInstance("Blaaaaa");

        Field field = tmclass2.getDeclaredField("text");
        field.getType();
        System.out.println(field.getType().getName()); // a field data type.
        field.setAccessible(true);

        System.out.println(field.get(reflectmessage)); //returns a value of field for arg object.
        // the same but setting for arg object.
        field.set(reflectmessage,"New text field value");

        Method reflectibveMethod = reflectmessage.getClass().getDeclaredMethod("printInfo", String.class); //
        reflectibveMethod.setAccessible(true);
        reflectibveMethod.getParameterTypes(); // returns an array of arg types.
        reflectibveMethod.invoke(reflectmessage,"!!!!"); // for thise object we wish to invoke with args.
        boolean isPrivate = Modifier.isPrivate(field.getModifiers()); //


        //Class/Field/Method

    }
}
