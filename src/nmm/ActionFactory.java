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
            System.out.println("PLAYER1 TURN");
            action = new Place(player1, game);
        } else {
            //determine player turn
            if (lastAction.getPlayer() == player1) {
                System.out.println("PLAYER2 TURN");
                player = player2;
            } else {
                System.out.println("PLAYER1 TURN");
                player = player1;
            }

            //determine action
            if (!player.tokensPlaced()) {
                System.out.println("Creating place action...");
                action = new Place(player, game);
            } else {
                if (player.getTokenCount() > 3) {
                    System.out.println("Creating slide action...");
                    action = new Slide(player, game);
                } else {
                    System.out.println("Creating slide action...");
                    action = new Hop(player, game);
                }
            }
        }
        return action;
    }
}
