package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Maze {
    
    int width;
    int height;
    PacMan pacman;
    String[][] maze;


    public Maze() {

        this.maze = this.readMazeFromFile();


        this.pacman = new PacMan();
    }

    private String[][] readMazeFromFile(){
        String fileName = "maze.txt";
        String path = "src/main/resources/";
        
        // Handle any expections that might occur
        try {
            // Read the file
            FileInputStream file = new FileInputStream("src/main/resources/maze.txt");

            // Read byte for byte
            while (file.read() != -1) {
                int c = file.read();
                file.
            }

        } catch (FileNotFoundException e) {
            System.out.println("Found no file named "+fileName+" in path "+path);
        } catch (IOException e) {
            System.out.println("Error while reading "+path+fileName+"\n"+e);
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
