package com.example;

import com.example.controller.Controller;
import com.example.model.Game;
import com.example.view.Viewer;

import javafx.animation.AnimationTimer;
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
        Game game = new Game();
        Viewer viewer = new Viewer(1000, 1000, game);
        Controller controller = new Controller(game, viewer, 60);

        // Attach the viewers surface to the root, so it is displayed
        root.getChildren().add(viewer.getSurface());

        // Create the scene with the root, and the size of the viewers surface.
        Scene scene = new Scene(root, viewer.getWidth(), viewer.getHeight());

        // Send all key press events to the controller to be handled.
        scene.setOnKeyPressed(event -> controller.handleKeyPress(event));

        // The game loop is represented as the handle method in the
        // AnimationTimer
        AnimationTimer animationTimer = new AnimationTimer() {

            public void handle(long t1) {
                // Every frame, enter this if statement, and update stuff
                controller.update(t1);
            }
        };

        animationTimer.start();

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}