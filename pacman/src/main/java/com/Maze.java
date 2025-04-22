package com;

public class Maze {
    
    int width;
    int height;
    PacMan pacman;

    public Maze(int width, int height, PacMan pacman) {
        this.width = width;
        this.height = height;
        this.pacman = pacman;
        // Set starting position of pacman
    }

    public void update() {
        // Update the maze
        // Check for collisions with walls
        // Check for collisions with ghosts
        // Check for collisions with pellets
        // Check for game over
    }
}
