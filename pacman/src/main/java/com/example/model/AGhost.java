package com.example.model;

import java.util.PriorityQueue;
import java.util.Stack;

import javafx.scene.paint.Color;

public class AGhost extends Ghost { 

    public AGhost(float x, float y){ 
        super(x, y, 0, 0, 1, Color.RED);
    }  


    public static class Info{ 
        double value; 
        int i; 
        int j; 
        public Info(double value, int i, int j){ 
            this.i = i; 
            this.j = j; 
            this.value = value;
        }
    } 

    public static class Node{ 
        public Pos2D parent; 
        public double f,g,h;
        Node(){ 
            parent = new Pos2D(-1, -1); 
            f = -1; 
            g = -1; 
            h = -1; 
        }

        public Node(Pos2D parent, double f, double g, double h){ 
            this.parent = parent; 
            this.f = f; 
            this.g = g; 
            this.h = h;
        }
    }


    private boolean isValid(Integer[][]aigrid, int row, int col, Pos2D pos){ 

        if (row > 0 && col > 0 ){ 
            return (pos.getX() >= 0) && (pos.getX() < row) 
            && (pos.getY() >= 0) && (pos.getY() < col);
        } 
        return false;
    } 

    private boolean Blocked(Integer[][]aigrid, int row, int col, Pos2D pos){ 
        return isValid(aigrid, row, col, pos) && aigrid[pos.getX()][pos.getY()] == 1;
    }

    double euclideanDistance(Pos2D start, Pos2D goal){    
        return Math.sqrt(Math.pow(goal.getX()-start.getX(), 2) + Math.pow(goal.getY() - start.getY(), 2));
     } 

    private void trackPath(Node[][] nodedetails, int rows, int cols, Pos2D goal){
        Stack<Pos2D> path = new Stack<>(); 
        int row = goal.getX(); 
        int col = goal.getY(); 

        Pos2D nextPosition = nodedetails[row][col].parent;
        do { 
            path.push((new Pos2D(row,col))); 

        } while(nodedetails[row][col].parent != nextPosition);

        while(!path.isEmpty()){ 
            Pos2D peek = path.peek(); 
            path.pop();
        }


    } 
    private void aStarSearch(Node[][] griddetails, int rows, int cols, Pos2D start, Pos2D goal){ 
        boolean[][] visited = new boolean[rows][cols]; 
        Node[][] nodedetails = new Node[rows][cols]; 
        int i,j; 
        i = start.getX(); 
        j = start.getY(); 
        nodedetails[i][j] = new Node(); 
        nodedetails[i][j].f = 0.0; 
        nodedetails[i][j].h = 0.0; 
        nodedetails[i][j].g = 0.0; 
        nodedetails[i][j].parent = new Pos2D(i, j); 

        // implementing priority queue 

        PriorityQueue<Node> newNodes = new PriorityQueue<>();
        

    }


     void startUp(){ 
        Pos2D start = new Pos2D(1, 1); 
        
        //TO DO: Real goal
        //Pacman pacman = new PacMan(dx, dy);
        //Pos2D goal = new Pos2D(pacman); 

        Pos2D fakegoal = new Pos2D(10,10);
     }

    
}
