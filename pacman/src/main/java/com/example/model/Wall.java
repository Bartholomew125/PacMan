package com.example.model;

/**
 * The wall class simply represents the position of a wall.
 */
public class Wall extends Pos2D {

    private boolean wallUp;
    private boolean wallDown;
    private boolean wallRight;
    private boolean wallLeft;

    /**
     * Create a new wall with the given position
     * 
     * @param x
     * @param y
     */
    public Wall(int x, int y) {
        super(x, y);
        this.wallUp = false;
        this.wallDown = false;
        this.wallRight = false;
        this.wallLeft = false;
    }

    public boolean hasWallUp() {
        return wallUp;
    }

    public void setWallUp(boolean wallUp) {
        this.wallUp = wallUp;
    }

    public boolean hasWallDown() {
        return wallDown;
    }

    public void setWallDown(boolean wallDown) {
        this.wallDown = wallDown;
    }

    public boolean hasWallRight() {
        return wallRight;
    }

    public void setWallRight(boolean wallRight) {
        this.wallRight = wallRight;
    }

    public boolean hasWallLeft() {
        return wallLeft;
    }

    public void setWallLeft(boolean wallLeft) {
        this.wallLeft = wallLeft;
    }
}
