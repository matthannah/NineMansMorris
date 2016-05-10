package nmm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public abstract class Player {

    private List<Token> tokens = new ArrayList<>();
    private int placedCount;
    private Boolean tokensPlaced;
    private Boolean turn;
    private Boolean player1;
    private Boolean human;

    public Player(Boolean player1, Boolean human) {
        placedCount = 0;
        this.human = human;
        this.player1 = player1;
        tokensPlaced = false;
        turn = false;
    }

    public abstract void placeToken(Intersection intersection);

    public abstract void slideToken(Intersection startIntersection, Intersection finalIntersection);

    public abstract void removeToken(Intersection intersection);

    public abstract void hopToken(Intersection startIntersection, Intersection finalIntersection);

    public Boolean tokensPlaced() {
        return tokensPlaced;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public int getTokenCount() {
        return tokens.size();
    }

    public void setTurn(Boolean turn) {
        this.turn = turn;
    }

    public Boolean isTurn() {
        return turn;
    }

    public void setTokensPlaced(Boolean tokensPlaced) {
        this.tokensPlaced = tokensPlaced;
    }

    public Boolean isPlayer1() {
        return player1;
    }

    public Boolean isHuman() {
        return human;
    }

    public void incrementPlacedCount() {
        placedCount++;
    }

    public void decrementPlacedCount() {
        placedCount--;
    }

    public int getPlacedCount() {
        return placedCount;
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
        Token token = new Token(intersection, isPlayer1());
        tokens.add(token);
        intersection.setToken(token);
    }
}
