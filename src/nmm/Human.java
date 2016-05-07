package nmm;

/**
 * Created by Matt on 5/05/2016.
 */
public class Human extends Player {

    public Human(Boolean player1, Boolean human) {
        super(player1, human);
    }

    @Override
    public void placeToken(Intersection intersection) {
        Token placedToken = new Token(intersection, isPlayer1());
        placedToken.setIntersection(intersection);
        getTokens().add(placedToken);
        System.out.println("Token count: " + getTokens().size());
        if (getTokenCount() > 8) {
            setTokensPlaced(true);
        }
    }

    @Override
    public void slideToken(Intersection startIntersection, Intersection finalIntersection) {
        startIntersection.getToken().setIntersection(finalIntersection);
        startIntersection.setToken(null);
    }

    @Override
    public void removeToken(Intersection intersection) {
        intersection.getToken().removeToken(intersection);
    }
}
