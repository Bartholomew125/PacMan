package com.example;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The view class in the MVC model. It is responsible for taking the maze
 * model, and converting everything in it to a format that can be displayed in
 * the javafx scene from the main class.
 */
public class View {

    private int squareSize;
    private int width;
    private int height;
    private Game game;
    private Group surface = new Group();

    private Image wallImage;
    private Image pacmanImage;
    private Image smallPillImage;

    /**
     * Create a new view of a maze, and a square size
     * 
     * @param maze
     * @param squareSize
     */
    public View(Game game, int squareSize) {
        this.squareSize = squareSize;
        this.game = game;

        // Calculate the size of the window
        this.width = this.game.getMaze().getWidth() * this.squareSize;
        this.height = this.game.getMaze().getHeight() * this.squareSize;

        // Load the images
        this.wallImage = new Image(
                "file:src/main/resources/com/example/wall.png", squareSize,
                squareSize, true, false);
        this.pacmanImage = new Image(
                "file:src/main/resources/com/example/pacman.png", squareSize,
                squareSize, true, false); 
        this.smallPillImage = new Image(
            "file:src/main/resources/com/example/smallPill.png", squareSize,
            squareSize, true, false); 
    }

    /**
     * Render everything to the surface
     */
    public void render() {
        // Clear the surface
        this.surface.getChildren().clear();

        // Add the walls to the surface
        for (Wall wall : this.game.getMaze().getWalls()) {
            this.addImageToSurface(wallImage, wall.getX(), wall.getY());
        }

        // Add pacman to the surface
        this.addImageToSurface(pacmanImage, this.game.getPacMan().getX(), this.game.getPacMan().getY()); 

        // Add the small pills
        for (Pill pill : this.game.getSmallPillsArray()){ 
            this.addImageToSurface(smallPillImage, pill.getX(), pill.getY());
        }

    }

    /**
     * Adds the given image to the surface of the view at the given x and y positions.
     * @param image
     * @param x
     * @param y
     */
    private void addImageToSurface(Image image, float x, float y) {
        ImageView imageView = new ImageView(image);
        imageView.setX(x * this.squareSize);
        imageView.setY(y * this.squareSize);
        this.getSurface().getChildren().add(imageView);
    }

    /**
     * @return The surface of the view
     */
    public Group getSurface() {
        return this.surface;
    }

    /**
     * @return The width of the view
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return The height of the view
     */
    public int getHeight() {
        return this.height;
    }
}
