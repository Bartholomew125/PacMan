package com.example.controller.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.Maze;
import com.example.model.PacMan;
import com.example.model.Pos2D;

public abstract class AbstractSearchAlgorithm implements SearchAlgorithm{
    
    private final Maze maze; 
    private final PacMan pacMan;
    private final Ghost ghost;
    private final Pos2D startPos;
    private final Pos2D goalPos;

    public AbstractSearchAlgorithm(Game game, Ghost ghost) {
        this.maze = game.getMaze();
        this.pacMan = game.getPacMan();
        this.ghost = ghost;
        this.startPos = new Pos2D((int)(this.getGhost().getX()),(int)(this.getGhost().getY()));
        this.goalPos = new Pos2D((int)(this.getPacMan().getX()), (int)(this.getPacMan().getY()));

    }

    @Override
    public Stack<Pos2D> getMoveStack() {
        // Build the path and return immediately
        Stack<Pos2D> moveStack = new Stack<>();
        Node goalNode = this.search();
        while (goalNode.getParent() != null) {
            moveStack.push(goalNode.getPos());
            goalNode = goalNode.getParent();
        }
        return moveStack;
    }

    public ArrayList<Pos2D> getNeighbours(Pos2D pos) {
        ArrayList<Pos2D> neighbours = new ArrayList<>();

        //choice directions hardcoded into a list
        ArrayList<Pos2D> cDir = new ArrayList<>();  
        Pos2D up = new Pos2D(0, -1); 
        Pos2D down = new Pos2D(0, 1); 
        Pos2D right = new Pos2D(1,0); 
        Pos2D left = new Pos2D(-1, 0);
        cDir.add(up); 
        cDir.add(down); 
        cDir.add(left);     
        cDir.add(right); 

        // Shuffle the direction to ensure better ghost movement
        Collections.shuffle(cDir);

        //Checking if possible moves
        for (Pos2D dir : cDir) {
            Pos2D newPos = pos.add(dir);
            int x = newPos.getX(); 
            int y = newPos.getY();
            if (x >= 0 && x < this.maze.getWidth() && y >= 0 && y < this.maze.getHeight() &&
            !this.maze.isWallAt(newPos.getX(), newPos.getY())) {
                neighbours.add(newPos);
            }
        }
        return neighbours;
    }

    protected Maze getMaze() {
        return this.maze;
    }

    protected PacMan getPacMan() {
        return this.pacMan;
    }

    protected Ghost getGhost() {
        return this.ghost;
    }

    protected Pos2D getStartPos() {
        return this.startPos;
    }

    protected Pos2D getGoalPos() {
        return this.goalPos;
    }
}
