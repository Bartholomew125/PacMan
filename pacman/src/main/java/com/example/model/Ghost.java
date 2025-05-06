package com.example.model;

import javafx.scene.paint.Color;

/**
 * This is the abstract ghost class from which actual ghosts should extend.
 */
public abstract class Ghost extends Moveable{
    protected Color color;
    protected float x;
    protected float y;
    protected boolean isAfraid;

    /**
     * Create a new ghost which is a moveable with a color.
     * @param x
     * @param y
     * @param dx
     * @param dy
     * @param multiplier
     * @param color
     */
    protected Ghost(float x, float y, float dx, float dy, double multiplier, Color color) {
        super(x, y, dx, dy, multiplier);
        this.color = color;
    }

    /**
     * @return The color of the ghost
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Set the color of the ghost
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
