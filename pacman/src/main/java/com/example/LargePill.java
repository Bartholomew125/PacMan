package com.example;

/**
 * The implementation of the Large Pill which makes pacman able to eat ghosts.
 */
public class LargePill extends Pill {

    public LargePill(float x, float y) {
        this.size = 20;
        this.value = 50;
        this.x = x;
        this.y = y;
    } 

    public LargePill newLargePill(){ 
        return new LargePill(x, y);
    } 

    public LargePill newPowerUp(){ 
        LargePill powerup = new LargePill(x,y); 
        powerup.getPowerUp(); 
        return powerup;

    } 

    public void getPowerUp(){ 
        long ptime = System.currentTimeMillis(); 
        //TO DO: Figure out timer for powerup mode



    }
}
