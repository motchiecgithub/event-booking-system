package com.example.assignment2;
import com.example.assignment2.model.UserDAO;
import com.example.assignment2.view.LoginView;
import com.example.assignment2.view.RegisterView;
import com.example.assignment2.view.DashboardView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class App extends Application{
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        // Initialize the database
        UserDAO.initDB();

        // Show the login page by default
        showLogin();
    }

    public void showLogin() {
        LoginView loginView = new LoginView(this);
        Scene scene = new Scene(loginView.getView(), 350, 250);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showRegister() {
        RegisterView registerView = new RegisterView(this);
        Scene scene = new Scene(registerView.getView(), 400, 300);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setTitle("Register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showDashboard(String preferredName) {
        DashboardView dashboardView = new DashboardView(preferredName);
        Scene scene = new Scene(dashboardView.getView(), 400, 200);
        primaryStage.setTitle("Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
