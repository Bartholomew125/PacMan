package com.example;

public class PacMan extends Moveable{
    
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
}