package nmm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public class Game {

    private Event event;
    private Board board;
    private Player player1;
    private Player player2;
    private List<Action> actions = new ArrayList<>();
    private ActionFactory actionFactory;

    public Game(Event event) {
        this.event = event;
        board = new Board();
        actionFactory = new ActionFactory();
    }

    public void start(Boolean computer, int difficulty) {
        if (computer) {
            System.out.println("Feature not implemented: Computer AI");
        } else {
            player1 = new Human("PLAYER1");
            player2 = new Human("PLAYER2");
            event.updateUI(null);
            actions.add(actionFactory.getAction(null, player1, player2, this));
            event.updateActionLabel(getCurrentAction());
        }
    }

    public void notifyActionUpdate() {
        event.updateUI(getCurrentAction());

        if (player1.getTokenCount() < 3 && player1.tokensPlaced()) {
            event.gameComplete("----Player 2 wins----");
        }
        else if (player2.getTokenCount() < 3 && player1.tokensPlaced()) {
            event.gameComplete("----Player 1 wins----");
        }
        else if (getCurrentAction().isComplete())
        {
            actions.add(actionFactory.getAction(getCurrentAction(), player1, player2, this));
            event.updateActionLabel(getCurrentAction());
        }
    }

    public void undoAction() {
        if (actions.size() > 1) {
            //remove the action currently in progress
            actions.remove(getCurrentAction());
            //undo the last action complete
            getCurrentAction().undo();
            //update event label
            event.updateActionLabel(getCurrentAction());
        }
    }

    public Action getCurrentAction() {
        return actions.get(actions.size() - 1);
    }

    public Board getBoard() {
        return board;
    }
}
