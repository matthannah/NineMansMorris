package nmm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public abstract class Player {

    protected List<Token> tokens = new ArrayList<>();
    protected int placedCount;
    protected Boolean tokensPlaced;
    protected String name;

    public Player(String name) {
        placedCount = 0;
        tokensPlaced = false;
        this.name = name;
    }

    public abstract void placeToken(Intersection intersection);

    public abstract void removeToken(Intersection intersection);

    public abstract void moveToken(Intersection startIntersection, Intersection finalIntersection);

    public abstract String toString();

    public Boolean tokensPlaced() {
        return tokensPlaced;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public int getTokenCount() {
        return tokens.size();
    }

    public void setTokensPlaced(Boolean tokensPlaced) {
        this.tokensPlaced = tokensPlaced;
    }

    public void decrementPlacedCount() {
        placedCount--;
    }

    public Boolean allInMill() {
        Boolean allInMill = true;
        for (Token token : tokens) {
            if (!token.isInMill()) {
                allInMill = false;
            }
        }
        return allInMill;
    }

    public void addToken(Intersection intersection) {
        Token token;
        if (this.toString().equals("PLAYER1")) {
            token = new Token("RED");
        } else {
            token = new Token("BLUE");
        }
        tokens.add(token);
        intersection.setToken(token);
    }
}
