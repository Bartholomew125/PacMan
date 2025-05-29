package com.example.controller;

import com.example.model.states.*;
import com.example.model.Game;

/**
 * StateController for controlling states of the game.
 */
public class StateController implements Controller {

    private long powerStateStartTime;
    private long deadStateStartTime;
    private final Game game;
    private State currentState;
    private final long nanosecPerSec = 1000000000L;

    /**
     * Initializes a new StateController.
     * 
     * @param game
     */
    public StateController(Game game) {
        this.powerStateStartTime = 0;
        this.game = game;
        this.currentState = new NormalState();
    }

    @Override
    public void update(long nanoTime) {
        if (this.currentState instanceof PowerState) {
            if (nanoTime - this.powerStateStartTime >= 8 * this.nanosecPerSec) {
                this.setState(new NormalState());
            }
        } else if (this.currentState instanceof DeadState) {
            if (nanoTime - this.deadStateStartTime >= 1 * this.nanosecPerSec) {
                this.game.resetPositions();
                this.setState(new NormalState());
            }
        }
    }
    /**
     * Sets the state of the game.
     * 
     * @param state
     */
    public void setState(State state) {
        this.currentState = state;
        if (state instanceof PowerState) {
            this.powerStateStartTime = System.nanoTime();
            game.setState(state);
        } else if (state instanceof NormalState) {
            game.setState(state);
        } else if (state instanceof DeadState) {
            this.deadStateStartTime = System.nanoTime();
            game.setState(state);
        } else if (state instanceof EndState) {
            game.setState(state);
        }
    }

    public State getState() {
        return this.currentState;
    }

}
