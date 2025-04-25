package com.example;

public class PacMan {
    
    float x;
    float y;
    float dx;
    float dy;
    
    /**
     * Creates a new PacMan moving to the right.
     * @param x
     * @param y
     */
    public PacMan() {
        this.x = 0;
        this.y = 0;
        this.dx = 0;
        this.dy = 0;
    }

    public void move() {
        this.x += this.dx;
        this.y += this.dy;
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

}
