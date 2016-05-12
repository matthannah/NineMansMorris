package nmm;

import java.awt.*;

/**
 * Created by Matt on 5/05/2016.
 */
public class Hop extends Action {

    private Intersection startIntersection;
    private Boolean tokenSelected;

    public Hop(Player player, Game game) {
        super(player, game);
        tokenSelected = false;
    }

    @Override
    public void updateAction(Point p) {
        Intersection intersectionSelected = getGame().getBoard().getIntersection(p);
        if (tokenSelected) {
            if (intersectionSelected.isEmpty()) {
                setFinalIntersection(intersectionSelected);
                setComplete(true);
                System.out.println("Slide token from " + startIntersection.getPoint().getX() + ", " + startIntersection.getPoint().getY() + " to " + getFinalIntersection().getPoint().getX() + " ," + getFinalIntersection().getPoint().getY());
                getPlayer().hopToken(startIntersection, getFinalIntersection());
                getFinalIntersection().getToken().setSelected(false);
                getGame().notifyActionUpdate();
            } else {
                startIntersection.getToken().setSelected(false);
                startIntersection = null;
                tokenSelected = false;
                getGame().notifyActionUpdate();
            }
        } else {
            if (!intersectionSelected.isEmpty() && getPlayer().getTokens().contains(intersectionSelected.getToken())) {
                startIntersection = intersectionSelected;
                tokenSelected = true;
                startIntersection.getToken().setSelected(true);
                getGame().notifyActionUpdate();
            }
        }
    }

    @Override
    public void undo() {
        setComplete(false);
        getPlayer().addToken(startIntersection);
        getPlayer().getTokens().remove(getFinalIntersection().getToken());
        getPlayer().removeToken(getFinalIntersection());
        getGame().notifyActionUpdate();
    }

    @Override
    public void runAIAction() {

    }

    public Intersection getStartIntersection() {
        return startIntersection;
    }

    @Override
    public String toString() {
        return "HOP";
    }
}
