package com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class PacManGame extends Application {

    @Override
    public void start(Stage stage) {

        // Create pacman
        PacMan pacman = new PacMan(100,100);

        // Controller handeling the key presses
        Controller controller = new Controller(pacman);
        scene.setOnKeyPressed(event -> controller.handleKeyPress(event));

        // Create a maze
        Maze maze = new Maze(500, 1000, pacman);

        // Add the maze to the scene
        ImageView pacmanView = new ImageView(pacman.getImage());
        Scene scene = new Scene(pacmanView,500,1000);
        stage.setScene(scene);
        stage.show();

        while (!maze.isGameOver()) {
            pacman.move();
            maze.update();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}