package com.example;

/**
 * State interface
 */
public interface State {
    public void setGhostPath();

    public void setGhostSprite();

    public void setGhostEtableState();

    public void setPacmanEtableState();

    public void setStateDuration();
}
