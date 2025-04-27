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
    private Maze maze;
    private Group surface = new Group();

    private Image wallImage;
    private Image pacmanImage;
    private Image smallPill;

    /**
     * Create a new view of a maze, and a square size
     * 
     * @param maze
     * @param squareSize
     */
    public View(Maze maze, int squareSize) {
        this.squareSize = squareSize;
        this.maze = maze;
        // Calculate the size of the window
        this.width = maze.getWidth() * this.squareSize;
        this.height = maze.getHeight() * this.squareSize;

        // Load the images
        this.wallImage = new Image(
                "file:src/main/resources/com/example/wall.png", squareSize,
                squareSize, true, false);
        this.pacmanImage = new Image(
                "file:src/main/resources/com/example/pacman.png", squareSize,
                squareSize, true, false); 
    }

    /**
     * Render everything on the surface
     */
    public void render() {
        this.surface.getChildren().clear();

        // Add the walls to the surface
        for (Pos2D wall : this.maze.getWalls()) {
            this.addImageToSurface(wallImage, wall.getX(), wall.getY());
        }

        // Add pacman to the surface
        this.addImageToSurface(pacmanImage, this.maze.getPacMan().getX(), this.maze.getPacMan().getY());
    }

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
