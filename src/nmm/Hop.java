package nmm;

import java.awt.*;

/**
 * A hop action that allows a players token to move from
 * its starting position to any empty intersection on the board
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class Hop extends Action {
    private Intersection startIntersection; //the intersection the token started at

    /**
     * @inheritDoc
     */
    public Hop(Player player, Game game) {
        super(player, game);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void updateAction(Point p) {
        //get the intersection that the user has clicked
        Intersection intersectionSelected = game.getBoard().getIntersection(p);

        //check whether a start intersection has been chosen yet
        if(startIntersection != null) {
            //check whether the intersection selected is empty
            if (intersectionSelected.isEmpty()) {
                //now that the move is valid, check whether the token you plan to moved was in a mill
                if (startIntersection.getToken().isInMill()) {
                    //get a list of row and col intersections where the token we are hopping is
                    java.util.List<Intersection> intersectionRow = game.getBoard().getIntersectionsInRow(startIntersection.getPoint().getX(), startIntersection.getPoint().getY());
                    java.util.List<Intersection> intersectionCol = game.getBoard().getIntersectionsInCol(startIntersection.getPoint().getX(), startIntersection.getPoint().getY());
                    for (Intersection intersection : intersectionRow) {
                        //if the intersection has a token, that belongs to the player hopping, that is in a mill
                        if (intersection.getToken() != null && intersection.getToken().isInMill() && player.getTokens().contains(intersection.getToken())) {
                            intersection.getToken().decrementMillCount();
                        }
                    }
                    for (Intersection intersection : intersectionCol) {
                        //if the intersection has a token, that belongs to the player hopping, that is in a mill
                        if (intersection.getToken() != null && intersection.getToken().isInMill() && player.getTokens().contains(intersection.getToken())) {
                            intersection.getToken().decrementMillCount();
                        }
                    }
                }
                //now we can hop the token
                finalIntersection = intersectionSelected;
                complete = true;
                player.moveToken(startIntersection, finalIntersection);
                finalIntersection.getToken().setSelected(false);
                game.notifyActionUpdate();
            } else { //the intersection was not empty
                startIntersection.getToken().setSelected(false);
                startIntersection = null;
                game.notifyActionUpdate();
                game.notifyInvalidMove();
            }
        } else { //start intersection has not been selected yet
            //intersection is empty and the token selected belongs to the player making the move
            if (!intersectionSelected.isEmpty() && player.getTokens().contains(intersectionSelected.getToken())) {
                startIntersection = intersectionSelected;
                startIntersection.getToken().setSelected(true);
                game.notifyActionUpdate();
            } else {
                game.notifyInvalidMove();
            }
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void undo() {
        complete = false;
        player.moveToken(finalIntersection, startIntersection);
        //restore a mill if any
        game.getBoard().isMill(game.getBoard().getIntersectionsInCol(startIntersection.getPoint().getX(), startIntersection.getPoint().getY()), player);
        game.getBoard().isMill(game.getBoard().getIntersectionsInRow(startIntersection.getPoint().getX(), startIntersection.getPoint().getY()), player);
        startIntersection = null;
        finalIntersection = null;
        game.notifyActionUpdate();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void runAIAction() {

    }

    /**
     * returns the start intersection of the move
     *
     * @return startIntersection    the starting intersection
     */
    public Intersection getStartIntersection() {
        return startIntersection;
    }

    @Override
    public String toString() {
        return "HOP";
    }
}
