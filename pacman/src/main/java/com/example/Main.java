package com.example;

import com.example.controller.MainController;
import com.example.model.Game;
import com.example.view.Viewer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main JavaFX App, with the game loop
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // The root from which all other screen objects will attach
        Group root = new Group();

        // Create the Game, Viewer and Controller
      
        MainController controller = new MainController(800,800);

        // Attach the viewers surface to the root, so it is displayed
        root.getChildren().add(controller.getView().getSurface());

        // Create the scene with the root, and the size of the viewers surface.
        Scene scene = new Scene(root, controller.getView().getWidth(), controller.getView().getHeight());

        // Send all key press events to the controller to be handled.
        scene.setOnKeyPressed(event -> controller.handleKeyPress(event));

        // The loop of the game
        Timeline timeline = new Timeline(
                new KeyFrame(
                        javafx.util.Duration.millis(1000.0 / 60), // 60 FPS
                        event -> controller.update(System.nanoTime())));
        timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
        timeline.play();

        stage.setScene(scene);
        stage.show();

    }

    /**
     * Launches main.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
