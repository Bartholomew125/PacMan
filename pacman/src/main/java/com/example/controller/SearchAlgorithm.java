package com.example.controller;

import java.util.Stack;
import com.example.model.Pos2D;

public interface SearchAlgorithm {
    public Stack<Pos2D> getMoveStack();
    public Node search();
}