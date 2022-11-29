package com.example.demo9;

import java.io.*;
import java.net.*;

class UDPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
        int x = 0;
        while (true) {
            if (x != 0) {
                System.out.print("would you like to make another request? Entar Yes or No\n");
                String s = inFromUser.readLine();
                if (s.compareTo("Yes") == 0) ;
                else break;
            }
            if (x == 0) x = 1;
            System.out.print("what is the car_id of the car  you want to see:");
            String sentence = inFromUser.readLine();
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
            System.out.println("FROM SERVER:" + modifiedSentence);
        }
        clientSocket.close();
    }
}