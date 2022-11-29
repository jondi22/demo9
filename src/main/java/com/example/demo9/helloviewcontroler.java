package com.example.demo9;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class helloviewcontroler {

// differance between qunseutive delays named getter
    @FXML
    private Button login;
    @FXML
    private TextField username,pass;
    @FXML
    RadioButton UTP;
    @FXML
    Label verfication;
    Stage stage;
    Scene scene;
    Parent root;

    public void logincheck() throws FileNotFoundException {

        File myObj = new File("src/main/java/com/example/demo9/database.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] x=data.split(" ");
            System.out.print(x[0]+" "+x[1]+"\n");
            if (x[0]==username.getText() && x[1]==pass.getText()) {
                verfication.setText(" ");
                break;
            } else {
                verfication.setText("Wrong username or password");
            }
        }

    }





}
