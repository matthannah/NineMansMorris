package nmm;

import java.awt.*;

/**
 * Created by Matt on 5/05/2016.
 */
public class Place extends Action {

    public Place(Player player, Game game) {
        super(player, game);
    }

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
        }
    }

    @Override
    public void undo() {
        complete = false;
        player.removeToken(finalIntersection);
        player.decrementPlacedCount();
        if(player.tokensPlaced()) {
            player.setTokensPlaced(false);
        }
        finalIntersection = null;
        game.notifyActionUpdate();
    }

    @Override
    public void runAIAction() {

    }

    @Override
    public String toString() {
        return "PLACE";
    }
}
