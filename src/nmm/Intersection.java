package nmm;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public class Intersection {
    private Point p;
    private Token token;
    private List<Intersection> adjacentIntersections = new ArrayList<>();

    public Intersection(Point p) {
        this.p = p;
        token = null;
    }

    public void setAdjacentIntersections(List<Intersection> adjacentIntersections) {
        this.adjacentIntersections = adjacentIntersections;
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

    public List<Intersection> getAdjacentIntersections() {
        return adjacentIntersections;
    }
}
