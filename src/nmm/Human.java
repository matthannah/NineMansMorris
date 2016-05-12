package nmm;

/**
 * Created by Matt on 5/05/2016.
 */
public class Human extends Player {

    @Override
    public void placeToken(Intersection intersection) {
        Token placedToken = new Token(intersection);
        placedToken.setIntersection(intersection);
        getTokens().add(placedToken);
        incrementPlacedCount();
        if (getPlacedCount() > 8) {
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
        intersection.setToken(null);
    }

    @Override
    public void hopToken(Intersection startIntersection, Intersection finalIntersection) {
        startIntersection.getToken().setIntersection(finalIntersection);
        startIntersection.setToken(null);
    }
}
