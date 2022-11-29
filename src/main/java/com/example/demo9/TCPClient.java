package com.example.demo9;

import java.io.*;
import java.net.*;

class TCPClient {
    public static void main(String argv[]) throws Exception {
        String CarID;
        String CarInfo;
        int x = 0;
        while (true) {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            if (x != 0) {

                System.out.print("would you like to make another request? Entar Yes or No\n");
                String s = inFromUser.readLine();
                if (s.compareTo("Yes") == 0) ;
                else break;
            }
            if (x == 0) x = 1;

            System.out.print("what is the car_id of the car  you want to see:");
            Socket clientSocket = new Socket("127.0.0.1", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            CarID = inFromUser.readLine();

            outToServer.writeBytes(CarID + '\n');
            CarInfo = inFromServer.readLine();
            System.out.println("FROM SERVER: " + CarInfo);
            clientSocket.close();
        }
    }
}