package com.example.view;

import com.example.model.Maze;
import com.example.model.Wall;

import javafx.scene.image.Image;

public class MazeView extends AbstractView{
    
    private Maze maze;
    private Image wallImage;

    public MazeView(int width, int height, double positionScaler, Maze maze) {
        super(width, height, positionScaler);

        this.maze = maze;

        // Load images
        this.wallImage = new Image("file:src/main/resources/com/example/wall.png", this.getPositionScaler(), this.getPositionScaler(), false, false);
    
        // Add the walls to the surface
        for (Wall wall : this.maze.getWalls()) {
            this.addImageToSurface(wallImage, wall.getX(), wall.getY(), 0);
        }
    }

    @Override
    public void render(double nanoTime) {
    }
}
