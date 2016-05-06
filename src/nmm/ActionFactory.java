package nmm;

/**
 * Created by Matt on 6/05/2016.
 */
public class ActionFactory {

    public Action getPlace(Player player, Board board) {
        Boolean validAction = false;
        Place place = new Place(player);
        player.makeMove(place, board);
        return place;
    }

    public Action getSlide(Player player, Board board) {
        Boolean validAction = false;
        Slide slide = new Slide(player);
        player.makeMove(slide, board);
        return slide;
    }
}
