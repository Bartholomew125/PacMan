package com.example.controller;

import java.util.List;

import javafx.scene.input.KeyEvent;

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

/**
 * The controller class which is responsible for controlling the pacMan and
 * making him move in the right way.
 */
public class MainController implements Controller {

    private PacManController pacManController;
    private GhostController ghostController;
    private StateController stateController;
    private Viewer viewer;
    private Game game;
    private SoundController soundController;

    /**
     * Creates a new MainController.
     *
     * @param game
     * @param viewer
     */
    public MainController(int maxWidth, int maxHeight){
        this.game = new Game();
        this.viewer = new Viewer(maxWidth, maxHeight, this.game, this);
        this.pacManController = new PacManController(this.game.getPacMan(), this.game.getMaze());
        this.ghostController = new GhostController(this.game.getGhosts(), this.game.getPacMan(), this.game.getMaze());
        this.stateController = new StateController(this.game);
        this.soundController = new SoundController();
        this.soundController.playChompSound();
    }

    /**
     * Handles keypresses from the scene
     * 
     * @param event
     */
    public void handleKeyPress(KeyEvent event) {
        if (this.stateController.getState() instanceof EndState) {

        } else if (!(this.stateController.getState() instanceof DeadState)) {
            this.pacManController.handleKeyPress(event);
        }
    }

    /**
     * Update everything in the maze
     */
    public void update(long nanoTime) {
        this.pacManController.update(nanoTime);
        this.ghostController.update(nanoTime);
        this.stateController.update(nanoTime);
        this.soundController.update(nanoTime);
        this.handleCollisions();
        this.viewer.render(nanoTime);
    }
    
    /**
     * Restarts game and sets state to NormalState.
     */
    public void restart() {
        this.game.restart();
        this.stateController.setState(new NormalState());
        this.viewer.showEndView(false);
        this.soundController.startPlaying();
    }

    /**
     * Handle the collisions of the game
     */
    private void handleCollisions() {

        PacMan pacMan = this.game.getPacMan();
        Wall[] walls = this.game.getMaze().getWalls();
        Pill[] smallPills = this.game.getSmallPillsArray();
        Pill[] largePills = this.game.getLargePillsArray();
        List<Ghost> ghosts = this.game.getGhosts();

        // Collision with walls
        for (Wall wall : walls) {
            // PacMan
            if (Algebra.distanceBetween(wall, pacMan) < 1) {
                pacMan.stop();
            }
        }
        
        // Check for collisions between smallPills and pacMan.
        for (Pill pill : smallPills) {
            if (Algebra.distanceBetween(pill, pacMan) < 0.5) {
                this.game.pacManEatSmallPill(pill);
            }
        }
        
        // Check for collisions between largePills and pacMan.
        for (Pill pill : largePills) {
            if (Algebra.distanceBetween(pill, pacMan) < 0.8) {
                this.game.pacManEatLargePill(pill);
                this.stateController.setState(new PowerState());
                this.ghostController.clearMoveStacks();
            }
        }

        // Handle collision between pacman and ghosts
        int numGhosts = ghosts.size(); // To make sure size of array dosent change when removing ghost
        for (int i = 0; i < numGhosts; i++) {
            if (Algebra.distanceBetween(ghosts.get(i), pacMan) < 0.5) {
                if (stateController.getState() instanceof PowerState) {
                    this.game.pacManEatGhost(ghosts.get(i));
                    numGhosts--;
                    this.soundController.playEatGhostSound();
                } else if (stateController.getState() instanceof NormalState) {
                    this.game.ghostEatPacMan();
                    if (this.game.getLives() > 0) {
                       this.stateController.setState(new DeadState());
                       this.soundController.playDeathSound();
                    } else {
                        this.stateController.setState(new EndState());
                        this.soundController.playWompWompSound();
                        this.viewer.showEndView(true);
                    }
                }
            }
        }
    }
    
    public Viewer getViewer(){
        return this.viewer;
    }
}
