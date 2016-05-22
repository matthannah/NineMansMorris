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

    private Game game;

    /**
     * constructor for action factory
     *
     * @param game  the game object
     */
    public ActionFactory(Game game) {
        this.game = game;
    }

    /**
     * returns an action to be performed by a player, depending on the
     * last action taken, and the state of the game.
     *
     * @return action       a new action created by the factory
     */
    public Action getAction() {
        Player player;
        Action action;
        
        //first turn
        if (game.getCurrentAction() == null) {
            System.out.println("Creating place action...");
            action = new Place(game.getPlayer1(), game);
        } else {
            //determine player turn
            if (game.getCurrentAction().getPlayer() == game.getPlayer1()) {
                player = game.getPlayer2();
            } else {
                player = game.getPlayer1();
            }

            //determine action
            if (game.getBoard().isMillEvent(game.getCurrentAction())) {
                System.out.println("Creating remove action...");
                if (game.getCurrentAction().getPlayer() == game.getPlayer1()) {
                    action = new Remove(game.getPlayer1(), game.getPlayer2(), game);
                } else {
                    action = new Remove(game.getPlayer2(), game.getPlayer1(), game);
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
