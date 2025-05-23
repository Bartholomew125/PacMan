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
    private Game game;
    private State currentState; 
    
    public StateController(Game game){
        this.powerStateStartTime = 0;
        this.game = game;
        this.currentState = new NormalState();
    }

    public void update(long nanoTime){
        if (this.currentState instanceof PowerState) {
            if (nanoTime - this.powerStateStartTime >= 15000000000L){
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
            this.currentState = state;
            game.setState(state);
        }
        else if (state instanceof DeadState) {
            this.currentState = state;
            game.setState(state);
            game.resetPositions();
        }
    }

    public State getState() {
        return this.currentState;
    }

}
