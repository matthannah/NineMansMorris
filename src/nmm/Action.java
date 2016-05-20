package nmm;

import java.awt.*;

/**
 * Created by Matt on 5/05/2016.
 */
public abstract class Action{

    protected Player player;
    protected Boolean complete;
    protected Game game;
    protected Intersection finalIntersection;

    public Action(Player player, Game game) {
        this.game = game;
        this.player = player;
        complete = false;
    }

    @Override
    public abstract String toString();

    public abstract void updateAction(Point p);

    public abstract void runAIAction();

    public abstract void undo();

    public Player getPlayer() {
        return player;
    }

    public Boolean isComplete() {
        return complete;
    }

    public Intersection getFinalIntersection() {
        return finalIntersection;
    }
}
