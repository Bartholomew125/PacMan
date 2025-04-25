package com.example;

import javafx.scene.Group;
import javafx.scene.Node;
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

    public View(Maze maze, int squareSize) {
        this.squareSize = squareSize;
        this.maze = maze;
        this.width = maze.getWidth() * this.squareSize;
        this.height = maze.getHeight() * this.squareSize;
    }

    public void render() {
        float x = this.maze.getPacMan().getX() * this.squareSize;
        float y = this.maze.getPacMan().getY() * this.squareSize;
        System.out.println(x+","+y);
        Circle pacman = new Circle(x, y, 10, Color.YELLOW);
        this.surface.getChildren().add(pacman);
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
