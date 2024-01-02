package com.example.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage) {
        myStage.setTitle("Демонстрация списка");

        FlowPane rootNode = new FlowPane(10, 10);

        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 200, 120);

        myStage.setScene(myScene);

        response = new Label("Выбор типа устройства");

        // Создать объект типа ObservableList для списка
        ObservableList<String> computerTypes =
                FXCollections.observableArrayList("Смартфон", "Ноутбук",
                                                    "ПК", "Планшет");
        // Создать список
        ListView<String> lvComputers = new ListView<String>(computerTypes);

        lvComputers.setPrefSize(100, 70);

        // Получить модель выбора списка
        MultipleSelectionModel<String> lvSelModel = lvComputers.getSelectionModel();

        // Использовать слушатель для реагирования на изменения віделения внутри списка
        lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> changet, String oldVal, String newVal) {
                // Отобразить выбор
                response.setText("Выбрано устройство " + newVal);
            }
        });

        rootNode.getChildren().addAll(lvComputers, response);

        myStage.show();
   }
}
