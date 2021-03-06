package nmm;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * This class is a virtualization of the nine man's morris board.
 * The board is responsible for linking up all its intersections as well
 * as managing them. Additionally, the board will check for a mill event
 *
 * @author  Matthew Hannah
 * @version 1.0
 * @since 1.0
 */
public class Board {
    private Map<String, Intersection> intersections = new HashMap<>(); //a map of all the intersections on the board
    private List<String> intersectionIDs = new ArrayList<>(); //a convenient list of intersection IDs to access each intersection logically

    /**
     * constructor for Board object
     */
    public Board() {
        intersections.put("a1", new Intersection(new Point(1,1)));
        intersections.put("a4", new Intersection(new Point(1,4)));
        intersections.put("a7", new Intersection(new Point(1, 7)));
        intersections.put("b2", new Intersection(new Point(2, 2)));
        intersections.put("b4", new Intersection(new Point(2, 4)));
        intersections.put("b6", new Intersection(new Point(2, 6)));
        intersections.put("c3", new Intersection(new Point(3, 3)));
        intersections.put("c4", new Intersection(new Point(3, 4)));
        intersections.put("c5", new Intersection(new Point(3, 5)));
        intersections.put("d1", new Intersection(new Point(4, 1)));
        intersections.put("d2", new Intersection(new Point(4, 2)));
        intersections.put("d3", new Intersection(new Point(4, 3)));
        intersections.put("d5", new Intersection(new Point(4, 5)));
        intersections.put("d6", new Intersection(new Point(4, 6)));
        intersections.put("d7", new Intersection(new Point(4, 7)));
        intersections.put("e3", new Intersection(new Point(5, 3)));
        intersections.put("e4", new Intersection(new Point(5, 4)));
        intersections.put("e5", new Intersection(new Point(5, 5)));
        intersections.put("f2", new Intersection(new Point(6, 2)));
        intersections.put("f4", new Intersection(new Point(6, 4)));
        intersections.put("f6", new Intersection(new Point(6, 6)));
        intersections.put("g1", new Intersection(new Point(7, 1)));
        intersections.put("g4", new Intersection(new Point(7, 4)));
        intersections.put("g7", new Intersection(new Point(7,7)));

        intersectionIDs.add("a1");
        intersectionIDs.add("a4");
        intersectionIDs.add("a7");
        intersectionIDs.add("b2");
        intersectionIDs.add("b4");
        intersectionIDs.add("b6");
        intersectionIDs.add("c3");
        intersectionIDs.add("c4");
        intersectionIDs.add("c5");
        intersectionIDs.add("d1");
        intersectionIDs.add("d2");
        intersectionIDs.add("d3");
        intersectionIDs.add("d5");
        intersectionIDs.add("d6");
        intersectionIDs.add("d7");
        intersectionIDs.add("e3");
        intersectionIDs.add("e4");
        intersectionIDs.add("e5");
        intersectionIDs.add("f2");
        intersectionIDs.add("f4");
        intersectionIDs.add("f6");
        intersectionIDs.add("g1");
        intersectionIDs.add("g4");
        intersectionIDs.add("g7");

        //set adjacent intersections up
        ArrayList<Intersection> adjacents = new ArrayList<>();

        //a1
        adjacents.add(intersections.get("a4"));
        adjacents.add(intersections.get("d1"));
        intersections.get("a1").setAdjacentIntersections(adjacents);

        //a4
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("a1"));
        adjacents.add(intersections.get("a7"));
        adjacents.add(intersections.get("b4"));
        intersections.get("a4").setAdjacentIntersections(adjacents);

