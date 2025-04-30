package com.example;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The controller class which is responsible for controlling the pacman and
 * making him move in the right way.
 */
public class Controller {

    private View view;
    private Game game;
    private long previousNanoTime;
    private long currentNanoTime;
    private final double nanosecondsPerFrame;

    public Controller(Game game, View view, int fps) {
        this.game = game;
        this.view = view;
        this.previousNanoTime = System.nanoTime();

        // The framerate of the game
        this.nanosecondsPerFrame = Math.pow(10, 9) / fps;
    }

    /**
     * Handles keypresses from the scene
     * 
     * @param event
     */
    public void handleKeyPress(KeyEvent event) {
        KeyCode key = event.getCode();
        PacMan pacman = this.game.getPacMan();
        if (key == KeyCode.LEFT) {
            pacman.left();
        }
        if (key == KeyCode.RIGHT) {
            pacman.right();
        }
        if (key == KeyCode.UP) {
            pacman.up();
        }
        if (key == KeyCode.DOWN) {
            pacman.down();
        }
    }

    /**
     * Update everything in the maze
     */
    public void update(long nanoTime) {
        this.currentNanoTime = nanoTime;

        if (this.currentNanoTime
                - this.previousNanoTime >= this.nanosecondsPerFrame) {
            System.out.println("hello");
            this.previousNanoTime = currentNanoTime;
            this.handleCollisions();

            this.game.getPacMan().move();
            this.view.render();
        }
    }

    /**
     * Handle the collisions of the game
     */
    private void handleCollisions() {

        PacMan pacman = this.game.getPacMan();
        for (Wall wall : this.game.getMaze().getWalls()) {
            if (wall.distanceTo(pacman.getX(),
                    pacman.getY()) < 1) {
                pacman.stop();
            }
        }

    }
}