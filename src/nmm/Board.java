package nmm;

/**
 * Created by Matt on 5/05/2016.
 */
public class Board {

    private Intersection[] intersections = new Intersection[24];

    public Board() {

        intersections[0] = new Intersection(1, 1);
        intersections[1] = new Intersection(1, 4);
        intersections[2] = new Intersection(1, 7);
        intersections[3] = new Intersection(2, 2);
        intersections[4] = new Intersection(2, 4);
        intersections[5] = new Intersection(2, 6);
        intersections[6] = new Intersection(3, 3);
        intersections[7] = new Intersection(3, 4);
        intersections[8] = new Intersection(3, 5);
        intersections[9] = new Intersection(4, 1);
        intersections[10] = new Intersection(4, 2);
        intersections[11] = new Intersection(4, 3);
        intersections[12] = new Intersection(4, 5);
        intersections[13] = new Intersection(4, 6);
        intersections[14] = new Intersection(4, 7);
        intersections[15] = new Intersection(5, 3);
        intersections[16] = new Intersection(5, 4);
        intersections[17] = new Intersection(5, 5);
        intersections[18] = new Intersection(6, 2);
        intersections[19] = new Intersection(6, 4);
        intersections[20] = new Intersection(6, 6);
        intersections[21] = new Intersection(7, 1);
        intersections[22] = new Intersection(7, 4);
        intersections[23] = new Intersection(7, 7);
    }

    public boolean isEmpty(String coord) {
        // if the coord doesn't have a token then return true
        return true;
    }

}
