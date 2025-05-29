package com.example.model;

/**
 * An abstract pill class for the pills in the maze. The position for the pill
 * will be set in the constructor of the pills that extend it.
 */
public abstract class Pill extends Pos2D {
    private final int value;
    private final int size;

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