        //a7
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("a4"));
        adjacents.add(intersections.get("d7"));
        intersections.get("a7").setAdjacentIntersections(adjacents);

        //b2
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("b4"));
        adjacents.add(intersections.get("d2"));
        intersections.get("b2").setAdjacentIntersections(adjacents);

        //b4
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("a4"));
        adjacents.add(intersections.get("b2"));
        adjacents.add(intersections.get("c4"));
        adjacents.add(intersections.get("b6"));
        intersections.get("b4").setAdjacentIntersections(adjacents);

        //b6
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("b4"));
        adjacents.add(intersections.get("d6"));
        intersections.get("b6").setAdjacentIntersections(adjacents);

        //c3
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("c4"));
        adjacents.add(intersections.get("d3"));
        intersections.get("c3").setAdjacentIntersections(adjacents);

        //c4
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("b4"));
        adjacents.add(intersections.get("c5"));
        adjacents.add(intersections.get("c3"));
        intersections.get("c4").setAdjacentIntersections(adjacents);

        //c5
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("c4"));
        adjacents.add(intersections.get("d5"));
        intersections.get("c5").setAdjacentIntersections(adjacents);

        //d1
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("a1"));
        adjacents.add(intersections.get("d2"));
        adjacents.add(intersections.get("g1"));
        intersections.get("d1").setAdjacentIntersections(adjacents);

        //d2
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d1"));
        adjacents.add(intersections.get("b2"));
        adjacents.add(intersections.get("f2"));
        adjacents.add(intersections.get("d3"));
        intersections.get("d2").setAdjacentIntersections(adjacents);

        //d3
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d2"));
        adjacents.add(intersections.get("c3"));
        adjacents.add(intersections.get("e3"));
        intersections.get("d3").setAdjacentIntersections(adjacents);

        //d5
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d6"));
        adjacents.add(intersections.get("c5"));
        adjacents.add(intersections.get("e5"));
        intersections.get("d5").setAdjacentIntersections(adjacents);

        //d6
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d5"));
        adjacents.add(intersections.get("b6"));
        adjacents.add(intersections.get("f6"));
        adjacents.add(intersections.get("d7"));
        intersections.get("d6").setAdjacentIntersections(adjacents);

        //d7
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("a7"));
        adjacents.add(intersections.get("d6"));
        adjacents.add(intersections.get("g7"));
        intersections.get("d7").setAdjacentIntersections(adjacents);

        //e3
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d3"));
        adjacents.add(intersections.get("e4"));
        intersections.get("e3").setAdjacentIntersections(adjacents);

        //e4
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("e3"));
        adjacents.add(intersections.get("f4"));
        adjacents.add(intersections.get("e5"));
        intersections.get("e4").setAdjacentIntersections(adjacents);

        //e5
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d5"));
        adjacents.add(intersections.get("e4"));
        intersections.get("e5").setAdjacentIntersections(adjacents);

        //f2
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d2"));
        adjacents.add(intersections.get("f4"));
        intersections.get("f2").setAdjacentIntersections(adjacents);

        //f4
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("f2"));
        adjacents.add(intersections.get("g4"));
        adjacents.add(intersections.get("e4"));
        adjacents.add(intersections.get("f6"));
        intersections.get("f4").setAdjacentIntersections(adjacents);

        //f6
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d6"));
        adjacents.add(intersections.get("f4"));
        intersections.get("f6").setAdjacentIntersections(adjacents);

        //g1
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d1"));
        adjacents.add(intersections.get("g4"));
        intersections.get("g1").setAdjacentIntersections(adjacents);

        //g4
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("g1"));
        adjacents.add(intersections.get("f4"));
        adjacents.add(intersections.get("g7"));
        intersections.get("g4").setAdjacentIntersections(adjacents);

        //g7
        adjacents = new ArrayList<>();
        adjacents.add(intersections.get("d7"));
        adjacents.add(intersections.get("g4"));
        intersections.get("g7").setAdjacentIntersections(adjacents);
    }

    /**
     * returns an intersection given an X,Y point,
     * this method is a convenient way to convert user input
     * to an intersection
     *
     * @param p                 the user input
     * @return intersection     an intersection corresponding to the point
     *                          null if input not valid
     */
    public Intersection getIntersection(Point p) {
        for (String intersectionID : intersectionIDs) {
            //find one that has the corresponding point
            if (intersections.get(intersectionID).getPoint().getX() == p.getX() && intersections.get(intersectionID).getPoint().getY() == p.getY()) {
                return intersections.get(intersectionID);
            }
        }
        return null;
    }

    /**
     * returns the intersectionIDs
     *
     * @return intersectionIDs  the list of intersectionIDs
     */
    public List<String> getIntersectionIDs() {
        return intersectionIDs;
    }

    /**
     * returns the mapping of intersections
     *
     * @return intersections    the intersections on the board
     */
    public Map<String, Intersection> getIntersections() {
        return intersections;
    }

    /**
     * checks if an intersection is adjacent to another
     *
     *@param intersection1  intersection to check adjacency
     *@param intersection2  intersection to check adjacency
     *@return Boolean      true/false whether or not the intersections
     *                      were adjacent
     */
    public Boolean isAdjacent(Intersection intersection1, Intersection intersection2) {
        return (intersection1.getAdjacentIntersections().contains(intersection2));
    }

    /**
     * returns a list of intersections that are in a specific row
     *
     * @param col                   the column to get intersections from
     * @param row                   the row to get intersections from
     * @return intersectionsRow     the intersections in the row
     */
    public List<Intersection> getIntersectionsInRow(double col, double row) {
        List<Intersection> intersectionsRow = new ArrayList<>();
        if (row == 1 && (col == 1 || col == 4 || col == 7)) {
            intersectionsRow.add(intersections.get("a1"));
            intersectionsRow.add(intersections.get("d1"));
            intersectionsRow.add(intersections.get("g1"));
        }
        if (row == 2 && (col == 2 || col == 4 || col == 6)) {
            intersectionsRow.add(intersections.get("b2"));
            intersectionsRow.add(intersections.get("d2"));
            intersectionsRow.add(intersections.get("f2"));
        }
        if (row == 3 && (col == 3 || col == 4 || col == 5)) {
            intersectionsRow.add(intersections.get("c3"));
            intersectionsRow.add(intersections.get("d3"));
            intersectionsRow.add(intersections.get("e3"));
        }
        if (row == 4 && (col == 1 || col == 2 || col == 3)) {
            intersectionsRow.add(intersections.get("a4"));
            intersectionsRow.add(intersections.get("b4"));
            intersectionsRow.add(intersections.get("c4"));
        }
        if (row == 4 && (col == 5 || col == 6 || col == 7)) {
            intersectionsRow.add(intersections.get("e4"));
            intersectionsRow.add(intersections.get("f4"));
            intersectionsRow.add(intersections.get("g4"));
        }
        if (row == 5 && (col == 3 || col == 4 || col == 5)) {
            intersectionsRow.add(intersections.get("c5"));
            intersectionsRow.add(intersections.get("d5"));
            intersectionsRow.add(intersections.get("e5"));
        }
        if (row == 6 && (col == 2 || col == 4 || col == 6)) {
            intersectionsRow.add(intersections.get("b6"));
            intersectionsRow.add(intersections.get("d6"));
            intersectionsRow.add(intersections.get("f6"));
        }
        if (row == 7 && (col == 1 || col == 4 || col == 7)) {
            intersectionsRow.add(intersections.get("a7"));
            intersectionsRow.add(intersections.get("d7"));
            intersectionsRow.add(intersections.get("g7"));
        }
        return intersectionsRow;
    }

    /**
     * returns a list of intersections that are in a specific column
     *
     * @param col                   the column to get intersections from
     * @param row                   the row to get intersections from
     * @return intersectionsCol     the intersections in the column
     */
    public List<Intersection> getIntersectionsInCol(double col, double row) {
        List<Intersection> intersectionsCol = new ArrayList<>();
        if (col == 1 && (row == 1 || row == 4 || row == 7)) {
            intersectionsCol.add(intersections.get("a1"));
            intersectionsCol.add(intersections.get("a4"));
            intersectionsCol.add(intersections.get("a7"));
        }
        if (col == 2 && (row == 2 || row == 4 || row == 6)) {
            intersectionsCol.add(intersections.get("b2"));
            intersectionsCol.add(intersections.get("b4"));
            intersectionsCol.add(intersections.get("b6"));
        }
        if (col == 3 && (row == 3 || row == 4 || row == 5)) {
            intersectionsCol.add(intersections.get("c3"));
            intersectionsCol.add(intersections.get("c4"));
            intersectionsCol.add(intersections.get("c5"));
        }
        if (col == 4 && (row == 1 || row == 2 || row == 3)) {
            intersectionsCol.add(intersections.get("d1"));
            intersectionsCol.add(intersections.get("d2"));
            intersectionsCol.add(intersections.get("d3"));
        }
        if (col == 4 && (row == 5 || row == 6 || row == 7)) {
            intersectionsCol.add(intersections.get("d5"));
            intersectionsCol.add(intersections.get("d6"));
            intersectionsCol.add(intersections.get("d7"));
        }
        if (col == 5 && (row == 3 || row == 4 || row == 5)) {
            intersectionsCol.add(intersections.get("e3"));
            intersectionsCol.add(intersections.get("e4"));
            intersectionsCol.add(intersections.get("e5"));
        }
        if (col == 6 && (row == 2 || row == 4 || row == 6)) {
            intersectionsCol.add(intersections.get("f2"));
            intersectionsCol.add(intersections.get("f4"));
            intersectionsCol.add(intersections.get("f6"));
        }
        if (col == 7 && (row == 1 || row == 4 || row == 7)) {
            intersectionsCol.add(intersections.get("g1"));
            intersectionsCol.add(intersections.get("g4"));
            intersectionsCol.add(intersections.get("g7"));
        }
        return intersectionsCol;
    }

    /**
     * checks if a mill event has occurred given the last action that occurred
     *
     * @param lastAction    the last action that occurred in the game
     * @return millEvent    true/false whether or not a mill event occurred
     */
    public Boolean isMillEvent(Action lastAction) {
        //get a list of row and col intersections where that the last action occurred
        List<Intersection> intersectionsRow = getIntersectionsInRow(lastAction.getFinalIntersection().getPoint().getX(), lastAction.getFinalIntersection().getPoint().getY());
        List<Intersection> intersectionsCol = getIntersectionsInCol(lastAction.getFinalIntersection().getPoint().getX(), lastAction.getFinalIntersection().getPoint().getY());
        Boolean millEvent = isMill(intersectionsRow, lastAction.getPlayer());
        if(millEvent) {
            //make sure to check if 2 mill events were made by a move (this can happen)
            isMill(intersectionsCol, lastAction.getPlayer());
        } else {
            millEvent = isMill(intersectionsCol, lastAction.getPlayer());
        }
        return millEvent;
    }

    /**
     * checks if a list of intersections all contain tokens that belong
     * to a specific player; a mill
     *
     * @param intersections     a list of intersections to check
     * @param player            the player to check
     * @return Boolean          true/false whether or not the intersections
     *                          are in a mill with the player
     */
    public Boolean isMill(List<Intersection> intersections, Player player) {
        int i = 0;
        //for each token in the list that belongs to the player increment i
        for (Intersection intersection : intersections) {
            if (intersection.getToken() != null && player.getTokens().contains(intersection.getToken())) {
                i++;
            }
        }

        //if there was 3 tokens found, then a mill has occurred
        if (i > 2) {
            for (Intersection intersection : intersections) {
                intersection.getToken().incrementMillCount();
            }
            return true;
        }
        return false;
    }
}
