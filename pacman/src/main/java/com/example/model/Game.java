package com.example.model;

import java.util.ArrayList;

public class Game {

    private Maze maze;
    private PacMan pacman;
    private ArrayList<Pill> smallPills;
    private ArrayList<Pill> largePills;
    private Ghost[] ghosts;
    private int score;
    private int lives;

    public Game() {
        // Create maze
        this.maze = new Maze();

        // Create pacman
        Pos2D pos = this.maze.locatePacman();
        this.pacman = new PacMan(pos.getX(), pos.getY());
        this.pacman.setMovementMultiplier(0.1);

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
        this.ghosts = new Ghost[ghostPositions.length];
        for (int i = 0; i < ghostPositions.length; i++) {
            this.ghosts[i] = new BGhost(ghostPositions[i].getX(),
                    ghostPositions[i].getY());
        }

        this.score = 0;
        this.lives = 3;
    }

    /**
     * Make pacman eat a pill.
     * 
     * @param pill
     */
    public void pacmanEatSmallPill(Pill pill) {
        this.increaseScore(pill.getValue());
        this.smallPills.remove(pill);
    }

    /**
     * Make pacman eat a large pill.
     * 
     * @param pill
     */
    public void pacmanEatLargePill(Pill pill) {
        this.increaseScore(pill.getValue());
        this.largePills.remove(pill);
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
     * @return The pacman of the game
     */
    public PacMan getPacMan() {
        return this.pacman;
    }

    /**
     * @return A pointer to the array of small pills int the game.
     */
    public ArrayList<Pill> getSmallPills() {
        return this.smallPills;
    }

    /**
     * @return A pointer to the array of large pills int the game.
     */
    public ArrayList<Pill> getLargePills() {
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

    public Ghost[] getGhosts(){ 
        return this.ghosts;
    } 

    public Ghost getOneGhost(){ 
        return this.ghosts[0];
    } 



    public int getLives() {
        return this.lives;
    }

    public void setState(State state) {
        pacman.isEdible = state.pacmanIsEdible;

        for (int i = 0; i < ghosts.length; i++) {
            this.ghosts[i].setIsEdible(state.ghostIsEdible);
            this.ghosts[i].setIsAfraid(state.ghostIsAfraid);
            this.ghosts[i].setMovementMultiplier(state.ghostMovementMultiplier);
        }
    }
}

