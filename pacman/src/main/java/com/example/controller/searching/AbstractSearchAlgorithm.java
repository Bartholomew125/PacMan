package com.example.controller.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import com.example.model.Maze;
import com.example.model.Moveable;
import com.example.model.Pos2D;

public abstract class AbstractSearchAlgorithm implements SearchAlgorithm{
    
    private final Maze maze; 
    private Pos2D startPos;
    private Pos2D goalPos;

    public AbstractSearchAlgorithm(Maze maze) {
        this.maze = maze;
    }

    @Override
    public void setGoal(Pos2D pos) {
        this.goalPos = pos;
    }

    public void setGoal(Moveable m) {
        Pos2D pos = new Pos2D((int) m.getX(), (int) m.getY());
        this.setGoal(pos);
    }

    @Override
    public void setStart(Pos2D pos) {
        this.startPos = pos;
    }

    public void setStart(Moveable m) {
        Pos2D pos = new Pos2D((int) m.getX(), (int) m.getY());
        this.setStart(pos);
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

    protected Pos2D getStartPos() {
        return this.startPos;
    }

    protected Pos2D getGoalPos() {
        return this.goalPos;
    }

}
