package com.example.javafx;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class LabelDemo extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Использование метки JavaFX");

       FlowPane rootNode = new FlowPane();

        Scene myScene = new Scene(rootNode, 300, 200);

        myStage.setScene(myScene);

        Label myLabel = new Label("JavaFX - это мощный GUI");

        rootNode.getChildren().add(myLabel);

        myStage.show();
    }
}
