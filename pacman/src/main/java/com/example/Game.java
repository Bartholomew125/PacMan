package com.example;

public class Game {

    private Maze maze;
    private PacMan pacman;
    private Pill[] smallPills;
    private Pill[] largePills;
    private Ghost[] ghosts;

    public Game() {
        // Create maze
        this.maze = new Maze();

        // Create pacman
        Pos2D pos = this.maze.locatePacman();
        this.pacman = new PacMan(pos.getX(), pos.getY());
        this.pacman.setMovementMultiplier(0.1);

        // Create small pills
        Pos2D[] smallPillPositions = this.maze.locateSmallPills();
        this.smallPills = new Pill[smallPillPositions.length];
        for (int i = 0; i < smallPillPositions.length; i++) {
            this.smallPills[i] = new SmallPill(smallPillPositions[i].getX(),
                                               smallPillPositions[i].getY());
        }

        // Create large pills
        Pos2D[] largePillPositions = this.maze.locateLargePills();
        this.largePills = new Pill[largePillPositions.length];
        for (int i = 0; i < largePillPositions.length; i++) {
            this.largePills[i] = new LargePill(largePillPositions[i].getX(),
                                               largePillPositions[i].getY());
        }

        // Create ghosts
        Pos2D[] ghostPositions = this.maze.locateGhosts();
        this.ghosts = new Ghost[ghostPositions.length];
        for (int i = 0; i < ghostPositions.length; i++) {
            this.ghosts[i] = new AGhost(ghostPositions[i].getX(),
                                        ghostPositions[i].getY());
        }
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
     * @return The small pills of the game
     */
    public Pill[] getSmallPills() {
        return this.smallPills;
    }

}
