package com.example.view;

import java.io.InputStream;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * An abstract view which implemnts View.
 */
public abstract class AbstractView implements View {

    protected Group surface;
    protected int width;
    protected int height;
    protected double positionScaler;
    private final String fontPath = "/com/example/font/Emulogic.ttf";
        

    /**
     * Creates a new instance of AbstractView.
     * 
     * @param width
     * @param height
     * @param positionScaler
     */
    public AbstractView(int width, int height, double positionScaler) {
        this.width = width;
        this.height = height;
        this.positionScaler = positionScaler;
        this.surface = new Group();
    }

    /**
     * Clears surface.
     */
    public void clear() {
        this.getSurface().getChildren().clear();
    }

    /**
     * Adds view to surface.
     */
    public void addView(View view) {
        this.getSurface().getChildren().add(view.getSurface());
    }

    /**
     * Adds the given image to the surface of the view at the given x and y
     * positions.
     * 
     * @param image
     * @param x
     * @param y
     */
    public void addImageToSurface(Image image, float x, float y, int rotation, boolean flipped) {
        ImageView imageView = new ImageView(image);
        imageView.setX(x * positionScaler);
        imageView.setY(y * positionScaler);
        imageView.setRotate(rotation);
        imageView.setScaleX(flipped ? -1 : 1);
        this.getSurface().getChildren().add(imageView);
    }

    /**
     * Adds text to surface.
     * 
     * @param text
     * @param x
     * @param y
     * @param rotation
     */
    public void addTextToSurface(Text text, int x, int y, int textSize) {
        text.setX(x);
        text.setY(y);
        text.setFill(Color.WHITE);

        text.setFont(Font.loadFont(getClass().getResourceAsStream(fontPath), textSize));
        this.getSurface().getChildren().add(text);
    }

    public Button addButtonToSuface(String text, int textSize, int width, int height, double x, double y) {
        Button newButton = new Button(text);
        newButton.setPrefWidth(width);
        newButton.setPrefHeight(height);
        newButton.setLayoutX(x);
        newButton.setLayoutY(y);
        newButton.setFont(Font.loadFont(getClass().getResourceAsStream(fontPath), textSize));
        return newButton;
    }
    
    public Group getSurface() {
        return this.surface;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getPositionScaler() {
        return this.positionScaler;
    }
}
