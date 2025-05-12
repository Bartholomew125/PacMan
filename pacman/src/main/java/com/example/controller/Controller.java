package com.example.controller;

import java.util.Random;

import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.PacMan;
import com.example.model.Pill;
import com.example.model.Wall;
import com.example.view.Viewer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * The controller class which is responsible for controlling the pacman and
 * making him move in the right way.
 */
public class Controller {

    private Viewer view;
    private Game game;
    private long previousNanoTime;
    private long currentNanoTime;
    private final double nanosecondsPerFrame;

    public Controller(Game game, Viewer view, int fps) {
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

        if (this.currentNanoTime - this.previousNanoTime >= this.nanosecondsPerFrame) {
            this.previousNanoTime = currentNanoTime;

            this.handleCollisions();

            // Move stuff
            for (Ghost g : game.getGhosts()) {
                g.move();
            }
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
        Pill[] largePills = this.game.getLargePillsArray(); 

        // Collision with walls
        for (Wall wall : walls) {
            // Pacman
            if (wall.distanceTo(pacman) < 1) {
                pacman.stop();
            }
            // Ghosts
            for (Ghost g : this.game.getGhosts()) {
                if (wall.distanceTo(g) < 1) {
                    g.stop();
                    SmartPath(g);
                    g.move();
                }
            }
        }

        for (Pill pill : smallPills) {
            if (pill.distanceTo(pacman) < 0.5) {
                this.game.pacmanEatSmallPill(pill);
                System.out.println(this.game.getScore());
            }
        }

        for (Pill pill : largePills) {
            if (pill.distanceTo(pacman) < 0.8) {
                this.game.pacmanEatLargePill(pill);
                System.out.println(this.game.getScore());
            }
        }  
    }  

    public void DummyPath(Ghost ghost){ 
        Random rd = new Random(); 
        char[] directions = {'O', 'V','N','H'};
        char newPath = directions[rd.nextInt(4)];

        if (newPath == 'O'){ 
            ghost.up();
        } 
        if (newPath == 'V'){ 
            ghost.left();
        } 
        if (newPath == 'N'){ 
            ghost.down(); 
        } 
        if (newPath == 'H'){ 
            ghost.right();
        }

    } 

    public void MoreRandomPath(Ghost ghost){ 
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), ae -> Choice(ghost)));   
        timeline.setCycleCount(-1); 
        timeline.play();

    } 

    public void Choice(Ghost g){ 
        Random rd = new Random(); 
        char[] directions = {'O', 'V','N','H'};
        char newPath = directions[rd.nextInt(4)]; 
        if (newPath == 'O'){ 
            g.up();
        } 
        if (newPath== 'V'){ 
            g.left(); 
        } 
        if (newPath == 'N'){ 
            g.down(); 
        } 
        if (newPath== 'H'){ 
            g.right();
        }  
        
    }  

    public void SmartPath(Ghost g){ 
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3),ae -> Rational(g)));
        timeline.setCycleCount(-1); 
        timeline.play();


        } 

    public void Rational(Ghost g){ 
        PacMan target = this.game.getPacMan(); 

        if (g.getX()<target.getX()){ 
            g.right();
        } 
        if (g.getDX()>target.getX()){ 
            g.left();
        }/*  
        if (g.getDY()<target.getY()){ 
            g.up();
        } 
        if (g.getDY()<target.getY()){ 
            g.down();
        }*/

    }

    

}
