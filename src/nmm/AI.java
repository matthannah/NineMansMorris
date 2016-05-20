package nmm;

/**
 * A type of player, AI, facilitates the artifical intelligence
 * of the computer player when in a game. This class will provide
 * moves depending on the difficulty and the state of the game
 *
 * -----not implemented------
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class AI extends Player {

    /**
     * @inheritDoc
     */
    public AI(String name) {
        super(name);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void placeToken(Intersection intersection) {

    }

    /**
     * @inheritDoc
     */
    @Override
    public void removeToken(Intersection intersection) {

    }

    /**
     * @inheritDoc
     */
    @Override
    public void moveToken(Intersection startIntersection, Intersection finalIntersection) {

    }

    @Override
    public String toString() {
        return name;
    }
}
