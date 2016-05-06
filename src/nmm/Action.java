package nmm;

/**
 * Created by Matt on 5/05/2016.
 */
public abstract class Action{

    private Player player;

    public Action(Player player) {
        this.player = player;
    }

    public abstract void run(Board board);


}
