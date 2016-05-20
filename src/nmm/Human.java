package nmm;

/**
 * A type of player, Human, that is responsible for the management
 * of their tokens
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class Human extends Player {

    /**
     * @inheritDoc
     */
    public Human(String name) {
        super(name);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void placeToken(Intersection intersection) {
        Token placedToken;
        //check whether you're player1 or player2 and create a token accordingly
        if (this.toString().equals("PLAYER1")) {
            placedToken = new Token("RED");
        } else {
            placedToken = new Token("BLUE");
        }
        //place the token on the intersection
        intersection.setToken(placedToken);
        //add the token to your collection of tokens
        tokens.add(placedToken);
        placedCount++;
        if (placedCount > 8) {
            tokensPlaced = true;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void removeToken(Intersection intersection) {
        //remove the reference to the token
        intersection.setToken(null);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void moveToken(Intersection startIntersection, Intersection finalIntersection) {
        //set the tokens position
        finalIntersection.setToken(startIntersection.getToken());
        //remove the reference to the token from the startIntersection
        startIntersection.setToken(null);
    }

    @Override
    public String toString() {
        return name;
    }
}
