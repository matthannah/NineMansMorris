package nmm;

/**
 * Created by Matt on 5/05/2016.
 */
public class Menu {

    private Game game;
    private Event event;

    public Menu() {
        event = new Event(this);
    }

    public static void main(String[] args) {
        new Menu();
    }

    public void newGame() {
        System.out.println("Starting new game...");
        game = new Game(event);
        event.newGame(game);
        game.start(event.isComputer(), 0);
    }

    public Event getEvent() {
        return event;
    }
}
