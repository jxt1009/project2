package student;

import model.Space;

/**
 * this class represents a station on the map
 * a station is a space that has a name and is at the origin or destination of a train route
 */
public class Station implements model.Station{

    private String name;
    private int row;
    private int col;

    /**
     * constructor
     * @param name station's name
     * @param row station's row
     * @param col station's column
     */
    public Station(String name, int row, int col){
        this.name = name;
        this.col = col;
        this.row = row;
    }

    @Override
    /**
     * gets this station's name
     */
    public String getName() {
        return name;
    }

    @Override
    /**
     * gets this station's row
     */
    public int getRow() {
        return row;
    }

    @Override
    /**
     * gets this station's column
     */
    public int getCol() {
        return col;
    }

    @Override
    /**
     * will return true if other has the same row and column as this
     * //TODO figure out if I should cast other to a station, not sure because this is inherited from Space
     */
    public boolean collocated(Space other) {
        return other.getRow() == row && other.getCol() == this.col;
    }
}
