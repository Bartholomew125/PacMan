package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class PacManGame extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Hello, world!");

        Scene scene = new Scene(label,500,800);

        PacMan pacman = new PacMan();

        // Controller handeling the key presses
        Controller controller = new Controller(pacman);
        scene.setOnKeyPressed(event -> controller.handleKeyPress(event));


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}