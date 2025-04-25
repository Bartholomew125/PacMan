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
        Pos2D pos = this.locatePacman();
        this.pacman = new PacMan(pos.getX(), pos.getY());
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
        return this.locateCharacter("p")[0];
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

        for (int y = 0; y < this.maze.length; y++) {
            for (int x = 0; x < this.maze[y].length; x++) {
                if (this.maze[y][x] == c) {
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
    }
}
