package com.example.model;

/**
 * An abstract pill class for the pills in the maze. The position for the pill
 * will be set in the constructor of the pills that extend it.
 */
public abstract class Pill extends Pos2D {
    protected int value;
    protected int size;
    protected int x;
    protected int y;

    protected Pill(int x, int y, int value, int size) {
        super(x, y);
        this.value = value;
        this.size = size;
    }

    public int getValue() {
        return this.value;
    }

    public int getSize() {
        return this.size;
    }
}
