package student;

import model.Baron;
import model.Orientation;
import model.Space;

/**
 * this class represents a piece of track on the board
 * @author Lauren Egts
 */
public class Track  {

    private Orientation ort;
    private Baron baron;
    private student.Route route;
    private int row;
    private int col;

    /**
     * creates a new piece of track
     * @param ort the track's orientation, either horizontal or vertical
     * @param route the route this piece of track belongs to
     * @param row the row this track is at
     * @param col the column this track is at
     */
    public Track(Orientation ort, student.Route route, int row, int col){
        this.ort = ort;
        this.baron = Baron.UNCLAIMED;
        this.route = route;
        this.row = row;
        this.col = col;
    }

    /**
     * claims the given owner as the owner of this track
     * @param owner the non UNCLAIMED owner of the track
     */
    public void claim(Baron owner){
        this.baron = owner;
    }

    /**
     * gets this track's orientation
     * @return this track's orientation
     */
    public Orientation getOrientation() {
        return ort;
    }

    /**
     * gets this track's owner
     * @return
     */
    public Baron getBaron() {
        return baron;
    }

    /**
     * gets the route that this track belongs to
     * @return
     */
    public student.Route getRoute() {
        return route;
    }

    /**
     * gets this track's row
     * @return this track's row
     */
    public int getRow() {
        return row;
    }

    /**
     * gets this track's column
     * @return this track's column
     */
    public int getCol() {
        return col;
    }

    /**
     * returns true if another space occupies the same row and column as this one
     * @param other the space to compare to
     * @return true if other has the same row and column as this
     */
    public boolean collocated(Space other) {
        return (other.getCol() == col) && (other.getRow() == row);
    }
}
