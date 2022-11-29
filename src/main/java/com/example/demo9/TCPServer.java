package com.example.demo9;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPServer {
    public static void main(String argv[]) throws Exception {
        String carID;
        String carInfo;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            carID = inFromClient.readLine();
            System.out.print(carID + "\n");

            File myObj = new File("src/main/java/com/example/demo9/database.txt");
            Scanner myReader = new Scanner(myObj);
            String found = "Vehicle is not found";

            while (myReader.hasNextLine()) {
                String data = myReader.next();
                if (data.compareTo(carID) == 0) {
                    found = myReader.next() + ", " + myReader.next() + ", " + myReader.next() + ", " + myReader.next();
                    break;
                } else {
                    myReader.next();
                    myReader.next();
                    myReader.next();
                    myReader.next();
                }
            }
            carInfo = found + '\n';
            outToClient.writeBytes(carInfo);
        }
    }
}