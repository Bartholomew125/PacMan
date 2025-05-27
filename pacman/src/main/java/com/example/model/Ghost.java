package com.example.model;

import java.util.LinkedList;
import java.util.Stack;
import javafx.scene.paint.Color;

/**
 * This is the abstract ghost class from which actual ghosts should extend.
 */
public abstract class Ghost extends Moveable {

    protected Color color;
    protected boolean isAfraid;
    protected Stack<Pos2D> moveStack;
    protected LinkedList<Pos2D> moveQueue;

    /**
     * Create a new ghost which is a moveable with a color.
     * 
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
        this.moveStack = new Stack<>();
        this.moveQueue = new LinkedList<>();
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setIsAfraid(boolean isAfraid) {
        this.isAfraid = isAfraid;
    }

    public boolean getIsAfraid() {
        return this.isAfraid;
    }

    public Stack<Pos2D> getMoveStack() {
        return this.moveStack;
    }

    public void setMoveStack(Stack<Pos2D> moveStack) {
        this.moveStack = moveStack;
    }

    @Override
    public void move() {
        if (this.moveStack.isEmpty()) {
            this.stop();
        } else if (this.getMoveStack().peek().distanceTo(this) <= 0.1) {
            this.getMoveStack().pop();
            if (!this.moveStack.isEmpty()) {
                this.setDX(this.getMoveStack().peek().getX() - this.getX());
                this.setDY(this.getMoveStack().peek().getY() - this.getY());
            }
        } else {
            super.move();
        }
    }
}
