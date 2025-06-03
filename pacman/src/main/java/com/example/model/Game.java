package com.example.model;

import java.util.ArrayList;
import java.util.List;

import com.example.controller.TextualMaze;
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
    private TextualMaze textualMaze;
    private PacMan pacMan;
    private List<Pill> smallPills;
    private List<Pill> largePills;
    private List<Ghost> ghosts;
    private int score;
    private int lives;

    /**
     * Create and place game-objects.
     */
    public Game() {
        // Create maze
        this.textualMaze = new TextualMaze();
        this.maze = new Maze(this.textualMaze.getWidth(), this.textualMaze.getHeight(), this.textualMaze.getWallPositions());

        // Create pacMan
        Pos2D pos = this.textualMaze.getPacManPosition();
        this.pacMan = new PacMan(pos.getX(), pos.getY());

        this.smallPills = new ArrayList<Pill>();
        this.largePills = new ArrayList<Pill>();
        this.ghosts = new ArrayList<>();

        this.initializeComponents();
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
    public void ghostEatPacMan() {
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

    public List<Ghost> getGhosts() {
        return this.ghosts;
    }

    public int getLives() {
        return this.lives;
    }

    /**
     * Decrease lives.
     */
    public void decreaseLives() {
        this.lives--;
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
        this.pacMan.right();
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
        this.initializeComponents();
    }

    public void initializeComponents() {
        Pos2D[] smallPillPositions = this.textualMaze.getSmallPillPositions();
        for (int i = 0; i < smallPillPositions.length; i++) {
            this.smallPills.add(new SmallPill(smallPillPositions[i].getX(),
                    smallPillPositions[i].getY()));
        }

        Pos2D[] largePillPositions = this.textualMaze.getLargePillPositions();
        for (int i = 0; i < largePillPositions.length; i++) {
            this.largePills.add(new LargePill(largePillPositions[i].getX(),
                    largePillPositions[i].getY()));
        }

        Pos2D[] ghostPositions = this.textualMaze.getGhostPositions();
        Class<?>[] options = new Class<?>[]{BreadthFirstSearch.class, DepthFirstSearch.class};
        for (Pos2D pos : ghostPositions) {
            int index = (int) (Math.random()*options.length);
            SearchAlgorithm sa = new BreadthFirstSearch();
            try {
                sa = (SearchAlgorithm) options[index].getConstructor().newInstance();
            }
            catch (Exception e) {}

            this.ghosts.add(new Ghost(pos.getX(), pos.getY(), Color.hsb(Math.random()*255, 1, 1, 1), sa));
        }

        this.score = 0;
        this.lives = 3;
    }

}
