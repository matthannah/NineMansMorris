package nmm;

import java.awt.*;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public class Remove extends Action {

    private Player victimPlayer;
    private int removedMillCount;

    public Remove(Player player, Player victimPlayer, Game game) {
        super(player, game);
        this.victimPlayer = victimPlayer;
    }

    @Override
    public void updateAction(Point p) {
        getPlayer().setTurn(false);

        Intersection intersectionSelected = getGame().getBoard().getIntersection(p);

        if (!intersectionSelected.isEmpty() && intersectionSelected.getToken().isPlayer1() != getPlayer().isPlayer1() && !intersectionSelected.getToken().isInMill()) {
            setFinalIntersection(intersectionSelected);
            setComplete(true);
            System.out.println("Removed token from " + getFinalIntersection().getPoint().getX() + ", " + getFinalIntersection().getPoint().getY());
            removedMillCount = getFinalIntersection().getToken().getMillCount();
            victimPlayer.getTokens().remove(getFinalIntersection().getToken());
            getPlayer().removeToken(getFinalIntersection());
            getGame().notifyActionUpdate();
        } else if (!intersectionSelected.isEmpty() && intersectionSelected.getToken().isPlayer1() != getPlayer().isPlayer1() && victimPlayer.allInMill()) {
            setFinalIntersection(intersectionSelected);
            setComplete(true);
            System.out.println("Removed token from " + getFinalIntersection().getPoint().getX() + ", " + getFinalIntersection().getPoint().getY());
            removedMillCount = getFinalIntersection().getToken().getMillCount();
            victimPlayer.getTokens().remove(getFinalIntersection().getToken());
            getPlayer().removeToken(getFinalIntersection());
            getGame().notifyActionUpdate();
        } else {
            getPlayer().setTurn(true);
        }
    }

    @Override
    public void undo() {
        setComplete(false);
        victimPlayer.addToken(getFinalIntersection());
        getFinalIntersection().getToken().setMillCount(removedMillCount);
        getGame().notifyActionUpdate();
        getPlayer().setTurn(true);
    }

    @Override
    public void runAIAction() {

    }
}
