package nmm;

import java.awt.*;

/**
 * An abstract class that facilitates the moves a player
 * can make while playing the game.
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public abstract class Action{

    protected Player player; //player who must perform the action
    protected Boolean complete; //whether or not the action is complete
    protected Game game;
    protected Intersection finalIntersection; //final intersection of the complete action

    /**
     * constructor for Action object
     */
    public Action(Player player, Game game) {
        this.game = game;
        this.player = player;
        complete = false;
    }

    @Override
    public abstract String toString();

    /**
     * updates the current action given a player input
     *
     * @param p     the player input
     */
    public abstract void updateAction(Point p);

    /**
     * not currently implemented
     */
    public abstract void runAIAction();

    /**
     * undoes a completed action resetting what had
     * happened
     */
    public abstract void undo();

    /**
     * returns the player object associated with
     * the action
     *
     * @return player   The player who owns the action
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * returns whether or not the action is complete
     *
     * @return complete     a boolean flag which specifies if the action
     *                      is complete or not
     */
    public Boolean isComplete() {
        return complete;
    }

    /**
     * returns the final intersection of the action
     *
     * @return finalIntersection   The final intersection of the move
     */
    public Intersection getFinalIntersection() {
        return finalIntersection;
    }
}
