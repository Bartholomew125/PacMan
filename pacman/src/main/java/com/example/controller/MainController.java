package com.example.controller;

import java.util.ArrayList;
import java.util.Random;

import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.PacMan;
import com.example.model.Pill;
import com.example.model.Wall;
import com.example.model.states.DeadState;
import com.example.model.states.EndState;
import com.example.model.states.NormalState;
import com.example.model.states.PowerState;
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

    public MainController(Game game, Viewer viewer) {
        this.game = game;
        this.viewer = viewer;
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

    /**
     * Handle the collisions of the game
     */
    private void handleCollisions() {

        PacMan pacMan = this.game.getPacMan();
        Wall[] walls = this.game.getMaze().getWalls();
        Pill[] smallPills = this.game.getSmallPillsArray();
        Pill[] largePills = this.game.getLargePillsArray();
        ArrayList<Ghost> ghosts = this.game.getGhosts(); 

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
            }
        }

        for (Pill pill : largePills) {
            if (pill.distanceTo(pacMan) < 0.8) {
                this.game.pacManEatLargePill(pill);
                this.stateController.setState(new PowerState());
            }
        }
        
        // Handle collision between pacman and ghosts
        int numGhosts = ghosts.size(); // To make sure size of array dosent change when removing ghost
        for (int i = 0; i < numGhosts; i++) {
            if (ghosts.get(i).distanceToMoveable(pacMan) < 0.5){
                if (stateController.getState() instanceof PowerState){
                    this.game.pacManEatGhost(ghosts.get(i));
                    numGhosts--;
                }
                else if (stateController.getState() instanceof NormalState){
                    this.game.ghostEatsPacman();
                    if (this.game.getLives() > 0) {
                        this.stateController.setState(new DeadState());
                    }
                    else {
                        this.stateController.setState(new EndState());
                    }
                }
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
