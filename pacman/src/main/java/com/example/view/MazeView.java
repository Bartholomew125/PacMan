package com.example.view;

import javafx.scene.image.Image;

import com.example.model.Maze;
import com.example.model.Wall;

/**
 * MazeView which extends AbstractView.
 */
public class MazeView extends AbstractView {

    private Maze maze;
    private Image emptyWallImage;
    private Image lineWallImage;
    private Image twoLinesWallImage;
    private Image cornerWallImage;
    private Image uTurnWallImage;

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
        this.emptyWallImage = new Image("file:src/main/resources/com/example/walls/empty.png", this.getPositionScaler(),
                this.getPositionScaler(), false, false);

        this.lineWallImage = new Image("file:src/main/resources/com/example/walls/line.png", this.getPositionScaler(),
                this.getPositionScaler(), false, false);

        this.twoLinesWallImage = new Image("file:src/main/resources/com/example/walls/twoLines.png", this.getPositionScaler(),
                this.getPositionScaler(), false, false);

        this.cornerWallImage = new Image("file:src/main/resources/com/example/walls/corner.png", this.getPositionScaler(),
                this.getPositionScaler(), false, false);
            
        this.uTurnWallImage = new Image("file:src/main/resources/com/example/walls/uTurn.png", this.getPositionScaler(),
                this.getPositionScaler(), false, false);

        // Add the walls to the surface
        for (Wall wall : this.maze.getWalls()) {
            if (wall.hasWallUp() && wall.hasWallDown() && wall.hasWallRight() && wall.hasWallLeft()) {
                this.addImageToSurface(emptyWallImage, wall.getX(), wall.getY(), 0, false);
            }

            // Single Lines
            else if (wall.hasWallUp() && wall.hasWallDown() && wall.hasWallRight() && !wall.hasWallLeft()) {
                this.addImageToSurface(this.lineWallImage, wall.getX(), wall.getY(), -90, false);
            }
            else if (wall.hasWallUp() && !wall.hasWallDown() && wall.hasWallRight() && wall.hasWallLeft()) {
                this.addImageToSurface(this.lineWallImage, wall.getX(), wall.getY(), 180, false);
            }
            else if (wall.hasWallUp() && wall.hasWallDown() && !wall.hasWallRight() && wall.hasWallLeft()) {
                this.addImageToSurface(this.lineWallImage, wall.getX(), wall.getY(), 90, false);
            }
            else if (!wall.hasWallUp() && wall.hasWallDown() && wall.hasWallRight() && wall.hasWallLeft()) {
                this.addImageToSurface(this.lineWallImage, wall.getX(), wall.getY(), 0, false);
            }

            // Corners
            else if (!wall.hasWallUp() && wall.hasWallDown() && wall.hasWallRight() && !wall.hasWallLeft()) {
                this.addImageToSurface(this.cornerWallImage, wall.getX(), wall.getY(), 0, false);
            }
            else if (wall.hasWallUp() && !wall.hasWallDown() && wall.hasWallRight() && !wall.hasWallLeft()) {
                this.addImageToSurface(this.cornerWallImage, wall.getX(), wall.getY(), -90, false);
            }
            else if (wall.hasWallUp() && !wall.hasWallDown() && !wall.hasWallRight() && wall.hasWallLeft()) {
                this.addImageToSurface(this.cornerWallImage, wall.getX(), wall.getY(), 180, false);
            }
            else if (!wall.hasWallUp() && wall.hasWallDown() && !wall.hasWallRight() && wall.hasWallLeft()) {
                this.addImageToSurface(this.cornerWallImage, wall.getX(), wall.getY(), 90, false);
            }

            // Doule Lines
            else if (wall.hasWallUp() && wall.hasWallDown() && !wall.hasWallRight() && !wall.hasWallLeft()) {
                this.addImageToSurface(this.twoLinesWallImage, wall.getX(), wall.getY(), 90, false);
            }
            else if (!wall.hasWallUp() && !wall.hasWallDown() && wall.hasWallRight() && wall.hasWallLeft()) {
                this.addImageToSurface(this.twoLinesWallImage, wall.getX(), wall.getY(), 0, false);
            }

            // U Turn
            else if (!wall.hasWallUp() && !wall.hasWallDown() && wall.hasWallRight() && !wall.hasWallLeft()) {
                this.addImageToSurface(this.uTurnWallImage, wall.getX(), wall.getY(), 0, false);
            }
            else if (!wall.hasWallUp() && !wall.hasWallDown() && !wall.hasWallRight() && wall.hasWallLeft()) {
                this.addImageToSurface(this.uTurnWallImage, wall.getX(), wall.getY(), 180, false);
            }
            else if (!wall.hasWallUp() && wall.hasWallDown() && !wall.hasWallRight() && !wall.hasWallLeft()) {
                this.addImageToSurface(this.uTurnWallImage, wall.getX(), wall.getY(), 90, false);
            }
            else if (wall.hasWallUp() && !wall.hasWallDown() && !wall.hasWallRight() && !wall.hasWallLeft()) {
                this.addImageToSurface(this.uTurnWallImage, wall.getX(), wall.getY(), -90, false);
            }
        }
    }

    @Override
    public void render(double nanoTime) {
    }
}
