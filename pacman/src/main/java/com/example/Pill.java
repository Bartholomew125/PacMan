package com.example;

public abstract class Pill {
    protected int value;
    protected int size;
    protected float x;
    protected float y;
    
    public int getValue() {
        return this.value;
    }

    public int getSize() {
        return this.size;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
}
