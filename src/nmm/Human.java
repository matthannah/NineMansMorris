package nmm;

/**
 * Created by Matt on 5/05/2016.
 */
public class Human extends Player {

    public Human(Boolean player1) {
        super(player1);
    }

    @Override
    public void placeToken(Intersection intersection) {
        Token placedToken = new Token(intersection, getPlayer1());
        placedToken.setIntersection(intersection);
        getTokens().add(placedToken);
        System.out.println("Token count: " + getTokens().size());
        if (getTokenCount() > 8) {
            setTokensPlaced(true);
        }
    }
}
