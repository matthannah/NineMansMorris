package nmm;

/**
 * The menu class responsible for starting games and provides
 * the entry point to the program
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class Menu {
    private Event event;

    /**
     * constructor for Menu object
     */
    public Menu() {
        event = new Event(this);
    }

    public static void main(String[] args) {
        new Menu();
    }

    /**
     * sets up a new game
     */
    public void newGame() {
        System.out.println("Starting new game...");
        Game game = new Game(event);
        event.newGame(game);
        game.start(event.isComputer(), 0);
    }
}
