package com.example;

/**
 * This is the abstract ghost class from which actual ghosts should extend.
 */
public abstract class Ghost {
    // protected Color color;
    protected float x;
    protected float y;

    public void moveLeft() {
        this.x -= 1;
    }

    public void moveRight() {
        this.x += 1;
    }

    public void moveUp() {
        this.y -= 1;
    }

    public void moveDown() {
        this.y += 1;
    }

}
