package com.example.assignment2.view;

import com.example.assignment2.model.Event;
import com.example.assignment2.model.EventDAO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.List;
import java.util.function.Function;

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
                createCol("Title", Event::getTitle),
                createCol("Venue", Event::getVenue),
                createCol("Day", Event::getDay),
                createCol("Price", Event::getPrice),
                createCol("Sold", Event::getSold),
                createCol("Total", Event::getTotal),
                createCol("Remaining", Event::getRemaining)
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

    private static <S, T> TableColumn<S, T> createCol(String title, Function<S, T> mapper) {
        TableColumn<S, T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(mapper.apply(cellData.getValue())));
        return col;
    }

    public GridPane getView() {
        return layout;
    }
}
