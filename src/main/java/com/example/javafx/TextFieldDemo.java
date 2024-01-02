package com.example.javafx;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class TextFieldDemo extends Application {
    TextField tf;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Демонстрация текстового поля");

        FlowPane rootNode = new FlowPane(10, 10);

        rootNode.setAlignment(Pos.CENTER);

        Scene myScence = new Scene(rootNode, 230, 140);

        myStage.setScene(myScence);

        response = new Label("Полуить имя: ");

        Button btnGetText = new Button("Получить имя");

        // Создать текстовое поле
        tf = new TextField();

        // Задать подсказку
        tf.setPromptText("Введите имя.");

        // Задать предпочительное количество столбцов
        tf.setPrefColumnCount(15);

        tf.setOnAction((ae) -> response.setText("Введено. Имя: " + tf.getText()));

        btnGetText.setOnAction((ae) -> response.setText("Кнопка нажата. Имя: " + tf.getText()));

        // Использовать разделитель для лутшей организации ввода
        Separator separator = new Separator();
        separator.setPrefWidth(180);

        rootNode.getChildren().addAll(tf, btnGetText, separator, response);

        myStage.show();
    }
}
