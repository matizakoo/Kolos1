package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendText {
    private Socket socket;

    private String host;

    private int port;

    public SendText(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect(){
        try {
            InetAddress address = InetAddress.getByName(host);
            this.socket = new Socket(address, port);
            if (socket.isConnected()){
                System.out.println("Nawiązano połączenie ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String text){
        connect();
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect(){
        if (socket.isConnected()){
            try {
                socket.close();
                System.out.println("Zakończenie połączenia ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}