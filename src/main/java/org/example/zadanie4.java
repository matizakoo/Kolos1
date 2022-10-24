package org.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class zadanie4 {
    private Socket socket;

    private String host;

    private int port;

    public zadanie4(String host, int port) {
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