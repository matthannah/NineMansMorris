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
        //get the intersection that the user has clicked
        Intersection intersectionSelected = game.getBoard().getIntersection(p);

        //if the intersection is not empty, the intersection holds a token that belongs to the victim player, and the token is either not in a mill or the player has all tokens in a mill
        if (!intersectionSelected.isEmpty() && victimPlayer.getTokens().contains(intersectionSelected.getToken()) && (!intersectionSelected.getToken().isInMill() || victimPlayer.allInMill()) ) {
            finalIntersection = intersectionSelected;
            complete = true;
            removedMillCount = finalIntersection.getToken().getMillCount();
            victimPlayer.getTokens().remove(finalIntersection.getToken());
            player.removeToken(finalIntersection);
            game.notifyActionUpdate();
        }
    }

    @Override
    public void undo() {
        complete = false;
        victimPlayer.addToken(getFinalIntersection());
        finalIntersection.getToken().setMillCount(removedMillCount);
        finalIntersection = null;
        game.notifyActionUpdate();
    }

    @Override
    public void runAIAction() {

    }

    @Override
    public String toString() {
        return "REMOVE";
    }
}
