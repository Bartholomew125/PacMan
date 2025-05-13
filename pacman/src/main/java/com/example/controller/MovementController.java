package com.example.controller;

import com.example.model.Moveable;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MovementController {
    
    private Moveable moveable;
    private Direction waitingDirection;

    public MovementController(Moveable moveable) {
        this.moveable = moveable;
    }

    /**
     * Handles keypresses from the scene
     * 
     * @param event
     */
    public void handleKeyPress(KeyEvent event) {
        KeyCode key = event.getCode();
        if (key == KeyCode.LEFT) {
            this.setWaitingDirection(Direction.LEFT);
        }
        if (key == KeyCode.RIGHT) {
            this.setWaitingDirection(Direction.RIGHT);
        }
        if (key == KeyCode.UP) {
            this.setWaitingDirection(Direction.UP);
        }
        if (key == KeyCode.DOWN) {
            this.setWaitingDirection(Direction.DOWN);
        }
    }

    public void setWaitingDirection(Direction direction) {
        this.waitingDirection = direction;
    }

    public void update(long nanoTime) {
        if (this.waitingDirection != null) {
            float x = this.moveable.getX();
            float y = this.moveable.getY();
            double varriance = 0.1;
    
            // The position is at an integer position within a varraince
            if (Math.abs(x-Math.round(x)) < varriance && 
                Math.abs(y-Math.round(y)) < varriance ) {
                    this.changeDirection();
            }
        }
    }

    private void changeDirection() {
        this.moveable.stop();

        if (this.waitingDirection == Direction.UP) {
            this.moveable.up();
        }
        else if (this.waitingDirection == Direction.LEFT) {
            this.moveable.left();
        }
        else if (this.waitingDirection == Direction.DOWN) {
            this.moveable.down();
        }
        else if (this.waitingDirection == Direction.RIGHT) {
            this.moveable.right();
        }

        this.waitingDirection = null;
    }
}
