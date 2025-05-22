package com.example.controller;

import java.lang.foreign.AddressLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.Maze;
import com.example.model.Moveable;
import com.example.model.PacMan;
import com.example.model.Pill;
import com.example.model.Pos2D;
import com.example.model.Wall;
import com.example.view.Viewer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.css.Size;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration; 
import java.util.Map;

/**
 * The controller class which is responsible for controlling the pacMan and
 * making him move in the right way.
 */
public class Controller {

    private PacManController pacManController;

    private Viewer viewer;
    private Game game;
    private long previousNanoTime;
    private long currentNanoTime;
    private final double nanosecondsPerFrame;

    public Controller(Game game, Viewer viewer, int fps) {
        this.game = game;
        this.viewer = viewer;
        this.previousNanoTime = System.nanoTime();

        // The framerate of the game
        this.nanosecondsPerFrame = Math.pow(10, 9) / fps;

        this.pacManController = new PacManController(this.game.getPacMan(), this.game.getMaze());
    }

    /**
     * Handles keypresses from the scene
     * 
     * @param event
     */
    public void handleKeyPress(KeyEvent event) {
        this.pacManController.handleKeyPress(event);
    }

    /**
     * Update everything in the maze
     */
    public void update(long nanoTime) {
        this.currentNanoTime = nanoTime;

        if (this.currentNanoTime - this.previousNanoTime >= this.nanosecondsPerFrame) {
            this.previousNanoTime = currentNanoTime;

            this.pacManController.update(nanoTime);

            this.handleCollisions();

            // Move stuff
            for (Ghost g : game.getGhosts()) {
                g.move();
            }
            this.game.getPacMan().move();
            this.viewer.render(nanoTime);
        }
    }

    /**
     * Handle the collisions of the game
     */
    private void handleCollisions() {

        PacMan pacMan = this.game.getPacMan();
        Wall[] walls = this.game.getMaze().getWalls();
        Pill[] smallPills = this.game.getSmallPillsArray();
        Pill[] largePills = this.game.getLargePillsArray(); 

        // Collision with walls
        for (Wall wall : walls) {
            // PacMan
            if (wall.distanceTo(pacMan) < 1) {
                pacMan.stop();
            }
            // Ghosts
            for (Ghost g : this.game.getGhosts()) {
                if (wall.distanceTo(g) < 1) {
                    g.stop();
                    dummyPath(g);
                    g.move();
                }
            }
        }

        for (Pill pill : smallPills) {
            if (pill.distanceTo(pacMan) < 0.5) {
                this.game.pacManEatSmallPill(pill);
                System.out.println(this.game.getScore());
            }
        }

        for (Pill pill : largePills) {
            if (pill.distanceTo(pacMan) < 0.8) {
                this.game.pacManEatLargePill(pill);
                System.out.println(this.game.getScore());
            }
        }  
    }  

    public void dummyPath(Ghost ghost){ 
        Random rd = new Random(); 
        char[] directions = {'O', 'V','N','H'};
        char newPath = directions[rd.nextInt(4)];

        if (newPath == 'O'){ 
            ghost.up();
        } 
        if (newPath == 'V'){ 
            ghost.left();
        } 
        if (newPath == 'N'){ 
            ghost.down(); 
        } 
        if (newPath == 'H'){ 
            ghost.right();
        }

    } 

    public void moreRandomPath(Ghost ghost){ 
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), ae -> choice(ghost)));   
        timeline.setCycleCount(-1); 
        timeline.setDelay(Duration.millis(1));
        timeline.playFromStart();

    } 

    public void choice(Ghost ghost){ 
        Random rd = new Random(); 
        char[] directions = {'O', 'V','N','H'};
        char newPath = directions[rd.nextInt(4)]; 
        if (newPath == 'O'){ 
            ghost.up();
        } 
        if (newPath== 'V'){ 
            ghost.left(); 
        } 
        if (newPath == 'N'){ 
            ghost.down(); 
        } 
        if (newPath== 'H'){ 
            ghost.right();
        }  
        
    } 

    public ArrayList<Pos2D> path(Pos2D current,  ArrayList<Pos2D> laststep){ 
        ArrayList<Pos2D> totalpath = new ArrayList<Pos2D>(); 
        for (Pos2D i : laststep) {
            current = laststep.get(laststep.size()-1);
            totalpath.add(current);
        } 
        return totalpath;

    } 

    public void logic(Ghost g, PacMan goal, int cost){ 
        goal = this.game.getPacMan();
        Pos2D realgoal = new Pos2D(Math.round(goal.getX()), Math.round(goal.getY()));
        Maze maze = this.game.getMaze();
        ArrayList<Pos2D> camefrom = new ArrayList<Pos2D>();

        ArrayList<Integer> goalScore = new ArrayList<Integer>(); 
        goalScore.add(0);
        cost = 0; 

        ArrayList<Integer> fullScore = new ArrayList<Integer>(); 
        fullScore.add(cost);

        Pos2D curr = new Pos2D (Math.round(g.getX()),Math.round(g.getY())); 
        PriorityQueue<Pos2D> q = new PriorityQueue<>(); 
        q.add(curr); 
        
        Map<Pos2D, Integer> explored = new HashMap<>();
        explored.put(curr, 0);

        while (!q.isEmpty()){ 
            curr = q.poll();
            if (curr == realgoal){ 
                path(curr, camefrom);
            } 
            q.remove(curr); 
        }      

        Pos2D calcNeighbours = new Pos2D(curr.getX(),curr.getY()); 
        getAvailableNeigbours(calcNeighbours);
        Map<Pos2D, Pos2D> neighbours = new HashMap<>(); 
        neighbours.put(calcNeighbours, calcNeighbours);

        for (Map.Entry<Pos2D, Pos2D> entry : neighbours.entrySet()) {
            int newCost = explored.get(new Pos2D(curr.getX(), curr.getY()));
            Pos2D nextPos = entry.getValue(); 
            if (nextPos != null && maze.IsWallAt() != true && explored.containsKey(nextPos)){ 
                explored.put(nextPos, newCost);
            } 

            double prio = newCost + distanceToGoal(goal); 

            Pos2D neighbourPos = new Pos2D(entry.getKey().getX(), entry.getKey().getY()); 
            
            q.add(neighbourPos); 
            camefrom.add(neighbourPos);
            
        }

    

    } 
    
    public ArrayList<Pos2D> getAvailableNeigbours(Pos2D pos){  
        ArrayList<Pos2D> neighbourlist = new ArrayList<Pos2D>();
        Maze maze = this.game.getMaze(); 
        for (Pos2D elem : neighbourlist) { 
            if (elem != null && maze.isWallAt(elem.getX(),elem.getY()) != true){ 
                neighbourlist.add(elem);
            }
        }  
        return neighbourlist;
    } 

    public double distanceToGoal(PacMan pacman){
        Ghost[] g = this.game.getGhosts();
        int x = Math.round(g[g.length].getX()); 
        int y = Math.round(g[g.length].getY());
        return Math.sqrt(Math.pow(pacman.getX() - x, 2) + Math.pow(pacman.getY() - y, 2));
    }

}
