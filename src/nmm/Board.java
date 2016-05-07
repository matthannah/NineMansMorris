package nmm;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Matt on 5/05/2016.
 */
public class Board {

    private List<Intersection> intersections = new ArrayList<>();

    public Board() {

        intersections.add(new Intersection(new Point(1,1)));
        intersections.add(new Intersection(new Point(1,4)));
        intersections.add(new Intersection(new Point(1,7)));
        intersections.add(new Intersection(new Point(2,2)));
        intersections.add(new Intersection(new Point(2,4)));
        intersections.add(new Intersection(new Point(2,6)));
        intersections.add(new Intersection(new Point(3,3)));
        intersections.add(new Intersection(new Point(3,4)));
        intersections.add(new Intersection(new Point(3,5)));
        intersections.add(new Intersection(new Point(4,1)));
        intersections.add(new Intersection(new Point(4,2)));
        intersections.add(new Intersection(new Point(4,3)));
        intersections.add(new Intersection(new Point(4,5)));
        intersections.add(new Intersection(new Point(4,6)));
        intersections.add(new Intersection(new Point(4,7)));
        intersections.add(new Intersection(new Point(5,3)));
        intersections.add(new Intersection(new Point(5,4)));
        intersections.add(new Intersection(new Point(5,5)));
        intersections.add(new Intersection(new Point(6,2)));
        intersections.add(new Intersection(new Point(6,4)));
        intersections.add(new Intersection(new Point(6,6)));
        intersections.add(new Intersection(new Point(7,1)));
        intersections.add(new Intersection(new Point(7,4)));
        intersections.add(new Intersection(new Point(7,7)));
    }

    public Intersection getIntersection(Point p) {
        for (Intersection intersection : intersections) {
            //find one that has the corresponding point
            if (intersection.getPoint().getX() == p.getX() && intersection.getPoint().getY() == p.getY()) {
                return intersection;
            }
        }
        return null;
    }

    public List<Intersection> getIntersections() {
        return intersections;
    }
}
