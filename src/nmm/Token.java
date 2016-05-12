package nmm;

/**
 * Created by Matt on 5/05/2016.
 */

public class Token {
    private Intersection intersection;
    private Boolean player1;
    private Boolean selected;
    private int millCount;

    public Token(Intersection intersection, Boolean player1) {
        millCount = 0;
        this.player1 = player1;
        this.intersection = intersection;
        intersection.setToken(this);
        selected = false;
    }

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
        intersection.setToken(this);
    }

    public Boolean isPlayer1() {
        return player1;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean isSelected() {
        return selected;
    }

    public void removeToken(Intersection intersection) {
        intersection.setToken(null);
        this.intersection = null;
    }

    public void incrementMillCount() {
        millCount++;
    }

    public void decrementMillCount() {
        millCount--;
    }

    public Boolean isInMill() {
        return millCount > 0;
    }

    public int getMillCount() {
        return millCount;
    }

    public void setMillCount(int millCount) {
        this.millCount = millCount;
    }
}
