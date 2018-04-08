package student;

/**
 * this class represents a space on the map
 * @author Lauren Egts
 */

public class Space implements model.Space{

    private int row;
    private int col;

    /*
    constructor, takes ints for row and column
     */
    public Space(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    /**
     * gets this space's row
     */
    public int getRow() {
        return row;
    }

    @Override
    /**
     * gets this space's column
     */
    public int getCol() {
        return col;
    }

    @Override
    /**
     * returns true if other has the same row and column as this space
     */
    public boolean collocated(model.Space other) {
        return (other.getCol() == col) && (other.getRow() == row);
    }
}
