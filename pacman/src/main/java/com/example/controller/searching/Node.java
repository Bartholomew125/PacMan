package com.example.controller.searching;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Pos2D;

/**
 * The node which is used in search trees to search.
 */
public class Node {
    private Node parent;
    private Pos2D pos;
    private List<Node> children;

    /**
     * Creates a new dangling node with a position-value.
     * 
     * @param pos
     */
    public Node(Pos2D pos) {
        this.parent = null;
        this.pos = pos;
        this.children = new ArrayList<>();
    }

    public Node getParent() {
        return this.parent;
    }

    public Pos2D getPos() {
        return this.pos;
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    /**
     * Adds node to it's children.
     * 
     * @param node
     */
    public void addChild(Node node) {
        this.children.add(node);
    }
}
