package com.example.model.states;

/**
 * Endstate which is a game state.
 */
public class EndState extends State {
    
   /**
    * Initializes EndState width:
    *   - ghostIsAfraid := false
    *   - ghostMovemenMultiplier := 0
    *   - ghostIsEdible := false
    *   - pacManIsEdible := false
    *   - pacManMovementmultiplier := 0
    */ 
    public EndState() {
        super(false, 0, false, false, 0);
    }

}
