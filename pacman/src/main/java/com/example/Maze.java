package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Maze {

    int width;
    int height;
    PacMan pacman;
    String[][] maze;

    public Maze() {
        this.maze = this.readMazeFromFile();
        this.pacman = new PacMan();
    }

    private String[][] readMazeFromFile() {
        String fileName = "maze.txt";
        String pathName = "src/main/resources/com/example/";
        Path path = Paths.get(pathName + fileName);

        try {
            return Files.lines(path)
                    .map(line -> line.split(""))
                    .toArray(String[][]::new);
        }
        catch (IOException e) {
            e.printStackTrace();
            return new String[0][0];
        }
    }

    public void update() {
        // Update the maze
        // Check for collisions with walls
        // Check for collisions with ghosts
        // Check for collisions with pellets
        // Check for game over
    }
}
