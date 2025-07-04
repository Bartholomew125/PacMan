package com.example.model;

import javafx.util.Pair;

import com.example.controller.DirectionAdapter;

/**
 * The movable class represents anything that needs to be moved.
 */
public abstract class Moveable {

    private final float startX;
    private final float startY;
    private float x;
    private float y;
    private float dx;
    private float dy;
    private double movementMultiplier;
    private boolean isEdible;
    private int rotation;

    public Moveable(float x, float y, float dx, float dy, double movementMultiplier) {
        this.startX = x;
        this.startY = y;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.movementMultiplier = movementMultiplier;
        this.rotation = 0;
    }

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
        this.rotation = 180;
    }

    /**
     * Moves Moveable to the right.
     */
    public void right() {
        this.dx = 1;
        this.dy = 0;
        this.rotation = 0;
    }

    /**
     * Moves Moveable down.
     */
    public void down() {
        this.dx = 0;
        this.dy = 1;
        this.rotation = 90;
    }

    /**
     * Moves Moveable up.
     */
    public void up() {
        this.dx = 0;
        this.dy = -1;
        this.rotation = -90;
    }

    /**
     * Sets the direction of the Moveable.
     * 
     * @param dir
     */
    public void setDirection(Direction dir) {
        Pair<Float, Float> direction = DirectionAdapter.adapt(dir);
        if (direction != null) {
            this.dx = direction.getKey();
            this.dy = direction.getValue();
            this.rotation = DirectionAdapter.adaptDegrees(dir);
        }
    }

    public Direction getDirection() {
        return DirectionAdapter.adapt(this.dx, this.dy);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getDX() {
        return this.dx;
    }

    public float getDY() {
        return this.dy;
    }

    public void setMovementMultiplier(double multiplier) {
        this.movementMultiplier = multiplier;
    }

    public double getMovementMultiplier() {
        return this.movementMultiplier;
    }

    /**
     * Stops the Movable in its place by removing its speed, and rounding its
     * positions to nearest integer.
     */
    public void stop() {
        if (this.dx == 0) {
            this.y = Math.round(this.y);
        }
        if (this.dy == 0) {
            this.x = Math.round(this.x);
        }
        this.dx = 0;
        this.dy = 0;
    }

    public boolean getIsEdible() {
        return this.isEdible;
    }

    public void setIsEdible(boolean isEdible) {
        this.isEdible = isEdible;
    }

    public int getRotation() {
        return this.rotation;
    }

    public void setDX(float dx) {
        this.dx = dx;
    }

    public void setDY(float dy) {
        this.dy = dy;
    }

    /**
     * Resets the position of the moveable back to its starting position.
     */
    public void resetPosition() {
        this.x = this.startX;
        this.y = this.startY;
    }
}
