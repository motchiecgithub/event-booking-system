package com.example.assignment2.view;

import com.example.assignment2.App;
import com.example.assignment2.controller.AuthController;
import com.example.assignment2.model.User;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class LoginView {
    private final GridPane grid;

    public LoginView(App app) {
        AuthController controller = new AuthController();

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Go to Register");
        Label messageLabel = new Label();

        loginBtn.setOnAction(e -> {
            User user = controller.login(userField.getText(), passField.getText());
            if (user != null) {
                app.showDashboard(user.getPreferredName());
            } else {
                messageLabel.setText("Login failed");
            }
        });

        registerBtn.setOnAction(e -> app.showRegister());

        grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginBtn, 1, 2);
        grid.add(registerBtn, 1, 3);
        grid.add(messageLabel, 1, 4);
    }
    public GridPane getView() {
        return grid;
    }
}

