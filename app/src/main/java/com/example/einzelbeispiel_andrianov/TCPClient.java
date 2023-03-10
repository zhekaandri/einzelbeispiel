package com.example.einzelbeispiel_andrianov;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient extends Thread {

    public String runServer(String matrikelNummer) throws IOException {
        String modifiedSentence;
        BufferedReader inFormUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

        DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outputStream.writeBytes(matrikelNummer + '\n');
        modifiedSentence = inFormServer.readLine();

        System.out.println("FROM SERVER: " + modifiedSentence);

        clientSocket.close();

        return modifiedSentence;
    }
}
