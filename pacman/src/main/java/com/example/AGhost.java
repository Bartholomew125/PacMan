package com.example;

import java.nio.file.Path;
import java.util.ArrayList;

public class AGhost extends Ghost { 
    private Integer[][] aigrid = new Integer[20][20]; 
    private AGhost ghost;
    private ArrayList<Integer> start,goal;

    public AGhost(float x, float y){ 
        super(x, y, 0, 0, 1, new Color("red"));
    }  

    public void CreateGhost(){ 
        ghost = new AGhost(x, y);
        ghost.getInfo(); 
        
    } 

    private void getInfo(){ 


        //path for the ai
        ArrayList<Pos2D> path = new ArrayList<Pos2D>(); 
        for (int i = 0; i < aigridsize(); i++) {

            
        }

        
            
        



    } 

    public int aigridsize(){ 
        return aigrid.length;
    } 

    public boolean visited(){ 
        return false;



    }

    
}
