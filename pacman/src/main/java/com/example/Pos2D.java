package com.example;

/**
 * A simple class for representing a 2D position
 */
public class Pos2D {

    private int x;
    private int y;

    public Pos2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return The x value
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x value
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return The y value
     */
    public int getY() {
        return y;
    }

    /**
     * Set the y value
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calculates the euclidian distance from this position to the given one.
     * 
     * @param x
     * @param y
     * @return
     */
    public double distanceTo(Moveable moveable) {
        return Math.sqrt(Math.pow(moveable.getX() - this.x, 2) + Math.pow(moveable.getY() - this.y, 2));
    }

    /**
     * @return A textual representation of the position.
     */
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

}
