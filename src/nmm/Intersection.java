package nmm;

import java.awt.*;

/**
 * Created by Matt on 5/05/2016.
 */
public class Intersection {
    private Point p;
    private Token token;

    public Intersection(Point p) {
        this.p = p;
        token = null;
    }

    public Point getPoint() {
        return p;
    }

    public boolean isEmpty() {
        if (token == null) {
            return true;
        } else {
            return false;
        }
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
