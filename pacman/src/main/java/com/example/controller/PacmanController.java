package com.example.controller;

import com.example.model.Direction;
import com.example.model.Maze;
import com.example.model.PacMan;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PacmanController {
    
    private PacMan pacman;
    private Maze maze;
    private Direction waitingDirection;

    public PacmanController(PacMan pacman, Maze maze) {
        this.pacman = pacman;
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
        // Check if pacman i standing still
        if (this.pacman.getDirection() == null) {
            pacman.setDirection(dir);
        }
        // Check if pacman i moving in the opposite direction
        else if (this.pacman.getDirection() == DirectionAdapter.opposite(dir)) {
            pacman.setDirection(dir);
        }
        // Check if there is a passage in the direction pressed
        else if (isPassage(dir)){
            this.setWaitingDirection(dir);
        }
        // Any other case
        else {
            pacman.setDirection(dir);
        }
    }

    /**
     * Checks if there is a passage further ahead in the direction pressed
     * 
     * @param dir
     * @return true if there is a passage, false otherwise
     */
    private boolean isPassage(Direction dir) {
        int pacmanFutureX;
        int pacmanFutureY;
        // Case 1
        if (this.pacman.getDirection() == Direction.UP || this.pacman.getDirection() == Direction.LEFT) {
            pacmanFutureX = (int) this.pacman.getX();
            pacmanFutureY = (int) this.pacman.getY();
        }
        // Case 2
        else {
            pacmanFutureX = (int) this.pacman.getX() + (int) this.pacman.getDX();
            pacmanFutureY = (int) this.pacman.getY() + (int) this.pacman.getDY();
        }
        if (dir == Direction.LEFT) {
            return !maze.isWallAt(pacmanFutureX-1, pacmanFutureY);
        }
        else if (dir == Direction.RIGHT) {
            return !maze.isWallAt(pacmanFutureX+1, pacmanFutureY);
        }
        else if (dir == Direction.UP) {
            return !maze.isWallAt(pacmanFutureX, pacmanFutureY-1);
        }
        else {
            return !maze.isWallAt(pacmanFutureX, pacmanFutureY+1);
        }
    }

    /**
     * Sets the direction of the pacman to the direction pressed
     * 
     * @param direction
     */
    private void setWaitingDirection(Direction direction) {
        this.waitingDirection = direction;
    }

    /**
     * Updates the pacman direction at the right time.
     * @param nanoTime
     */
    public void update(long nanoTime) {
        if (this.waitingDirection != null) {
            float x = this.pacman.getX();
            float y = this.pacman.getY();
            double varriance = 0.1;
    
            // The position is at an integer position within a varraince
            if (Math.abs(x-Math.round(x)) < varriance && 
                Math.abs(y-Math.round(y)) < varriance ) {
                    this.changeDirection();
            }
        }
    }

    /**
     * Changes the direction of the pacman to the waiting direction
     */
    private void changeDirection() {
        this.pacman.stop();

        if (this.waitingDirection == Direction.UP) {
            this.pacman.up();
        }
        else if (this.waitingDirection == Direction.LEFT) {
            this.pacman.left();
        }
        else if (this.waitingDirection == Direction.DOWN) {
            this.pacman.down();
        }
        else if (this.waitingDirection == Direction.RIGHT) {
            this.pacman.right();
        }

        this.waitingDirection = null;
    }
}
