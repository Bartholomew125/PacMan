package com.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Group root = new Group();

        Maze maze = new Maze();
        View viewer = new View(maze, 20);
        //Controller controller = new Controller(maze);

        root.getChildren().add(viewer.getSurface());
        Scene scene = new Scene(root, viewer.getWidth(), viewer.getHeight());

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