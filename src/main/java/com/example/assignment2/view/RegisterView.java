package com.example.assignment2.view;
import com.example.assignment2.App;
import com.example.assignment2.controller.AuthController;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
public class RegisterView {
    private final GridPane grid;

    public RegisterView(App app) {
        AuthController controller = new AuthController();

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();

        Label nameLabel = new Label("Preferred Name:");
        TextField nameField = new TextField();

        Button registerButton = new Button("Register");
        Button backButton = new Button("Back to Login");
        Label messageLabel = new Label();

        registerButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();
            String preferredName = nameField.getText();

            if (controller.register(username, password, preferredName)) {
                messageLabel.setText("Registration successful!");
            } else {
                messageLabel.setText("Username already exists or error occurred.");
            }
        });

        backButton.setOnAction(e -> app.showLogin());

        grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(nameLabel, 0, 2);
        grid.add(nameField, 1, 2);
        grid.add(registerButton, 1, 3);
        grid.add(backButton, 1, 4);
        grid.add(messageLabel, 1, 5);
    }
    public GridPane getView() {
        return grid;
    }
}

