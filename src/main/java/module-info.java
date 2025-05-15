module com.example.assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.assignment2 to javafx.fxml;
    exports com.example.assignment2;
}