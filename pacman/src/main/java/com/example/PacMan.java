package com.example;

/**
 * The PacMan class which represents the pacman
 */
public class PacMan {

    float x;
    float y;
    float dx;
    float dy;
    float movementMultiplier; // For controlling the speed multiplier

    /**
     * Creates a new PacMan moving to the right.
     * 
     * @param x
     * @param y
     */
    public PacMan(float x, float y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.movementMultiplier = 1;
    }

    /**
     * Move the pacman according to its direction and movement multiplier
     */
    public void move() {
        this.x += this.dx * this.movementMultiplier;
        this.y += this.dy * this.movementMultiplier;
    }

    /**
     * Change direction to the left
     */
    public void left() {
        this.dx = -1;
        this.dy = 0;
    }

    /**
     * Change direction to the right
     */
    public void right() {
        this.dx = 1;
        this.dy = 0;
    }

    /**
     * Change the direction to up
     */
    public void up() {
        this.dx = 0;
        this.dy = -1;
    }

    /**
     * Change the direction to down
     */
    public void down() {
        this.dx = 0;
        this.dy = 1;
    }

    /**
     * @return Pacmans x position in the maze
     */
    public float getX() {
        return this.x;
    }

    /**
     * @return Pacmans y positiono in the maze
     */
    public float getY() {
        return this.y;
    }

    /**
     * Set the movement multiplier
     * @param multiplier
     */
    public void setMovementMultiplier(float multiplier) {
        this.movementMultiplier = multiplier;
    }

}
