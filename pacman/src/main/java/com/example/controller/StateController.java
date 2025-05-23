package com.example.controller;

import com.example.model.states.DeadState;
import com.example.model.states.NormalState;
import com.example.model.states.PowerState;
import com.example.model.states.State;
import com.example.model.Game;

/**
 * StateController
 */
public class StateController implements Controller{
    private long powerStateStartTime;
    private long deadStateStartTime;
    private Game game;
    private State currentState; 
    private final long nanosecPerSec = 1000000000L;
    
    public StateController(Game game){
        this.powerStateStartTime = 0;
        this.game = game;
        this.currentState = new NormalState();
    }

    public void update(long nanoTime){
        if (this.currentState instanceof PowerState) {
            if (nanoTime - this.powerStateStartTime >= 15*this.nanosecPerSec){
                this.setState(new NormalState());
            }
        }
        else if (this.currentState instanceof DeadState) {
            if (nanoTime - this.deadStateStartTime >= 3*this.nanosecPerSec) {
                this.game.resetPositions();
                this.setState(new NormalState());
            }
        }
    }

    public void setState(State state) {
        this.currentState = state;
        if (state instanceof PowerState) {
            this.powerStateStartTime = System.nanoTime();
            game.setState(state);
        }
        else if (state instanceof NormalState) {
            game.setState(state);
        }
        else if (state instanceof DeadState) {
            this.deadStateStartTime = System.nanoTime();
            game.setState(state);
        }
    }

    public State getState() {
        return this.currentState;
    }

}
