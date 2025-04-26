package com.example;

public class PacMan {
    
    float x;
    float y;
    float dx;
    float dy;
    float movementMultiplier;
    
    /**
     * Creates a new PacMan moving to the right.
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

    public void move() {
        this.x += this.dx * this.movementMultiplier;
        this.y += this.dy * this.movementMultiplier;
    }

    public void left() {
        this.dx = -1;
        this.dy = 0;
    }

    public void right() {
        this.dx = 1;
        this.dy = 0;
    }

    public void up() {
        this.dx = 0;
        this.dy = -1;
    }

    public void down() {
        this.dx = 0;
        this.dy = 1;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setMovementMultiplier(float c) {
        this.movementMultiplier = c;
    }

}
