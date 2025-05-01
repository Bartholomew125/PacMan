package com.example;

/**
 * The implementation of the Small Pill.
 */
public class SmallPill extends Pill{ 


    public SmallPill(int x, int y) {
        super(x, y, 10, 10);
    }  



    public SmallPill newSmallPill(){  
        SmallPill smallp = new SmallPill(x,y); 
        smallp.getSize(); 
        smallp.getValue(); 
        return smallp;

    }  


}
