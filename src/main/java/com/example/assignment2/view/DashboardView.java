package com.example.assignment2.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DashboardView {
    private final VBox layout;

    public DashboardView(String preferredName) {
        Label welcome = new Label("Welcome, " + preferredName + "!");
        layout = new VBox(20, welcome);
        layout.setStyle("-fx-padding: 20;");
    }

    public VBox getView() {
        return layout;
    }
}
