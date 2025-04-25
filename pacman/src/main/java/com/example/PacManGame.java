package com.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class PacManGame extends Application {

    ImageView imageView;

    @Override
    public void start(Stage stage) {

        this.imageView = new ImageView();
        Group root = new Group(imageView);

        Maze maze = new Maze();
        View viewer = new View(maze, 20);
        //Controller controller = new Controller(maze);

        Scene scene = new Scene(root, viewer.getWidth(), viewer.getHeight());

        root.getChildren().add(viewer.getSurface());
        viewer.render();

        final int fps = 2;

        AnimationTimer AT = new AnimationTimer() {
            long t0 = System.nanoTime();

            public void handle(long t1) {
                if ((t1 - t0) >= Math.pow(10, 9) / fps) {
                    t0 = t1;
                    //controller.update();
                    //viewer.update();
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