package com.example;

/**
 * A simple class for representing a 2D position
 */
public class Pos2D {

    int x;
    int y;

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

    public double distanceTo(float x, float y) {
        return Math.sqrt(Math.pow(x-this.x,2) + Math.pow(y-this.y,2));
    }

    public String toString() {
        return "("+this.getX()+","+this.getY()+")";
    }

}
