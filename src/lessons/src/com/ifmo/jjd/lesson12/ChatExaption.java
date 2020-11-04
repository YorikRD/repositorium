package com.ifmo.jjd.lesson12;
//if it is nescessary to create our own RuntimeExeption child.(time of programm run)

// if it is nescessary to create our own Compilation time Exeption child


public class ChatExaption extends Exception {

    public ChatExaption(String message) {
        super(message);
    }

    public ChatExaption(String message, Throwable cause) {
        super(message, cause);
    }
    //we can oveeride parent methods hear.

    @Override
    public String getMessage() {
        return super.getMessage() + "  Be Accurate";
    }
}
