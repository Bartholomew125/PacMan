package com.example.controller;

import com.example.model.State;
import com.example.model.PowerState;
import com.example.model.DeadState;
import com.example.model.Game;
import com.example.model.NormalState;

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
        }
    }

    public State getState() {
        return this.currentState;
    }

}
