package nmm;

/**
 * Created by Matt on 6/05/2016.
 */
public class ActionFactory {

    public Action getAction(Action lastAction, Player player1, Player player2, Game game) {
        Player player = null;
        Action action = null;
        
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
                if (lastAction.getPlayer().isPlayer1()) {
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
                    System.out.println("Creating slide action...");
                    action = new Slide(player, game);
                } else {
                    System.out.println("Creating hop action...");
                    action = new Hop(player, game);
                }
            }
        }
        return action;
    }
}
