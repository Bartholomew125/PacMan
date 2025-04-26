package com.example;

public abstract class Moveable {

    protected float x;
    protected float y;
    protected float dx;
    protected float dy;
    protected float movementMultiplier;
    

    /**
     * Moves moveable depending on movementmultiplier and direction.
     */
    public void move() {
        this.x += this.dx * movementMultiplier;
        this.y += this.dy * movementMultiplier;
    }

    /**
     * Moves movable left.
     */
    public void left() {
        this.dx = -1;
        this.dy = 0;
    }

    /**
     * Moves moveable to the right.
     */
    public void right(){
        this.dx = 1;
        this.dy = 0;
    }

    /**
     * Moves moveable down.
     */
    public void down(){
        this.dx = 0;
        this.dy = 1;
    }

    /**
     * Moves moveable up.
     */
    public void up(){
        this.dx = 0;
        this.dy = -1;
    }

    /**
     * @return moveables x-value. 
     */
    public float getX(){
        return this.x;
    }


    /**
     * @return moveables y-value.
     */
    public float getY(){
        return this.y;
    }

    /**
     * Sets moveables movementmultiplier.
     * @param multiplier
     */
    public void setMovementMultiplier(float multiplier){
        this.movementMultiplier = multiplier;
    }
}

