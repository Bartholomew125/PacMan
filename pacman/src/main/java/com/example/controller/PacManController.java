package com.example.controller;

import com.example.model.Direction;
import com.example.model.Maze;
import com.example.model.PacMan;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PacManController {
    
    private PacMan pacMan;
    private Maze maze;
    private Direction waitingDirection;

    public PacManController(PacMan pacMan, Maze maze) {
        this.pacMan = pacMan;
        this.maze = maze;
    }

    /**
     * Handles keypresses from the scene
     * 
     * @param event
     */
    public void handleKeyPress(KeyEvent event) {
        KeyCode key = event.getCode();
        Direction dir = DirectionAdapter.adapt(key);
        // Check if pacMan i standing still
        if (this.pacMan.getDirection() == null) {
            pacMan.setDirection(dir);
        }
        // Check if pacMan i moving in the opposite direction
        else if (this.pacMan.getDirection() == DirectionAdapter.opposite(dir)) {
            pacMan.setDirection(dir);
        }
        // Check if there is a passage in the direction pressed
        else if (isPassage(dir)){
            this.setWaitingDirection(dir);
        }
        // Any other case
        else {
            pacMan.setDirection(dir);
        }
    }

    /**
     * Checks if there is a passage further ahead in the direction pressed
     * 
     * @param dir
     * @return true if there is a passage, false otherwise
     */
    private boolean isPassage(Direction dir) {
        int pacManFutureX;
        int pacManFutureY;
        // Case 1
        if (this.pacMan.getDirection() == Direction.UP || this.pacMan.getDirection() == Direction.LEFT) {
            pacManFutureX = (int) this.pacMan.getX();
            pacManFutureY = (int) this.pacMan.getY();
        }
        // Case 2
        else {
            pacManFutureX = (int) this.pacMan.getX() + (int) this.pacMan.getDX();
            pacManFutureY = (int) this.pacMan.getY() + (int) this.pacMan.getDY();
        }
        if (dir == Direction.LEFT) {
            return !maze.isWallAt(pacManFutureX-1, pacManFutureY);
        }
        else if (dir == Direction.RIGHT) {
            return !maze.isWallAt(pacManFutureX+1, pacManFutureY);
        }
        else if (dir == Direction.UP) {
            return !maze.isWallAt(pacManFutureX, pacManFutureY-1);
        }
        else {
            return !maze.isWallAt(pacManFutureX, pacManFutureY+1);
        }
    }

    /**
     * Sets the direction of the pacMan to the direction pressed
     * 
     * @param direction
     */
    private void setWaitingDirection(Direction direction) {
        this.waitingDirection = direction;
    }

    /**
     * Updates the pacMan direction at the right time.
     * @param nanoTime
     */
    public void update(long nanoTime) {
        if (this.waitingDirection != null) {
            float x = this.pacMan.getX();
            float y = this.pacMan.getY();
            double varriance = 0.1;
    
            // The position is at an integer position within a varraince
            if (Math.abs(x-Math.round(x)) < varriance && 
                Math.abs(y-Math.round(y)) < varriance ) {
                    this.changeDirection();
            }
        }
        this.pacMan.move();
    }

    /**
     * Changes the direction of the pacMan to the waiting direction
     */
    private void changeDirection() {
        this.pacMan.stop();

        if (this.waitingDirection == Direction.UP) {
            this.pacMan.up();
        }
        else if (this.waitingDirection == Direction.LEFT) {
            this.pacMan.left();
        }
        else if (this.waitingDirection == Direction.DOWN) {
            this.pacMan.down();
        }
        else if (this.waitingDirection == Direction.RIGHT) {
            this.pacMan.right();
        }

        this.waitingDirection = null;
    }
}
