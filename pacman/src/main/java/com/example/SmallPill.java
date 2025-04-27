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
        return new SmallPill(x,y);
    }  

    public void Attributes(SmallPill smallp){ 
        smallp.getSize(); 
        smallp.getValue(); 
    }  

}
