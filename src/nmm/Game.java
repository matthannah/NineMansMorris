package nmm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private List<Action> actions = new ArrayList<>();
    private ActionFactory actionFactory;
    private Event event;

    public Game() {
        event = new Event();
        board = new Board();
        actionFactory = new ActionFactory();

        /*
        setLayout(new BorderLayout());
        status = new JLabel("STATUS: ");
        add(status, BorderLayout.PAGE_START);
        add(board, BorderLayout.CENTER);
        setBackground(Color.GRAY);*/

    }

    public void newGame(Boolean computer, int difficulty) {
        if (computer) {

        } else {

        }
    }
}
