package nmm;

import java.awt.*;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public class Slide extends Action {

    private Intersection startIntersection;
    private Boolean tokenSelected;

    public Slide(Player player, Game game) {
        super(player, game);
        tokenSelected = false;
    }

    @Override
    public void start(Board board) {
        getPlayer().setTurn(true);
    }

    @Override
    public void updateAction(Point p) {
        getPlayer().setTurn(false);

        Intersection intersectionSelected = getGame().getBoard().getIntersection(p);
        if (tokenSelected) {
            if (intersectionSelected.isEmpty() && getGame().getBoard().isAdjacent(startIntersection, intersectionSelected)) {
                if (startIntersection.getToken().isInMill())
                {
                    List<Intersection> intersectionRow = getGame().getBoard().getIntersectionsInRow(startIntersection.getPoint().getX(), startIntersection.getPoint().getY());
                    List<Intersection> intersectionCol = getGame().getBoard().getIntersectionsInCol(startIntersection.getPoint().getX(), startIntersection.getPoint().getY());
                    for (Intersection intersection : intersectionRow) {
                        if (intersection.getToken() != null) {
                            if (intersection.getToken().isInMill()) {
                                intersection.getToken().decrementMillCount();
                            }
                        }
                    }
                    for (Intersection intersection : intersectionCol) {
                        if (intersection.getToken() != null) {
                            if (intersection.getToken().isInMill()) {
                                intersection.getToken().decrementMillCount();
                            }
                        }
                    }
                }
                setFinalIntersection(intersectionSelected);
                setComplete(true);
                System.out.println("Slide token from " + startIntersection.getPoint().getX() + ", " + startIntersection.getPoint().getY() + " to " + getFinalIntersection().getPoint().getX() + " ," + getFinalIntersection().getPoint().getY());
                getPlayer().slideToken(startIntersection, getFinalIntersection());
                getFinalIntersection().getToken().setSelected(false);
                getGame().notifyActionUpdate();
            } else {
                startIntersection.getToken().setSelected(false);
                startIntersection = null;
                tokenSelected = false;
                getGame().notifyActionUpdate();
                getPlayer().setTurn(true);
            }
        } else {
            if (!intersectionSelected.isEmpty() && intersectionSelected.getToken().isPlayer1() == getPlayer().isPlayer1()) {
                startIntersection = intersectionSelected;
                tokenSelected = true;
                startIntersection.getToken().setSelected(true);
                getGame().notifyActionUpdate();
                getPlayer().setTurn(true);
            } else {
                getPlayer().setTurn(true);
            }
        }
    }

    @Override
    public void undo() {
        setComplete(false);
        getPlayer().removeToken(getFinalIntersection());
        getPlayer().addToken(startIntersection);
        getGame().notifyActionUpdate();
        getPlayer().setTurn(true);
    }

    @Override
    public void runAIAction() {

    }
}
