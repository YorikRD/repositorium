package com.ifmo.jjd.lesson20.socketio;
//AutoCloseable + close()
//Alows to creat objects in try()

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable {
    // Soclket object allows client to connect server & sever will can reciev
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket; // sockeet obj common for client & server
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
     }
     public void  sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message); // tranformed to bytes
        output.flush();// forcebly pushed this bytes
     }
     public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
     }

    @Override // will be callsed automaticaly then try will finish work
    // it will be called automaticaly only in try-with-source construction
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
