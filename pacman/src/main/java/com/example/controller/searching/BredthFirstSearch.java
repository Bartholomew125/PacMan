package com.example.controller.searching;

import java.util.ArrayList;
import java.util.LinkedList;

import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.Pos2D;

public class BredthFirstSearch extends AbstractSearchAlgorithm{
    
    public BredthFirstSearch(Game game, Ghost ghost) {
        super(game, ghost);
    }

    @Override
    public Node search() {
         //At the start ghost has no children and no parent
        Node root = new Node(this.getStartPos());

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
        queue.add(root); 
        
        while (!queue.isEmpty()){ 
            Node currentNode = queue.remove();
            if (!visited.contains(currentNode.getPos())){ 
                visited.add(currentNode.getPos());
            } 
            if (currentNode.getPos().equals(this.getGoalPos())){ 
                return currentNode;
            }  
            for (Pos2D pos : getNeighbours(currentNode.getPos())){
                if (!visited.contains(pos)){ 
                    Node newNode = new Node(pos);
                    // add newnode as child to currentNode
                    currentNode.addChild(newNode);
                    // add currentNode as parent to newnode
                    newNode.setParent(currentNode); 
                    // add newnode to queue
                    queue.add(newNode);
                }
            }         
        } 
        return root;
    }
}
