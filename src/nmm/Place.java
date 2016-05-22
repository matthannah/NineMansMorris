package nmm;

import java.awt.*;

/**
 * A place action that places a players token onto an empty intersection
 * on the board
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class Place extends Action {

    /**
     * @inheritDoc
     */
    public Place(Player player, Game game) {
        super(player, game);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void updateAction(Point p) {
        //get the intersection that the user has clicked
        Intersection intersectionSelected = game.getBoard().getIntersection(p);

        //if the intersection if empty place the token
        if (intersectionSelected.isEmpty()) {
            finalIntersection = intersectionSelected;
            complete = true;
            player.placeToken(finalIntersection);
            game.notifyActionUpdate();
        } else {
            game.notifyInvalidMove();
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void undo() {
        complete = false;
        player.removeToken(finalIntersection);
        player.decrementPlacedCount();
        if(player.tokensPlaced()) {
            player.setTokensPlaced(false);
        }
        player.getTokens().remove(player.getTokenCount()-1);
        finalIntersection = null;
        game.notifyActionUpdate();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void runAIAction() {

    }

    @Override
    public String toString() {
        return "PLACE";
    }
}
