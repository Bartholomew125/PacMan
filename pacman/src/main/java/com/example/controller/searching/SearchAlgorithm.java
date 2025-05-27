package com.example.controller.searching;

import java.util.Stack;

import com.example.model.Pos2D;

public interface SearchAlgorithm {
    public Stack<Pos2D> getMoveStack();
    public Node search();
    public void setStart(Pos2D pos);
    public void setGoal(Pos2D pos);
}