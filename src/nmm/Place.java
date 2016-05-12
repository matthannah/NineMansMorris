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
        Intersection intersectionSelected = getGame().getBoard().getIntersection(p);
        if (intersectionSelected.isEmpty()) {
            setFinalIntersection(intersectionSelected);
            setComplete(true);
            System.out.println("Placed token at " + getFinalIntersection().getPoint().getX() + ", " + getFinalIntersection().getPoint().getY());
            getPlayer().placeToken(getFinalIntersection());
            getGame().notifyActionUpdate();
        }
    }

    @Override
    public void undo() {
        setComplete(false);
        getPlayer().removeToken(getFinalIntersection());
        getPlayer().decrementPlacedCount();
        if(getPlayer().tokensPlaced()) {
            getPlayer().setTokensPlaced(false);
        }
        getGame().notifyActionUpdate();
    }

    @Override
    public void runAIAction() {

    }

    @Override
    public String toString() {
        return "PLACE";
    }
}
