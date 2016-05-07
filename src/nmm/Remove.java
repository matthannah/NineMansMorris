package nmm;

import java.awt.*;

/**
 * Created by Matt on 5/05/2016.
 */
public class Remove extends Action {

    public Remove(Player player, Game game) {
        super(player, game);
    }

    @Override
    public void updateAction(Point p) {
        getPlayer().setTurn(false);

        Intersection intersectionSelected = getGame().getBoard().getIntersection(p);

        if (!intersectionSelected.isEmpty() && intersectionSelected.getToken().isPlayer1() == getPlayer().isPlayer1()) {
            setFinalIntersection(intersectionSelected);
            setComplete(true);
            System.out.println("Removed token from " + getFinalIntersection().getPoint().getX() + ", " + getFinalIntersection().getPoint().getY());
            getPlayer().removeToken(getFinalIntersection());
            getGame().notifyActionUpdate();
        } else {
            getPlayer().setTurn(true);
        }
    }

    @Override
    public void runAIAction() {

    }
}
