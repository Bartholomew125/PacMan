package com.example.model;

/**
 * The Maze class which represents the maze and evenrything in it
 */
public class Maze {

    private int width;
    private int height;
    private Wall[] walls;

    /**
     * Create a new maze
     */
    public Maze(int width, int height, Pos2D[] wallPositions) {
        this.width = width;
        this.height = height;
        this.walls = new Wall[wallPositions.length];
        for (int i = 0; i < wallPositions.length; i++) {
            this.walls[i] = new Wall(wallPositions[i].getX(), wallPositions[i].getY());
        }
    }

    /**
     * Checks whether there is a wall at position.
     * 
     * @param x
     * @param y
     * @return
     */
    public boolean isWallAt(int x, int y) {
        if (x < 0 || x > this.getWidth() || y < 0 || y > this.getHeight()) {
            return false;
        }
        for (Wall wall : this.getWalls()) {
            if (x == wall.getX() && y == wall.getY()) {
                return true;
            }
        }
        return false;
    }

    public Wall[] getWalls() {
        return this.walls;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
