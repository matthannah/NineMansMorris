package nmm;

/**
 * Created by Matt on 5/05/2016.
 */

public class Token {
    Intersection intersection;
    Boolean player1;

    public Token(Intersection intersection, Boolean player1) {
        this.player1 = player1;
        this.intersection = intersection;
        intersection.setToken(this);
    }

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
        intersection.setToken(this);
    }

    public Boolean isPlayer1() {
        return player1;
    }
}
