package com.example;

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

        // Create the Maze, Viewer and Controller
        Maze maze = new Maze();
        View viewer = new View(maze, 20);
        Controller controller = new Controller(maze);

        // Attach the viewers surface to the root, so it is displayed
        root.getChildren().add(viewer.getSurface());

        // Create the scene with the root, and the size of the viewers surface.
        Scene scene = new Scene(root, viewer.getWidth(), viewer.getHeight());

        // Send all key press events to the controller to be handled.
        scene.setOnKeyPressed(event -> controller.handleKeyPress(event));

        // The framerate of the game
        final int fps = 60;

        // The game loop is represented as the handle method in the
        // AnimationTimer
        AnimationTimer AT = new AnimationTimer() {

            // The current nanoTime to be used as timing
            long t0 = System.nanoTime();

            public void handle(long t1) {
                // Every frame, enter this if statement, and update stuff
                if ((t1 - t0) >= Math.pow(10, 9) / fps) {
                    t0 = t1;
                    viewer.render();
                    maze.update();

                }
            }
        };

        AT.start();

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}