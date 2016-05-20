package nmm;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * A virtualization of an intersection on the game board.
 * the intersection can have a token on it and knows its adjacent intersections
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class Intersection {
    private Point p;
    private Token token;
    private List<Intersection> adjacentIntersections = new ArrayList<>(); //a list of adjacent intersections

    /**
     * constructor for Intersection object
     *
     * @param p     the point x,y on which it is located
     */
    public Intersection(Point p) {
        this.p = p;
        token = null;
    }

    /**
     * sets the adjacent intersections
     *
     * @param adjacentIntersections     a list of adjacent intersections
     */
    public void setAdjacentIntersections(List<Intersection> adjacentIntersections) {
        this.adjacentIntersections = adjacentIntersections;
    }

    /**
     * returns the x,y point in which the intersection is located
     *
     * @return p    the x,y point
     */
    public Point getPoint() {
        return p;
    }

    /**
     * checks whether the intersections holds a token or not
     *
     * @return Boolean  true/false whether or not the intersection has a token
     */
    public boolean isEmpty() {
        if (token == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * sets the intersections token
     *
     * @param token     the token
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * returns the token on the intersection
     *
     * @return token    the token
     */
    public Token getToken() {
        return token;
    }

    /**
     * returns the list of adjacent intersections
     *
     * @return adjacentIntersections    the list of adjacent intersections
     */
    public List<Intersection> getAdjacentIntersections() {
        return adjacentIntersections;
    }
}
