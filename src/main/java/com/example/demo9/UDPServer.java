package com.example.demo9;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String CarID = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String CarInfo;
            File myObj = new File("src/main/java/com/example/demo9/database.txt");
            Scanner myReader = new Scanner(myObj);
            String found = "Vehicle is not found";

            while (myReader.hasNextLine()) {
                String data = myReader.next();
                if (data.compareTo(CarID) == 0) {
                    found = myReader.next() + ", " + myReader.next() + ", " + myReader.next() + ", " + myReader.next();
                    break;
                } else {
                    myReader.next();
                    myReader.next();
                    myReader.next();
                    myReader.next();
                }
            }
            CarInfo = found + '\n';
            System.out.print(CarID + "\n");
            sendData = CarInfo.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress,
                            port);
            serverSocket.send(sendPacket);
        }
    }
}