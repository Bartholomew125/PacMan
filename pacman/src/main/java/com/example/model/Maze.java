package com.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;

/**
 * The Maze class which represents the maze and evenrything in it
 */
public class Maze {

    private int width;
    private int height;
    private String[][] textMaze; // The 2D array of strings which represents the maze.
    private Wall[] walls;

    /**
     * Create a new maze
     */
    public Maze() {
        // Read the maze from the file and get its width and height.
        this.textMaze = this.readMazeFromFile();
        this.width = this.textMaze[0].length;
        this.height = this.textMaze.length;
        
        // Locate all the walls and create the wall array.
        Pos2D[] wallPositions = this.locateCharacter("#");
        this.walls = new Wall[wallPositions.length];
        for (int i = 0; i < wallPositions.length; i++) {
            this.walls[i] = new Wall(wallPositions[i].getX(), wallPositions[i].getY());
        }
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
    public Pos2D locatePacman() {
        Pos2D[] pacmanPositions = this.locateCharacter("p");
        // Check if there is exactly one pacman, and return an invalid positions
        // if there isint
        if (pacmanPositions.length != 1) {
            System.out.println("There isint exactly one p in the maze");
            return new Pos2D(-1, -1);
        }
        else {
            return pacmanPositions[0];
        } 
    } 

    /**
     * Locate all the small pills in the maze
     * @return The positions of the small pills
     */
    public Pos2D[] locateSmallPills() { 
        Pos2D[] smallPillPositions = this.locateCharacter("."); 
        return smallPillPositions;
    } 

    /**
     * Locate all the large pills in the maze
     * @return The positions of the large pills
     */
    public Pos2D[] locateLargePills() {
        Pos2D[] largePillPositions = this.locateCharacter("*");
        return largePillPositions;
    }

    /**
     * Locate all the ghosts in the maze
     * @return The positions of the ghosts
     */
    public Pos2D[] locateGhosts() {
        Pos2D[] ghostPositions = this.locateCharacter("g");
        return ghostPositions;
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

    /**
     * @return The maze file
     */
    public String[][] getTextMaze() {
        return this.textMaze;
    }

    /**
     * @return The walls of the maze
     */
    public Wall[] getWalls() {
        return this.walls;
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
}
