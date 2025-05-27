package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.controller.searching.BreadthFirstSearch;
import com.example.controller.searching.DepthFirstSearch;
import com.example.controller.searching.SearchAlgorithm;
import com.example.model.states.State;

import javafx.scene.paint.Color;

/**
 * The instance of the game that represents the 'PacMan game'.
 */
public class Game {

    private Maze maze;
    private PacMan pacMan;
    private List<Pill> smallPills;
    private List<Pill> largePills;
    private ArrayList<Ghost> ghosts;
    private int score;
    private int lives;
    private SearchAlgorithm searchAlgorithm;
    private Stack<Pos2D> moveStack;

    /**
     * Create and place game-objects.
     */
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
        this.ghosts = new ArrayList<>();
        this.ghosts.add(new Ghost(ghostPositions[0].getX(), ghostPositions[0].getY(), Color.GREEN, new DepthFirstSearch(this.maze)));
        this.ghosts.add(new Ghost(ghostPositions[1].getX(), ghostPositions[1].getY(), Color.BLUE, new BreadthFirstSearch(this.maze)));
        this.ghosts.add(new Ghost(ghostPositions[2].getX(), ghostPositions[2].getY(), Color.RED, new BreadthFirstSearch(this.maze)));
        this.ghosts.add(new Ghost(ghostPositions[3].getX(), ghostPositions[3].getY(), Color.PINK, new DepthFirstSearch(this.maze)));

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
     * 
     * @param ghost
     */
    public void pacManEatGhost(Ghost ghost) {
        this.increaseScore(20);
        this.ghosts.remove(ghost);
    }

    /**
     * Decrease score when pacman collides with ghost in NormalState.
     */
    public void ghostEatsPacman() {
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

    public Maze getMaze() {
        return this.maze;
    }

    public PacMan getPacMan() {
        return this.pacMan;
    }

    /**
     * Get pointer to array which contains small pills.
     *
     * @return A pointer to the array of small pills int the game.
     */
    public List<Pill> getSmallPills() {
        return this.smallPills;
    }

    /**
     * Get pointer to array which contains large pills.
     * 
     * @return A pointer to the array of large pills in the game.
     */
    public List<Pill> getLargePills() {
        return this.largePills;
    }

    /**
     * Get smallPills as array.
     * 
     * @return A a array copy of the small pills.
     */
    public Pill[] getSmallPillsArray() {
        return this.smallPills.toArray(new Pill[this.smallPills.size()]);
    }

    /**
     * Get largePills as array.
     * 
     * @return A a array copy of the large pills.
     */
    public Pill[] getLargePillsArray() {
        return this.largePills.toArray(new Pill[this.largePills.size()]);
    }

    public int getScore() {
        return this.score;
    }

    public ArrayList<Ghost> getGhosts() {
        return this.ghosts;
    }

    public int getLives() {
        return this.lives;
    }

    public SearchAlgorithm getSearchAlgorithm() {
        return this.searchAlgorithm;
    }

    /**
     * Decrease lives.
     */
    public void decreaseLives() {
        this.lives--;
    }

    public Stack<Pos2D> getMoveStack() {
        return this.moveStack;
    }

    /**
     * Applies state on game.
     * 
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

    /**
     * Resets Moveables postions.
     */
    public void resetPositions() {
        this.pacMan.resetPosition();
        for (Ghost g : this.ghosts) {
            g.resetPosition();
        }
    }

    /**
     * Restarts game.
     */
    public void restart() {
        this.resetPositions();
        this.ghosts.clear();
        this.smallPills.clear();
        this.largePills.clear();

        Pos2D[] smallPillPositions = this.maze.locateSmallPills();
        for (int i = 0; i < smallPillPositions.length; i++) {
            this.smallPills.add(new SmallPill(smallPillPositions[i].getX(),
                    smallPillPositions[i].getY()));
        }

        Pos2D[] largePillPositions = this.maze.locateLargePills();
        for (int i = 0; i < largePillPositions.length; i++) {
            this.largePills.add(new LargePill(largePillPositions[i].getX(),
                    largePillPositions[i].getY()));
        }

        Pos2D[] ghostPositions = this.maze.locateGhosts();
        this.ghosts.add(new Ghost(ghostPositions[0].getX(), ghostPositions[0].getY(), Color.GREEN, new DepthFirstSearch(this.maze)));
        this.ghosts.add(new Ghost(ghostPositions[1].getX(), ghostPositions[1].getY(), Color.BLUE, new BreadthFirstSearch(this.maze)));
        this.ghosts.add(new Ghost(ghostPositions[2].getX(), ghostPositions[2].getY(), Color.RED, new BreadthFirstSearch(this.maze)));
        this.ghosts.add(new Ghost(ghostPositions[3].getX(), ghostPositions[3].getY(), Color.PINK, new DepthFirstSearch(this.maze)));

        this.score = 0;
        this.lives = 3;
    }

}
