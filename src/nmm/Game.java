package nmm;

import java.util.ArrayList;
import java.util.List;

/**
 * the game object which controls the flow of the game.
 * responsible for creating actions and passing updates to the event
 * object for updates to the user. The game keeps track of all actions taken
 * during a game
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class Game {

    private Event event;
    private Board board;
    private Player player1;
    private Player player2;
    private List<Action> actions = new ArrayList<>(); //all actions in the game
    private ActionFactory actionFactory;

    /**
     * constructor for game object
     */
    public Game(Event event) {
        this.event = event;
        board = new Board();
        actionFactory = new ActionFactory();
    }

    /**
     * starts the new game object, setting up the players, notifying the event object
     * a game has started and creating the first move to be made
     *
     * @param computer      whether or not a computer AI player is playing
     * @param difficulty    the difficulty of the computer player if applicable
     */
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

    /**
     * notifies the event object that an action has been updated. checks if
     * the win state has been achieved, and whether or not the current action has been
     * completed; will get a new action if so
     */
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

    /**
     * removes the current action in progress and the last completed
     * action from the game
     */
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

    /**
     * returns the current action in play
     *
     * @return action   the current action
     */
    public Action getCurrentAction() {
        return actions.get(actions.size() - 1);
    }

    /**
     * returns the board object
     *
     * @return  the board
     */
    public Board getBoard() {
        return board;
    }
}
