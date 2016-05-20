package nmm;

/**
 * A virtualization of the token in the nine man's morris game
 * the token is responsible for managing whether or
 * not it is in a mill.
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class Token {
    private Boolean selected; //if the token has been selected by a player
    private int millCount;
    private String color;

    /**
     * constructor for Token object
     */
    public Token(String color) {
        millCount = 0;
        selected = false;
        this.color = color;
    }

    /**
     * sets whether or not the player has selected the token
     *
     * @param selected  true/false whether or not it is selected
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    /**
     * returns whether or not the token is selected
     *
     * @return selected     whether or not the token is selected
     */
    public Boolean isSelected() {
        return selected;
    }

    /**
     * increments the tokens mill count
     */
    public void incrementMillCount() {
        millCount++;
    }

    /**
     * decrements the tokens mill count
     */
    public void decrementMillCount() {
        millCount--;
    }

    /**
     * returns whether or not the token is in a mill
     *
     * @return Boolean  true/false if token is in a mill
     */
    public Boolean isInMill() {
        return millCount > 0;
    }

    /**
     * returns the tokens mill count
     *
     * @return millCount    the tokens mill count
     */
    public int getMillCount() {
        return millCount;
    }

    /**
     * sets the tokens mill count
     *
     * @param millCount     the mill count
     */
    public void setMillCount(int millCount) {
        this.millCount = millCount;
    }

    @Override
    public String toString() {
        return color;
    }
}
