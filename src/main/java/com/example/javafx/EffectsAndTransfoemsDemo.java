package com.example.javafx;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;


public class EffectsAndTransfoemsDemo extends Application {
    double angle = 0.0;
    double scaleFactor = 0.4;
    double blurVal = 0.1;

    Reflection reflection = new Reflection();
    BoxBlur blur = new BoxBlur(1.0, 1.0, 1);
    Rotate rotate = new Rotate();
    Scale scale = new Scale(scaleFactor, scaleFactor);

    Button btnRotate = new Button("Повернуть");
    Button btnBlur = new Button("Размыть");
    Button btnScale = new Button("Масштабирувать");

    Label reflect = new Label("Отражение добавляет визуальный блеск");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Демонстрация ффектов и переобразований");

        FlowPane rootNode = new FlowPane(20,20);

        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 120);

        myStage.setScene(myScene);

        // Добавить в список переобразований для кнопки "Поверуть"
        btnRotate.getTransforms().add(rotate);

        // Добавить в список переобразований для кнопки "Масштабирувать"
        btnScale.getTransforms().add(scale);

        // Задать эффект отражения для метки
        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        reflect.setEffect(reflection);

        BoxBlur rotateBlur = new BoxBlur(5.0, 5.0, 2);

        btnRotate.setEffect(rotateBlur);

        // Обработать события действия для кнопки "Повернуть"
        btnRotate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // При каждом нажатии кнопки она поворачивается на 15 градусов вокруг центра
                angle +=15.0;

                rotate.setAngle(angle);
                rotate.setPivotX(btnRotate.getWidth()/2);
                rotate.setPivotY(btnRotate.getHeight()/2);
            }
        });

        // Обработать события действий для кнопки "Масштабирувать"
        btnScale.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scaleFactor += 0.1;
                if (scaleFactor > 0.2) scaleFactor = 0.4;

                scale.setX(scaleFactor);
                scale.setY(scaleFactor);
            }
        });

        // Обработать события действий для кнопки "Размыть"
        btnBlur.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // При каждом нажатии кнопки изменяется степень размытия ее изображения
                if(blurVal == 10.0) {
                    blurVal = 1.0;
                    btnBlur.setEffect(null);
                    btnBlur.setText("Отменить размытие");
                } else {
                    blurVal++;
                    btnBlur.setEffect(blur);
                    btnBlur.setText("Добавить размытие");
                }
                blur.setWidth(blurVal);
                blur.setHeight(blurVal);
            }
        });

        rootNode.getChildren().addAll(btnBlur, btnRotate, btnScale, reflect);

        myStage.show();
    }
}
