module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
}