package com.example;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * The viewe class in the MVC model. It is responsible for taking the maze
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

    public View(Maze maze, int squareSize) {
        this.squareSize = squareSize;
        this.maze = maze;
        this.width = maze.getWidth() * this.squareSize;
        this.height = maze.getHeight() * this.squareSize;

        this.wallImage = new Image(
                "file:src/main/resources/com/example/wall.png", squareSize,
                squareSize, true, false);
        this.pacmanImage = new Image(
                "file:src/main/resources/com/example/pacman.png", squareSize,
                squareSize, true, false);
    }

    public void render() {
        // Maze
        String[][] maze = this.maze.getMaze();
        for (int y = 0; y < this.maze.getHeight(); y++) {
            for (int x = 0; x < this.maze.getWidth(); x++) {
                if (maze[y][x].equals("#")) {
                    ImageView imageView = new ImageView(wallImage);
                    imageView.setX(x * squareSize);
                    imageView.setY(y * squareSize);
                    this.getSurface().getChildren().add(imageView);
                }
            }
        }

        // Pacman
        float x = this.maze.getPacMan().getX() * this.squareSize;
        float y = this.maze.getPacMan().getY() * this.squareSize;
        ImageView imageView = new ImageView(pacmanImage);
        imageView.setX(x);
        imageView.setY(y);
        this.getSurface().getChildren().add(imageView);

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
}
