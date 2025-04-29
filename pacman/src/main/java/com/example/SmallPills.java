package com.example;

/**
 * The implementation of the Small Pill.
 */
public class SmallPills extends Pill{ 


    public SmallPills(float x, float y) {
        this.size = 10;
        this.value = 10;
        this.x = x;
        this.y = y;
    }  



    public SmallPills newSmallPill(){  
        SmallPills smallp = new SmallPills(x,y); 
        smallp.getSize(); 
        smallp.getValue(); 
        return smallp;

    }  


}
