package com.example.controller;

import com.example.model.State;
import com.example.model.PowerState;
import com.example.model.Game;
import com.example.model.NormalState;

/**
 * StateController
 */
public class StateController {
    private long powerStateStartTime;
    private Game game;

    public void checkValidPowerstate(State state) {
        if (state instanceof PowerState) {
            game.setState(state);
        }
    }

    public void checkValidNormalstate(State state) {
        if (state instanceof NormalState) {
            game.setState(state);
        }
    }
}
