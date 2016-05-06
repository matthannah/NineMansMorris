package nmm;

/**
 * Created by Matt on 5/05/2016.
 */
public abstract class Player {

    Token[] tokens = new Token[9];

    public Player() {
        for (int i = 0; i < 9; i++) {
            tokens[i] = new Token();
        }
    }

    public abstract void makeMove(Place place, Board board);

    public abstract void makeMove(Slide slide, Board board);
}
