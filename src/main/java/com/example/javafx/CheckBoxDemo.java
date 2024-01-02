package com.example.javafx;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class CheckBoxDemo extends Application {

    CheckBox cbSmartphone;
    CheckBox cbTablet;
    CheckBox cbNotebook;
    CheckBox cbDesktop;
    Label response;
    Label selected;

    String computers;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Использование кнопок и событий JavaFX");

        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);

        // Центрировать компоненты но сцене
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 100);

        myStage.setScene(myScene);

        Label headind = new Label("Какие у вас есть устройства?");

        response = new Label("");

        selected = new Label("");

        cbSmartphone = new CheckBox("Смартфон");
        cbNotebook = new CheckBox("Ноутбук");
        cbDesktop = new CheckBox("ПК");
        cbTablet = new CheckBox("Планшет");

        cbSmartphone.setOnAction(actionEvent -> {
            if (cbSmartphone.isIndeterminate())
                response.setText("Состояние смартфона не определено");
            else if (cbSmartphone.isSelected())
                response.setText("Был вибран смартфон");
            else
                response.setText("Выбор смартфона отменен");
            showAll();
        });

        cbNotebook.setOnAction(actionEvent -> {
            if(cbNotebook.isSelected())
                response.setText("Был выбран ноутбук");
            else
                response.setText("Выбор ноутбука отменен");
            showAll();
        });

        cbDesktop.setOnAction(actionEvent -> {
            if(cbDesktop.isSelected())
                response.setText("Был выбран ПК");
            else
                response.setText("Выбор ПК отменен");
            showAll();
        });

        cbTablet.setOnAction(actionEvent -> {
            if(cbDesktop.isSelected())
                response.setText("Был выбран планшет");
            else
                response.setText("Выбор планшета отменен");
            showAll();
        });

        rootNode.getChildren().addAll(headind, cbDesktop, cbNotebook, cbSmartphone, cbTablet,
                response, selected);

        myStage.show();

        showAll();
    }

    void showAll() {
        computers = "";
        if(cbSmartphone.isSelected()) computers = "Смартфон ";
        if(cbTablet.isSelected()) computers += "Планшет ";
        if(cbNotebook.isSelected()) computers += "Ноутбук ";
        if(cbDesktop.isSelected()) computers += "ПК";

        selected.setText("Выбраны устройства: " + computers);
    }
}