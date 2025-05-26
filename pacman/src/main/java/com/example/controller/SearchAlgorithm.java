package com.example.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import com.example.model.Direction;
import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.Maze;
import com.example.model.PacMan;
import com.example.model.Pos2D;

public class SearchAlgorithm {
    private Maze maze; 
    private Game game;


    public SearchAlgorithm(Game game){ 
        this.game = game;
        this.maze = game.getMaze();
    }
    
    
    public Stack<Pos2D> DFS(Ghost ghost){ 
        //Adding ghost and Pacman
        PacMan pacman = this.game.getPacMan();
        //Adding ghost position, children and parent at the start
        Pos2D gPos = new Pos2D((int)(ghost.getX()),(int)(ghost.getY()));
        //At the start ghost has no children and no parent
        Node gstart = new Node(null, gPos);

        //Set goal as Pacman
        Pos2D goal = new Pos2D((int)(pacman.getX()), (int)(pacman.getY()));

        //Add ghost position to stack
        Stack<Node> stack = new Stack<>();
        stack.push(gstart); 


        ArrayList<Pos2D> visited = new ArrayList<>(){
            @Override
            public boolean contains(Object o) {
                Pos2D p = (Pos2D) o;
                for (Pos2D pos : this) {
                    if (p.getX() == pos.getX() && p.getY() == pos.getY()) {
                        return true;
                    }
                }
                return false;
            }
        };
        visited.add(gstart.getPos());
        //As long as the stack is not empty and pacman is not found
        //We pop elements 
        while (!stack.isEmpty()){ 
            //System.out.println(stack.size());
            Node currentNode = stack.pop();
            //System.out.println(currentNode.getPos().toString());
            if (currentNode.getPos().equals(goal)){ 
                // Build the path and return immediately
                Stack<Pos2D> moveStack = new Stack<>();
                Node pathNode = currentNode;
                while (pathNode.getParent() != null) {
                    moveStack.push(pathNode.getPos());
                    pathNode = pathNode.getParent();
                }
                return moveStack;
            }  

            //We create a new Node and add it as a child of the previous Node 
            //Then we set the previous Node as a parent
            for (Pos2D pos : getNeighbours(currentNode.getPos())){
                if (!visited.contains(pos)){ 
                    Node newNode = new Node(null, pos);
                    // add newnode as child to currentNode
                    currentNode.addChild(newNode);
                    // add currentNode as parent to newnode
                    newNode.setParent(currentNode); 
                    // push newnode to stack
                    stack.push(newNode);
                    visited.add(pos);
                }            
            }
        } 

        // If no path found, return empty stack
        return new Stack<>();
    } 

    public LinkedList<Pos2D> BFS(Ghost ghost){ 
        PacMan pacman = this.game.getPacMan();
        Pos2D gPos = new Pos2D((int)(ghost.getX()),(int)(ghost.getY()));
        
         //At the start ghost has no children and no parent
        Node gstart = new Node(null, gPos);

        //Set goal as Pacman
        Pos2D goal = new Pos2D((int)(pacman.getX()), (int)(pacman.getY()));

        ArrayList<Pos2D> visited = new ArrayList<>(){
            @Override
            public boolean contains(Object o) {
                Pos2D p = (Pos2D) o;
                for (Pos2D pos : this) {
                    if (p.getX() == pos.getX() && p.getY() == pos.getY()) {
                        return true;
                    }
                }
                return false;
            }
        };

        LinkedList<Node> queue = new LinkedList<>(); 
        queue.add(gstart); 
        
        while (!queue.isEmpty()){ 
            Node currentNode = queue.remove();
            if (!visited.contains(currentNode.getPos())){ 
                visited.add(currentNode.getPos());
            } 
            if (currentNode.getPos().equals(goal)){ 
                LinkedList<Pos2D> moveQueue = new LinkedList<>();
                Node pathNode = currentNode;
                while (pathNode.getParent()!=null){ 
                    moveQueue.addFirst(pathNode.getPos()); 
                    pathNode = pathNode.getParent();
                } 
                return moveQueue;
            } 
            for (Pos2D pos : getNeighbours(currentNode.getPos())){
                if (!visited.contains(pos)){ 
                    Node newNode = new Node(null, pos);
                    // add newnode as child to currentNode
                    currentNode.addChild(newNode);
                    // add currentNode as parent to newnode
                    newNode.setParent(currentNode); 
                    // add newnode to queue
                    queue.add(newNode);
                }
            }         
        } 
        return new LinkedList<>();
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
}
