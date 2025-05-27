package com.example.controller;

import java.util.ArrayList;

import com.example.model.Pos2D; 



public class Node {
    private Node parent; 
    private Pos2D pos;
    private ArrayList<Node> children;
    
    public Node(Pos2D pos){ 
        this.parent = null; 
        this.pos = pos; 
        this.children = new ArrayList<>();   
    }  



    public Node getParent(){ 
        return this.parent;
    } 

    public Pos2D getPos(){ 
        return this.pos; 
    } 

    public ArrayList<Node> getChildren(){ 
        return this.children;
    } 

    public void setParent(Node node){ 
        this.parent = node;
    } 

    public void addChild(Node node){ 
        this.children.add(node);

    }


}
