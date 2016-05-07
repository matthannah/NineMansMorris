package nmm;

import java.awt.*;

/**
 * Created by Matt on 5/05/2016.
 */
public abstract class Action{

    private Player player;
    private Boolean isComplete;
    private Game game;

    public Action(Player player, Game game) {
        this.game = game;
        this.player = player;
        isComplete = false;
    }

    public abstract void start(Board board);

    public abstract void updateAction(Point p);

    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    public void setComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }
}
