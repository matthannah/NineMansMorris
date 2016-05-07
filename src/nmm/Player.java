package nmm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public abstract class Player {

    private List<Token> tokens = new ArrayList<>();
    private Boolean tokensPlaced;
    private Boolean turn;
    private Boolean player1;

    public Player(Boolean player1) {
        this.player1 = player1;
        tokensPlaced = false;
        turn = false;
    }

    public abstract void placeToken(Intersection intersection);

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

    public Boolean getPlayer1() {
        return player1;
    }
}
