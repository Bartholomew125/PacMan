package com.example.model;

/**
 * A simple class for representing a 2D position.
 */
public class Pos2D {

    private int x;
    private int y;

    public Pos2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    public Pos2D add(Pos2D pos) {
        Pos2D newPos = new Pos2D(pos.getX() + this.x, pos.getY() + this.y);

        return newPos;
    }

    public boolean equals(Pos2D pos) {
        return pos.getX() == this.getX() && pos.getY() == this.getY();
    }

}
