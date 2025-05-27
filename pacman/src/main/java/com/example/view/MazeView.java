package com.example.view;

import javafx.scene.image.Image;

import com.example.model.Maze;
import com.example.model.Wall;

/**
 * MazeView which extends AbstractView.
 */
public class MazeView extends AbstractView {

    private Maze maze;
    private Image wallImage;

    /**
     * Creates a new MazeView.
     * 
     * @param width
     * @param height
     * @param positionScaler
     * @param maze
     */
    public MazeView(int width, int height, double positionScaler, Maze maze) {
        super(width, height, positionScaler);

        this.maze = maze;

        // Load images
        this.wallImage = new Image("file:src/main/resources/com/example/wall.png", this.getPositionScaler(),
                this.getPositionScaler(), false, false);

        // Add the walls to the surface
        for (Wall wall : this.maze.getWalls()) {
            this.addImageToSurface(wallImage, wall.getX(), wall.getY(), 0, false);
        }
    }

    @Override
    public void render(double nanoTime) {
    }
}
