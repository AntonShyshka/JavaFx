package Generalizations;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class JavaFXButtonDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Использование метода Platform.exit().");

        FlowPane rootNode = new FlowPane(10, 10);

        // Центрировать компоненты но сцене
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 100);

        myStage.setScene(myScene);

        response = new Label("Нажмите кнопуку");

        Button btnRun = new Button("Выполнить");
        Button btnExit = new Button("Выход");

        // Обработать события действий для днопки "Вверх"
        btnRun.setOnAction(actionEvent -> response.setText("Вы нажали Выполнить"));

       // Обработать события действий для днопки "Вниз"
        btnExit.setOnAction(actionEvent -> Platform.exit());

        // Добавить метку и кнопки в граф сцены
        rootNode.getChildren().addAll(btnRun, btnExit, response);

        myStage.show();
    }
}
