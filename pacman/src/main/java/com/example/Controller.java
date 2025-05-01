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
            this.view.getPacmanAnimation().setRotation(180);
        }
        if (key == KeyCode.RIGHT) {
            pacman.right();
            this.view.getPacmanAnimation().setRotation(0);
        }
        if (key == KeyCode.UP) {
            pacman.up();
            this.view.getPacmanAnimation().setRotation(-90);
        }
        if (key == KeyCode.DOWN) {
            pacman.down();
            this.view.getPacmanAnimation().setRotation(90);
        }
    }

    /**
     * Update everything in the maze
     */
    public void update(long nanoTime) {
        this.currentNanoTime = nanoTime;

        if (this.currentNanoTime
                - this.previousNanoTime >= this.nanosecondsPerFrame) {
            this.previousNanoTime = currentNanoTime;
            this.handleCollisions();

            this.game.getPacMan().move();
            this.view.render(nanoTime);
        }
    }

    /**
     * Handle the collisions of the game
     */
    private void handleCollisions() {

        PacMan pacman = this.game.getPacMan();
        Wall[] walls = this.game.getMaze().getWalls();
        Pill[] smallPills = this.game.getSmallPillsArray();


        for (Wall wall : walls) {
            if (wall.distanceTo(pacman) < 1) {
                pacman.stop();
            }
        }

        for (Pill pill : smallPills) {
            if (pill.distanceTo(pacman) < 1) {
                this.game.pacmanEatSmallPill(pill);
                System.out.println(this.game.getScore());
            }
        }

    }
}