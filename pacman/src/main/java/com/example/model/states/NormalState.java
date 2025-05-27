package com.example.model.states;

/**
 * NormalState which is game state.
 */
public class NormalState extends State {
    
    /**
     *
     *
     * */

   /**
    * Creates a Normalstate ensuring ghosts can't be eaten whilst PacMan can. 
    * Initializes NormalState with:
    *   - ghostIsAfraid := false
    *   - ghostMovemenMultiplier := 0.06
    *   - ghostIsEdible := false
    *   - pacManIsEdible := true 
    *   - pacManMovementmultiplier := 0.06
    */ 
    public NormalState() {
        super(false, 0.06, false, true, 0.06);
    }
}
