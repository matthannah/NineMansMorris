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
            player1 = new Human(true, true);
            player2 = new Human(false, true);
            event.updateUI();
            actions.add(actionFactory.getAction(null, player1, player2, this));
            //event.updateStatus(getCurrentAction());
            actions.get(actions.size() - 1).start(board);
        }
    }

    public void notifyActionUpdate() {
        event.updateUI();

        if (player1.getTokenCount() < 3 && player1.tokensPlaced()) {
            event.gameComplete("Player 2 wins");
        }
        else if (player2.getTokenCount() < 3 && player1.tokensPlaced()) {
            event.gameComplete("Player 1 wins");
        }
        else if (getCurrentAction().isComplete())
        {
            actions.add(actionFactory.getAction(getCurrentAction(), player1, player2, this));
            //event.updateStatus(getCurrentAction());
            getCurrentAction().start(board);
        }
    }

    public void undoAction() {
        if (actions.size() > 1) {
            //remove the action currently in progress
            actions.remove(getCurrentAction());
            //undo the last action complete
            getCurrentAction().undo();
        }
    }

    public Action getCurrentAction() {
        return actions.get(actions.size() - 1);
    }

    public Board getBoard() {
        return board;
    }
}
