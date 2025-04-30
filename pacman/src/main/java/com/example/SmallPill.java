package com.example;

/**
 * The implementation of the Small Pill.
 */
public class SmallPill extends Pill{ 


    public SmallPill(float x, float y) {
        this.size = 10;
        this.value = 10;
        this.x = x;
        this.y = y;
    }  



    public SmallPill newSmallPill(){  
        SmallPill smallp = new SmallPill(x,y); 
        smallp.getSize(); 
        smallp.getValue(); 
        return smallp;

    }  


}
