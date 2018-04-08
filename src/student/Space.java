package student;

/**
 * this class represents a space on the map
 * @author Lauren Egts
 */

//IMPORTANT: currently doesn't implement the Space model interface
    //if that is implemented the collocated has to compare a model.Space
    //and I don't think that's a good thing
public class Space {

    private int row;
    private int col;

    /*
    constructor, takes ints for row and column
     */
    public Space(int row, int col){
        this.row = row;
        this.col = col;
    }

    /**
     * gets this space's row
     */
    public int getRow() {
        return row;
    }

    /**
     * gets this space's column
     */
    public int getCol() {
        return col;
    }

    /**
     * returns true if other has the same row and column as this space
     */
    public boolean collocated(student.Space other) {
        return (other.getCol() == col) && (other.getRow() == row);
    }
}
