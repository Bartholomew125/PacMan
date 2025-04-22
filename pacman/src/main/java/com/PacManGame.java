package com;

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
        stage.setScene(scene);
        stage.show();

        System.out.println("hej1");

    }

    public void update() {
        Image image = new Image("file:src/main/resources/com/pacman.png");
        this.imageView.setImage(image);
    }

    public static void main(String[] args) {
        launch(args);
    }

}