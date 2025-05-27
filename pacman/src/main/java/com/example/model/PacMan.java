package com.example.model;

/**
 * The PacMan class which represents the pacMan
 */
public class PacMan extends Moveable {

    /**
     * Creates a new PacMan moving to the right.
     * 
     * @param x
     * @param y
     */
    public PacMan(float x, float y) {
        super(x, y, 1, 0, 0.06);
    }
}
