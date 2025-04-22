package com;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class View extends Application {

    Maze maze;

    public View(Maze maze) {
        this.maze = maze;
    }

    @Override
    public void start(Stage stage) {

        // // Add the maze to the scene
        // ImageView pacmanView = new ImageView(pacman.getImage());
        // Group root = new Group(pacmanView);
        // Scene scene = new Scene(root,500,1000);
        // scene.setOnKeyPressed(event -> controller.handleKeyPress(event));
        // stage.setScene(scene);
        // stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}