package nmm;

/**
 * The action factory is responsible for returning an action depending on the
 * state of the game.
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class ActionFactory {

    /**
     * returns an action to be performed by a player, depending on the
     * last action taken, and the state of the game.
     *
     * @param lastAction    the last action that has occurred in the game
     * @param player1       Player 1 in the game
     * @param player2       Player 2 in the game
     * @param game          the game object
     * @return action       a new action created by the factory
     */
    public Action getAction(Action lastAction, Player player1, Player player2, Game game) {
        Player player;
        Action action;
        
        //first turn
        if (lastAction == null) {
            System.out.println("Creating place action...");
            action = new Place(player1, game);
        } else {
            //determine player turn
            if (lastAction.getPlayer() == player1) {
                player = player2;
            } else {
                player = player1;
            }

            //determine action
            if (game.getBoard().isMillEvent(lastAction)) {
                System.out.println("Creating remove action...");
                if (lastAction.getPlayer().toString().equals("PLAYER1")) {
                    action = new Remove(player1, player2, game);
                } else {
                    action = new Remove(player2, player1, game);
                }
            }
            else if (!player.tokensPlaced()) {
                System.out.println("Creating place action...");
                action = new Place(player, game);
            } else {
                if (player.getTokenCount() > 3) {
                    //check whether there is any valid slide moves left
                    if (player.hasValidMoves()) {
                        System.out.println("Creating slide action...");
                        action = new Slide(player, game);
                    } else { //game over
                        action = null;
                    }
                } else {
                    System.out.println("Creating hop action...");
                    action = new Hop(player, game);
                }
            }
        }
        return action;
    }
}
