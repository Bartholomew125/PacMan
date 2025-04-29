package com.example;

public class AGhost extends Ghost { 
    private Float[][] aigrid = new Float[20][20]; 
    private AGhost ghost;
    private float start,goal;

    public AGhost(float x, float y){ 
        this.x = x; 
        this.y = y; 


    }  

    public void CreateGhost(){ 
        ghost = new AGhost(x, y);
        ghost.getInfo(); 
        
    } 

    public void getInfo(){ 

        //starting float point for the ai
        this.start = aigrid[5][5]; 

        
        //goal float point for the ai
        //TO DO: figure out how to implement a tracker for pacman
        this.goal =  aigrid[10][10];
        
        this.aigrid = aigrid;


        //path for the ai
        /*Float[][] path = getgrid(aigrid, start, goal);  

        if (path != null && aigridsize() > 0){ 
            MoveGhost(ghost, new Point2D(y+1, x+1));
        }*/  

    } 

    public int aigridsize(){ 
        return aigrid.length;
    } 

    public void getgrid(){ 


    }

    
}
