package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.example.model.Pos2D;

/**
 * TextualMaze class that is responsible for loading the maze from the file.
 */
public class TextualMaze {

    private String[][] textMaze; // The 2D array of strings which represents the maze.
    private int width;
    private int height;
    private Pos2D[] wallPositions;
    private Pos2D[] ghostPositions;
    private Pos2D[] smallPillPositions;
    private Pos2D[] largePillPositions;
    private Pos2D pacManPosition;

    /**
     * Creates a new textual maze by loading it from fiile, and finding all the relevant characters.
     */
    public TextualMaze() {
        this.textMaze = this.readMazeFromFile();
        this.width = this.textMaze[0].length;
        this.height = this.textMaze.length;

        this.wallPositions = this.locateCharacter("#");
        this.ghostPositions = this.locateCharacter("g");
        this.smallPillPositions = this.locateCharacter(".");
        this.largePillPositions = this.locateCharacter("*");
        this.pacManPosition = this.locateCharacter("p")[0];
    }
    
    /**
     * Reads the maze from the maze.txt file
     * 
     * @return A 2D array of strings
     */
    private String[][] readMazeFromFile() {
        String fileName = "maze3.txt";
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
                if (this.textMaze[y][x].equals(c)) {
                    positions.add(new Pos2D(x, y));
                }
            }
        }
        return positions.toArray(new Pos2D[positions.size()]);
    }

    public Pos2D[] getWallPositions() {
        return this.wallPositions;
    }

    public Pos2D[] getGhostPositions() {
        return ghostPositions;
    }

    public Pos2D[] getSmallPillPositions() {
        return smallPillPositions;
    }

    public Pos2D[] getLargePillPositions() {
        return largePillPositions;
    }

    public Pos2D getPacManPosition() {
        return pacManPosition;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String[][] getTextMaze() {
        return this.textMaze;
    }
    
}
