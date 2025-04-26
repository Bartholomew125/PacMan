package com.example;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The controller class which is responsible for controlling the pacman and
 * making him move in the right way.
 */
public class Controller {

    Maze maze;
    PacMan pacman;

    public Controller(Maze maze) {
        this.maze = maze;
        this.pacman = maze.getPacMan();
    }

    /**
     * Handles keypresses from the scene
     * @param event
     */
    public void handleKeyPress(KeyEvent event) {
        KeyCode key = event.getCode();

        if (key == KeyCode.LEFT) {
            this.pacman.left();
        }
        if (key == KeyCode.RIGHT) {
            this.pacman.right();
        }
        if (key == KeyCode.UP) {
            this.pacman.up();
        }
        if (key == KeyCode.DOWN) {
            this.pacman.down();
        }
    }
}