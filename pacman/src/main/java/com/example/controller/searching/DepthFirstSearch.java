package com.example.controller.searching;

import java.util.ArrayList;
import java.util.Stack;

import com.example.model.Maze;
import com.example.model.Pos2D;

public class DepthFirstSearch extends AbstractSearchAlgorithm {

    public DepthFirstSearch(Maze maze) {
        super(maze);
    }
    
    /**
     * Calculates the move tree and returns the goal node where pacman is.
     * @param ghost
     * @return
     */
    @Override
    public Node search(){ 
        //At the start ghost has no children and no parent
        Node root = new Node(this.getStartPos());

        // Add the root to the stack
        Stack<Node> stack = new Stack<>();
        stack.push(root); 


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
        visited.add(root.getPos());

        //As long as the stack is not empty and pacman is not found
        //We pop elements 
        while (!stack.isEmpty()){ 
            Node currentNode = stack.pop();
            if (currentNode.getPos().equals(this.getGoalPos())){ 
                return currentNode;
            }  
            //We create a new Node and add it as a child of the previous Node 
            //Then we set the previous Node as a parent
            for (Pos2D pos : getNeighbours(currentNode.getPos())){
                if (!visited.contains(pos)){ 
                    Node newNode = new Node(pos);
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

        // If no path found, return the root
        return root;
    } 
}
