package com.example.model.states;

/**
 * PowerState
 */
public class PowerState extends State {

    /**
     * Creates powerstate where Ghosts are edible and and afraid, whilst PacMan
     * can't be eaten.
     * Initializes EndState width:
     *  - ghostIsAfraid := false
     *  - ghostMovemenMultiplier := 0
     *  - ghostIsEdible := false
     *  - pacManIsEdible := false
     *  - pacManMovementmultiplier := 0
     */
    public PowerState() {
        super(true, 0.04, true, false, 0.06);
    }
}
