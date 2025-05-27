package com.example.model.states;

/**
 * DeadState which is a game state.
 */
public class DeadState extends State{
    
   /**
    * Initializes DeadState with:
    *   - ghostIsAfraid := false
    *   - ghostMovemenMultiplier := 0
    *   - ghostIsEdible := false
    *   - pacManIsEdible := false
    *   - pacManMovementmultiplier := 0
    */ 
    public DeadState(){
        super(false, 0, false, false, 0);
    }
    
}
