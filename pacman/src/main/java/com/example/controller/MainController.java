package com.example.controller;

import java.util.Random;

import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.PacMan;
import com.example.model.Pill;
import com.example.model.PowerState;
import com.example.model.Wall;
import com.example.view.Viewer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * The controller class which is responsible for controlling the pacMan and
 * making him move in the right way.
 */
public class MainController implements Controller{

    private PacManController pacManController;
    private StateController stateController;
    private Viewer viewer;
    private Game game;
    private long previousNanoTime;
    private long currentNanoTime;
    private final double nanosecondsPerFrame;

    public MainController(Game game, Viewer viewer, int fps) {
        this.game = game;
        this.viewer = viewer;
        this.previousNanoTime = System.nanoTime();

        // The framerate of the game
        this.nanosecondsPerFrame = Math.pow(10, 9) / fps;

        this.pacManController = new PacManController(this.game.getPacMan(), this.game.getMaze());
        this.stateController = new StateController(this.game);
    }

    /**
     * Handles keypresses from the scene
     * 
     * @param event
     */
    public void handleKeyPress(KeyEvent event) {
        this.pacManController.handleKeyPress(event);
    }

    /**
     * Update everything in the maze
     */
    public void update(long nanoTime) {
        this.currentNanoTime = nanoTime;

        if (this.currentNanoTime - this.previousNanoTime >= this.nanosecondsPerFrame) {
            this.previousNanoTime = currentNanoTime;

            this.pacManController.update(nanoTime);

            this.handleCollisions();
            this.stateController.update(nanoTime);

            // Move stuff
            for (Ghost g : game.getGhosts()) {
                g.move();
            }
            this.game.getPacMan().move();
            this.viewer.render(nanoTime);
        
        }
    }

    /**
     * Handle the collisions of the game
     */
    private void handleCollisions() {

        PacMan pacMan = this.game.getPacMan();
        Wall[] walls = this.game.getMaze().getWalls();
        Pill[] smallPills = this.game.getSmallPillsArray();
        Pill[] largePills = this.game.getLargePillsArray(); 

        // Collision with walls
        for (Wall wall : walls) {
            // PacMan
            if (wall.distanceTo(pacMan) < 1) {
                pacMan.stop();
            }
            // Ghosts
            for (Ghost g : this.game.getGhosts()) {
                if (wall.distanceTo(g) < 1) {
                    g.stop();
                    dummyPath(g);
                    g.move();
                }
            }
        }

        for (Pill pill : smallPills) {
            if (pill.distanceTo(pacMan) < 0.5) {
                this.game.pacManEatSmallPill(pill);
                System.out.println(this.game.getScore());
            }
        }

        for (Pill pill : largePills) {
            if (pill.distanceTo(pacMan) < 0.8) {
                this.game.pacManEatLargePill(pill);
                this.stateController.setState(new PowerState());
                System.out.println(this.game.getScore());
            }
        }  
    }  

    public void dummyPath(Ghost ghost){ 
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

    public void moreRandomPath(Ghost ghost){ 
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), ae -> choice(ghost)));   
        timeline.setCycleCount(-1); 
        timeline.setDelay(Duration.millis(1));
        timeline.playFromStart();

    } 

    public void choice(Ghost ghost){ 
        Random rd = new Random(); 
        char[] directions = {'O', 'V','N','H'};
        char newPath = directions[rd.nextInt(4)]; 
        if (newPath == 'O'){ 
            ghost.up();
        } 
        if (newPath== 'V'){ 
            ghost.left(); 
        } 
        if (newPath == 'N'){ 
            ghost.down(); 
        } 
        if (newPath== 'H'){ 
            ghost.right();
        }  
        
    }
}
