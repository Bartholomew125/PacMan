package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;

/**
 * The Maze class which represents the maze and evenrything in it
 */
public class Maze {

    int width;
    int height;
    PacMan pacman;
    String[][] maze; // The 2D array of strings which represents the maze.
    Pos2D[] walls;

    public Maze() {
        this.maze = this.readMazeFromFile();
        this.width = this.maze[0].length;
        this.height = this.maze.length;

        Pos2D pos = this.locatePacman();
        this.pacman = new PacMan(pos.getX(), pos.getY());
        this.pacman.setMovementMultiplier(0.1f);

        walls = this.locateCharacter("#");
    }

    /**
     * Reads the maze from the maze.txt file
     * 
     * @return A 2D array of strings
     */
    private String[][] readMazeFromFile() {
        String fileName = "maze.txt";
        String pathName = "src/main/resources/com/example/";
        Path path = Paths.get(pathName + fileName);

        try {
            // Use a stream to open the file and convert it to the 2D array
            return Files.lines(path)
                    .map(line -> line.split(""))
                    .toArray(String[][]::new);
        }
        // Catch any IO exceptions and return an empty 2D array
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
        // Check if there is exactly one pacman, and return an invalid positions
        // if there isint
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

        // Go through the maze, and find all positions (row, col) where c is
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

    /**
     * Update everything in the maze
     */
    public void update() {
        // Update the maze

        // Check for collisions with walls
        for (Pos2D wall : this.walls) {
            if (wall.distanceTo(this.getPacMan().getX(),
                    this.getPacMan().getY()) < 1) {
                this.getPacMan().stop();
            }
        }
        // Check for collisions with ghosts
        // Check for collisions with pellets
        // Check for game over
        this.pacman.move();
    }

    /**
     * @return The width of the maze
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return The height of the maze
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * @return The pacman in the maze
     */
    public PacMan getPacMan() {
        return this.pacman;
    }
}
