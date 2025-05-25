package com.example.model;

import java.util.ArrayList;
import java.util.List;

import com.example.model.states.State;

public class Game {

    private Maze maze;
    private PacMan pacMan;
    private List<Pill> smallPills;
    private List<Pill> largePills;
    private ArrayList<Ghost> ghosts;
    private int score;
    private int lives;

    public Game() {
        // Create maze
        this.maze = new Maze();

        // Create pacMan
        Pos2D pos = this.maze.locatePacMan();
        this.pacMan = new PacMan(pos.getX(), pos.getY());

        // Create small pills
        Pos2D[] smallPillPositions = this.maze.locateSmallPills();
        this.smallPills = new ArrayList<Pill>();
        for (int i = 0; i < smallPillPositions.length; i++) {
            this.smallPills.add(new SmallPill(smallPillPositions[i].getX(),
                    smallPillPositions[i].getY()));
        }

        // Create large pills
        Pos2D[] largePillPositions = this.maze.locateLargePills();
        this.largePills = new ArrayList<Pill>();
        for (int i = 0; i < largePillPositions.length; i++) {
            this.largePills.add(new LargePill(largePillPositions[i].getX(),
                    largePillPositions[i].getY()));
        }

        // Create ghosts
        Pos2D[] ghostPositions = this.maze.locateGhosts();
        Class<?>[] availableGhosts = {GhostGreen.class,  GhostMint.class, GhostOrange.class, GhostPink.class};
        this.ghosts = new ArrayList<Ghost>();
        for (int i = 0; i < ghostPositions.length; i++) {
            try {
                Ghost ghost = (Ghost) availableGhosts[i%availableGhosts.length]
                .getConstructor(float.class, float.class)
                .newInstance(ghostPositions[i].getX(), ghostPositions[i].getY());     
                ghosts.add(ghost);               
            }
            catch (Exception e) {
                e.getStackTrace();
            }
        }

        this.score = 0;
        this.lives = 3;
    }

    /**
     * Make pacMan eat a pill.
     * 
     * @param pill
     */
    public void pacManEatSmallPill(Pill pill) {
        this.increaseScore(pill.getValue());
        this.smallPills.remove(pill);
    }

    /**
     * Make pacMan eat a large pill.
     * 
     * @param pill
     */
    public void pacManEatLargePill(Pill pill) {
        this.increaseScore(pill.getValue());
        this.largePills.remove(pill);
    }

    /**
     * Make pacMan eat ghost.
     * @param ghost
     */
    public void pacManEatGhost(Ghost ghost) {
        this.increaseScore(20);
        this.ghosts.remove(ghost);
    }
    
    /**
     * Decrease score when pacman collides with ghost in NormalState.
     */
    public void ghostEatsPacman(){
        this.decreaseLives();
    }
    /**
     * Increasee score by some value.
     * 
     * @param value
     */
    public void increaseScore(int value) {
        this.score = this.score + value;
    }

    /**
     * @return The maze of the game
     */
    public Maze getMaze() {
        return this.maze;
    }

    /**
     * @return The pacMan of the game
     */
    public PacMan getPacMan() {
        return this.pacMan;
    }

    /**
     * @return A pointer to the array of small pills int the game.
     */
    public List<Pill> getSmallPills() {
        return this.smallPills;
    }

    /**
     * @return A pointer to the array of large pills int the game.
     */
    public List<Pill> getLargePills() {
        return this.largePills;
    }

    /**
     * @return A a array copy of the small pills.
     */
    public Pill[] getSmallPillsArray() {
        return this.smallPills.toArray(new Pill[this.smallPills.size()]);
    }

    /**
     * @return A a array copy of the large pills.
     */
    public Pill[] getLargePillsArray() {
        return this.largePills.toArray(new Pill[this.largePills.size()]);
    }

    public int getScore() {
        return this.score;
    } 

    public ArrayList<Ghost> getGhosts(){ 
        return this.ghosts;
    } 

    
    /**
     * Get the lives.
     * @return lives 
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Decrease lives.
     */
    public void decreaseLives(){
        this.lives--;
    }

    /**
     * Set state for ghosts.
     * @param state
     */
    public void setState(State state) {
        pacMan.setIsEdible(state.getPacManIsEdible());
        pacMan.setMovementMultiplier(state.getPacManMovementmultiplier());

        for (int i = 0; i < ghosts.size(); i++) {
            this.ghosts.get(i).setIsEdible(state.getGhostIsEdible());
            this.ghosts.get(i).setIsAfraid(state.getGhostIsAfraid());
            this.ghosts.get(i).setMovementMultiplier(state.getGhostMovementMultiplier());
        }
    }

    public void resetPositions() {
        // Reset pacman
        this.pacMan.resetPosition();

        for (Ghost g : this.ghosts) {
            g.resetPosition();
        }
    }
    
}

