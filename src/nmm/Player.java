package nmm;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class of the player in the nine man's morris
 * board game. The player is responsible for managing its tokens
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public abstract class Player {
    protected List<Token> tokens = new ArrayList<>(); //a list of the players tokens
    protected int placedCount; //a count of tokens placed on the board
    protected Boolean tokensPlaced;
    protected String name;

    /**
     * constructor for Player object
     */
    public Player(String name) {
        placedCount = 0;
        tokensPlaced = false;
        this.name = name;
    }

    /**
     * places a token on a specific intersection
     *
     * @param intersection  the intersection
     */
    public abstract void placeToken(Intersection intersection);

    /**
     * removes a token from a specific intersection
     *
     * @param intersection  the intersection
     */
    public abstract void removeToken(Intersection intersection);

    /**
     * moves a token from one intersection to another
     *
     * @param startIntersection     the tokens starting intersection
     * @param finalIntersection     the tokens final intersection
     */
    public abstract void moveToken(Intersection startIntersection, Intersection finalIntersection);

    /**
     * returns whether or not the player has placed all their tokens
     *
     * @return tokensPlaced     if tokens have been placed
     */
    public Boolean tokensPlaced() {
        return tokensPlaced;
    }

    /**
     * gets the players tokens they own
     *
     * @return tokens   list of tokens
     */
    public List<Token> getTokens() {
        return tokens;
    }

    /**
     * gets the number of tokens the player has on the board
     *
     * @return int  number of tokens
     */
    public int getTokenCount() {
        return tokens.size();
    }

    /**
     * sets whether or not all tokens have been placed
     *
     * @param tokensPlaced      whether or not all tokens have been placed
     */
    public void setTokensPlaced(Boolean tokensPlaced) {
        this.tokensPlaced = tokensPlaced;
    }

    /**
     * decrements the placed tokens count
     */
    public void decrementPlacedCount() {
        placedCount--;
    }

    /**
     * checks if all the tokens the player has on the board are in
     * a mill
     *
     * @return allInMill    whether or not all tokens are in a mill
     */
    public Boolean allInMill() {
        Boolean allInMill = true;
        for (Token token : tokens) {
            if (!token.isInMill()) {
                allInMill = false;
            }
        }
        return allInMill;
    }

    /**
     * adds a new token to the player, and puts it on an intersection
     *
     * @param intersection  the intersection
     */
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

    public abstract String toString();
}
