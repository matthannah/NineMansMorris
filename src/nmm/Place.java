package nmm;

import java.awt.*;

/**
 * Created by Matt on 5/05/2016.
 */
public class Place extends Action {

    private Intersection placedIntersection;

    public Place(Player player, Game game) {
        super(player, game);
    }

    @Override
    public void start(Board board) {
        getPlayer().setTurn(true);
    }

    @Override
    public void updateAction(Point p) {
        getPlayer().setTurn(false);

        //check if placedCol/Row is legal
        Intersection intersectionSelected = getGame().getBoard().getIntersection(p);

        if (intersectionSelected.isEmpty()) {
            placedIntersection = intersectionSelected;
            setComplete(true);
            System.out.println("Placed token at " + placedIntersection.getPoint().getX() + ", " + placedIntersection.getPoint().getY());
            getPlayer().placeToken(placedIntersection);
            getGame().notifyActionComplete();
        } else {
            getPlayer().setTurn(true);
        }
    }
}
