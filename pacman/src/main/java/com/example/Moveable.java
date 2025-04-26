package com.example;

public abstract class Moveable {

    protected float x;
    protected float y;
    protected float dx;
    protected float dy;
    protected float movementMultiplier;

    /**
     * Moves Moveable depending on movementmultiplier and direction.
     */
    public void move() {
        this.x += this.dx * movementMultiplier;
        this.y += this.dy * movementMultiplier;
    }

    /**
     * Moves Movable left.
     */
    public void left() {
        this.dx = -1;
        this.dy = 0;
    }

    /**
     * Moves Moveable to the right.
     */
    public void right() {
        this.dx = 1;
        this.dy = 0;
    }

    /**
     * Moves Moveable down.
     */
    public void down() {
        this.dx = 0;
        this.dy = 1;
    }

    /**
     * Moves Moveable up.
     */
    public void up() {
        this.dx = 0;
        this.dy = -1;
    }

    /**
     * @return Moveables x-value.
     */
    public float getX() {
        return this.x;
    }

    /**
     * @return Moveables y-value.
     */
    public float getY() {
        return this.y;
    }

    /**
     * Sets Moveables movementmultiplier.
     * 
     * @param multiplier
     */
    public void setMovementMultiplier(float multiplier) {
        this.movementMultiplier = multiplier;
    }

    /**
     * Stops the Movable in its place by removing its speed, and rounding its
     * positions to nearest integer.
     */
    public void stop() {
        this.dx = 0;
        this.dy = 0;
        this.x = Math.round(x);
        this.y = Math.round(y);
    }
}
