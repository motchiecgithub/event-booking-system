package com.example.assignment2.view;

import com.example.assignment2.model.Event;
import com.example.assignment2.model.EventDAO;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.List;

public class DashboardView {
    private final GridPane layout;

    public DashboardView(String preferredName) {
        // Welcome label
        Label welcomeLabel = new Label("Welcome, " + preferredName + "!");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Event table
        TableView<Event> eventTable = new TableView<>();
        List<Event> events = EventDAO.loadEvents("events.dat");

        eventTable.setItems(FXCollections.observableArrayList(events));
        eventTable.getColumns().addAll(
                createCol("Title", "title"),
                createCol("Venue", "venue"),
                createCol("Day", "day"),
                createCol("Price", "price"),
                createCol("Sold", "sold"),
                createCol("Total", "total"),
                createCol("Remaining", "remaining")
        );

        // Layout with GridPane
        layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setHgap(10);
        layout.setVgap(15);

        // Add welcome label at (row 0, column 0)
        layout.add(welcomeLabel, 0, 0);

        // Add event table at (row 1, column 0)
        layout.add(eventTable, 0, 1);
    }

    private <T> TableColumn<Event, T> createCol(String title, String property) {
        TableColumn<Event, T> col = new TableColumn<>(title);
        col.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>(property));
        col.setMinWidth(100);
        return col;
    }

    public GridPane getView() {
        return layout;
    }
}
