package nmm;

/**
 * Created by Matt on 5/05/2016.
 */

public class Token {
    private Boolean selected;
    private int millCount;
    private String color;

    public Token(String color) {
        millCount = 0;
        selected = false;
        this.color = color;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean isSelected() {
        return selected;
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

    @Override
    public String toString() {
        return color;
    }
}
