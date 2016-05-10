package nmm;

import java.awt.*;

/**
 * Created by Matt on 5/05/2016.
 */
public abstract class Action{

    private Player player;
    private Boolean complete;
    private Game game;
    private Intersection finalIntersection;

    public Action(Player player, Game game) {
        this.game = game;
        this.player = player;
        complete = false;
    }

    public void start(Board board) {
        if (getPlayer().isHuman()) {
            getPlayer().setTurn(true);
        } else {
            runAIAction();
        }
    }

    public abstract void updateAction(Point p);

    public abstract void runAIAction();

    public abstract void undo();

    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Boolean isComplete() {
        return complete;
    }

    public Intersection getFinalIntersection() {
        return finalIntersection;
    }

    public void setFinalIntersection(Intersection finalIntersection) {
        this.finalIntersection = finalIntersection;
    }
}
