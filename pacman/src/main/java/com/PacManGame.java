package com;

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
        Scene scene = new Scene(root,500,600);

        final int fps = 2;

        new AnimationTimer()
        {
            long t0 = System.nanoTime();

            public void handle(long t1)
            {
                if ((t1 - t0) >= Math.pow(10, 9)/fps) {
                    t0 = t1;
                }
            }
        }.start();
        stage.show();


        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}