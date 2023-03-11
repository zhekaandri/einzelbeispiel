package com.example.einzelbeispiel_andrianov;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient extends Thread {

    public String run(String matrikelNummer) throws IOException {
        String modifiedSentence;

        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

        DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        outputStream.writeBytes(matrikelNummer + '\n');

        modifiedSentence = inFormServer.readLine();

        clientSocket.close();

        return modifiedSentence;
    }

    public String calculateQuerSum(String matrikelNummer){
        try {
            int sum = 0;
            char indexNum;

            for (int i = 0; i < matrikelNummer.length(); i++){
                indexNum = matrikelNummer.charAt(i);

                if (i % 2 == 0){
                    sum = sum + Integer.parseInt(String.valueOf(indexNum));
                } else {
                    sum = sum - Integer.parseInt(String.valueOf(indexNum));
                }
            }

            if (sum % 2 == 0){
                return "Alternierende Quersumme " + sum + " ist gerade.";
            } else {
                return "Alternierende Quersumme " + sum + " ist ungerade.";
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
