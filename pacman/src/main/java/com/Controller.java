package com;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    
    PacMan pacman;

    public Controller(PacMan pacman) {
        this.pacman = pacman;
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