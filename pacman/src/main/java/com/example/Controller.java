package com.example;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    
    Maze maze;
    PacMan pacman;

    public Controller(Maze maze) {
        this.maze = maze;
        this.pacman = maze.getPacMan();
    }

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