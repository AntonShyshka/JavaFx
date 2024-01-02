package com.example.javafx;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;

public class HelloJavaFX extends Application {
    public static void main(String[] args) {
        System.out.println("Запуск приложения JavaFX");

        // Запустить приложение JavaFX, вызвав метод launch()
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("В теле метода init()");
    }

    @Override
    public void start(Stage myStage) {
        System.out.println("В теле метода start()");

        // Задать заголовок окна приложения
        myStage.setTitle("Каркас приложения JavaFX");

        // Создать корневой узел. В данном случае используется
        // плаващуя компоновка, но возможні и другие варианты
        FlowPane rooNode = new FlowPane();

        // Создать сцену
        Scene myScene = new Scene(rooNode, 300, 300);

        // Установить сцено на платформе
        myStage.setScene(myScene);

        // Отобразить платформу с ее сценой
        myStage.show();
    }

    @Override
    public void stop() {
        System.out.println("В теле метода stop()");
    }
}
