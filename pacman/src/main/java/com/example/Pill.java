package com.example;

/**
 * An abstract pill class for the pills in the maze. The position for the pill
 * will be set in the constructor of the pills that extend it.
 */
public abstract class Pill {
    protected int value;
    protected int size;
    protected float x;
    protected float y;

    /**
     * @return The value of the pill
     */
    public int getValue() {
        return this.value;
    }

    /**
     * @return The size of the pill
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return The x position of the pill
     */
    public float getX() {
        return this.x;
    }

    /**
     * @return The y position of the pill
     */
    public float getY() {
        return y;
    }

}
