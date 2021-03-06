package com.ifmo.jjd.lesson20.socketio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private static final long serialVersionUID = 1L;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }
    public void start() throws Exception {
        String name = scanner.nextLine();
        String message;

        while (true){
            System.out.println(" input message");
            message = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }
    }

    private void sendAndPrintMessage( SimpleMessage message) throws Exception {
        try(Connection connection = new Connection(new Socket(ip,port))){ //gear is autoclosble only becausw without multitherad on server connection must be closed after sending
           connection.sendMessage(message);

           SimpleMessage fromServer= connection.readMessage();
            System.out.println("From Server: "+fromServer);
        }
    }

    public static void main(String[] args) {
        try {
            new Client("192.168.88.242",8090).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
