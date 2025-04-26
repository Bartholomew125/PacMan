package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;

public class Maze {

    int width;
    int height;
    PacMan pacman;
    String[][] maze;

    public Maze() {
        this.maze = this.readMazeFromFile();
        this.width = this.maze[0].length;
        this.height = this.maze.length;
        Pos2D pos = this.locatePacman();
        this.pacman = new PacMan(pos.getX(), pos.getY());
        this.pacman.setMovementMultiplier(0.1f);
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

    /**
     * Locates the first pacman in the maze
     * 
     * @return Position of pacman
     */
    private Pos2D locatePacman() {
        Pos2D[] poses = this.locateCharacter("p");
        if (poses.length != 1) {
            System.out.println("There isint exactly one p in the maze");
            return new Pos2D(-1, -1);
        }
        else {
            return poses[0];
        }
    }

    /**
     * Locates all instances of a character c in the maze and returns them as an
     * array of 2D positions
     * 
     * @return Array of 2D positions of c in the maze
     */
    private Pos2D[] locateCharacter(String c) {
        // Starting list with variable length
        ArrayList<Pos2D> positions = new ArrayList<Pos2D>();

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (this.maze[y][x].equals(c)) {
                    positions.add(new Pos2D(x, y));
                }
            }
        }

        return positions.toArray(new Pos2D[positions.size()]);
    }

    public String[][] getMaze() {
        return this.maze;
    }

    public void update() {
        // Update the maze
        // Check for collisions with walls
        // Check for collisions with ghosts
        // Check for collisions with pellets
        // Check for game over
        this.pacman.move();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public PacMan getPacMan() {
        return this.pacman;
    }
}
