package com.example.view;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public abstract class AbstractView implements View {
     
    protected Group surface;
    protected int width;
    protected int height;
    protected double positionScaler;

    public AbstractView(int width, int height, double positionScaler) {
        this.width = width;
        this.height = height;
        this.positionScaler = positionScaler;
        this.surface = new Group();
    }

    public void clear() {
        this.getSurface().getChildren().clear();
    }

    public void addView(View view) {
        this.getSurface().getChildren().add(view.getSurface());
    }

    /**
     * Adds the given image to the surface of the view at the given x and y positions.
     * @param image
     * @param x
     * @param y
     */
    public void addImageToSurface(Image image, float x, float y, int rotation) {
        ImageView imageView = new ImageView(image);
        imageView.setX(x*positionScaler);
        imageView.setY(y*positionScaler);
        imageView.setRotate(rotation);
        this.getSurface().getChildren().add(imageView);
    }

    public void addTextToSurface(Text text, int x, int y, int rotation) {
        text.setX(x);
        text.setY(y);
        text.setRotate(rotation);
        this.getSurface().getChildren().add(text);
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
