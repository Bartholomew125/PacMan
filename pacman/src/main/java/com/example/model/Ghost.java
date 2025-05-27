package com.example.model;

import java.util.Stack;

import com.example.Algebra;
import com.example.controller.searching.SearchAlgorithm;

import javafx.scene.paint.Color;

/**
 * This is the abstract ghost class from which actual ghosts should extend.
 */
public class Ghost extends Moveable {
    private Color color;
    private boolean isAfraid;
    private Stack<Pos2D> moveStack;
    private SearchAlgorithm searchAlgorithm;

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
    public Ghost(float x, float y, Color color, SearchAlgorithm searchAlgorithm) {
        super(x, y, 0, 0, 0.05);
        this.color = color;
        this.moveStack = new Stack<>();
        this.searchAlgorithm = searchAlgorithm;
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

    public SearchAlgorithm getSearchAlgorithm() {
        return this.searchAlgorithm;
    }

    @Override
    public void move() {
        if (this.moveStack.isEmpty()) {
            this.stop();
        }
        else if (Algebra.distanceBetween(this.getMoveStack().peek(), this) <= 0.1) {
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
