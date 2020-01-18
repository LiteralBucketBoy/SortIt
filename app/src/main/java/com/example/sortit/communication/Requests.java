package com.example.sortit.communication;

import java.io.IOException;

public class Requests {

    private Client client;

    public Requests() {
        client = new Client();
        try {
            client.startConnection("192.168.56.1", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTuple() {
        String tuple = "";
        try {
            tuple = client.sendMessage("accept");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tuple;
    }

    public void closeConnection() {
        try {
            client.sendMessage("close");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
