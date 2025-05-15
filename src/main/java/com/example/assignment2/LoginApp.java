package com.example.assignment2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.control.Label;



public class LoginApp extends Application{
    public void start(Stage stage){

        DatabaseHelper.initializeDatabase();

        Label userLabel = new Label("Username: ");
        TextField userField = new TextField();

        Label passwordLabel = new Label("Password: ");
        TextField passwordField = new TextField();

        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        userLabel.getStyleClass().add("label");
        passwordLabel.getStyleClass().add("label");
        userField.getStyleClass().add("text-field");
        passwordField.getStyleClass().add("password-field");
        loginButton.getStyleClass().add("button");
        messageLabel.getStyleClass().add("message-label");
        

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(messageLabel, 1, 3);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
