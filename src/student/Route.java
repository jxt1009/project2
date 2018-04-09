package student;

import model.*;
import model.Space;
import model.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a route on the map
 * valid routes:
 *      have two non equal stations
 *      are either horizontal or vertical
 *      origin station must be north or west of destination
 * @author Lauren Egts
 */

//TODO currently doesn't implement the route interface from the model
    //not sure if this is right but the route interface requires a list of model.Track
    //and I need a list of student.Track
public class Route {

    private Baron baron;
    private student.Station origin;
    private student.Station destination;
    private int length;
    private Orientation ort;
    private ArrayList<student.Track> tracks;

    /**
     * constructor
     * creates a route
     * @param origin the station the route originates from
     * @param destination the station the route will go to
     * @param orientation the orientation of the route, either vertical or horizontal
     */
    public Route(student.Station origin, student.Station destination, Orientation orientation) {
        this.baron = Baron.UNCLAIMED;
        //baron is set to unclaimed because when created route won't have a baron
        this.origin = origin;
        this.destination = destination;
        //this.length = length;
        this.ort = orientation;

        tracks = new ArrayList<>();

        if (ort.toString().equals("VERTICAL")) {
            this.length = destination.getRow() - origin.getRow() - 1;
            System.out.println(length);
        } else {
            this.length = destination.getCol() - origin.getCol() - 1;
            System.out.println(length);
        }

        /**
         * check for invalid routes
         * origin and destination stations are on same space
         * origin is not north from destination
         * origin is not west from destination
         * if route is invalid, throws an invalid route exception
         */


        if (origin.collocated(destination)) { //case origin and destination are on same space
            try {
                throw new InvalidRouteException(origin, destination);
            } catch (InvalidRouteException e) {
                System.out.println("Invalid route");
            }
        } else if (ort.toString().equals("HORIZONTAL")) { //case horizontal orientation
            if(!(origin.getRow() == destination.getRow() && origin.getCol() < destination.getCol() && ort.toString().equals("HORIZONTAL") && length >= 1)) {
                //if proposed route doesn't meet the conditions for it to be valid
                try {
                    throw new InvalidRouteException(origin, destination);
                } catch (InvalidRouteException e) {
                    System.out.println("Invalid route");
                }
            }
        } else if (ort.toString().equals("VERTICAL")) { //case vertical orientation
            if(!(origin.getRow() < destination.getRow() && origin.getCol() == destination.getCol() && ort.toString().equals("VERTICAL") && length >= 1)) {
                //if proposed route doesn't meet the conditions for it to be valid
                try {
                    throw new InvalidRouteException(origin, destination);
                } catch (InvalidRouteException e) {
                    System.out.println("Invalid route");
                }
            }
        } else{ //i need an else statement because i had else ifs but this shouldn't do anything and if it does run something is very wrong
            System.out.println("valid route");
        }

        if (ort.toString().equals("HORIZONTAL")) { //case HORIZONTAL ORIENTATION
            for (int y = origin.getCol(); y < destination.getCol() - 1; y++) {
                student.Track newTrack = new student.Track(ort, this, origin.getRow(), y);
                tracks.add(newTrack);
            }
        } else { //case VERTICAL ORIENTATION
            for (int x = origin.getRow(); x < destination.getCol() - 1; x++) {
                Track newTrack = new Track(ort, this, x, origin.getCol());
                tracks.add(newTrack);
            }
        }
    }


    /**
     * gets the route's owner
     * @return the route's owner
     */
    public Baron getBaron() {
        return baron;
    }

    /**
     * gets the origin station
     * @return the origin station
     */
    public Station getOrigin() {
        return origin;
    }

    /**
     * gets the destination station
     * @return the destination station
     */
    public Station getDestination() {
        return destination;
    }

    /**
     * gets the route's orientation
     * @return the route's orientation
     */
    public Orientation getOrt() {
        return ort;
    }

    /**
     * gets the route's tracks
     * @return the route's tracks
     */
    public List<student.Track> getTracks() {
        return tracks;
    }

    /**
     * gets the route's length
     * @return the route's length
     */
    public int getLength() {
        return length;
    }

    /**
     * calculates the route's point value based on its length
     *  1 - 1 point 2 - 2 points 3 - 4 points 4 - 7 points 5 - 10 points
     *  6 - 15 points 7 (or more) - 5 * (length - 3) points
     * @return how many points this route is worth
     */
    public int getPointValue() {
        switch (length){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 10;
            case 6:
                return 15;
            default:
                return 5*(length-3);
        }
    }

    /**
     * checks to see if the route includes a given space
     * @param space the space to check whether or not it is in the route
     * @return true if the space is in the route's path, false otherwise
     */
    public boolean includesCoordinate(Space space) {
        for(student.Track track : tracks){
            if(track.collocated(space)){
                return true;
            }
        }
        return false;
    }

    /**
     * this method attempts to claim the route for a baron (claimant)
     * if the route's current baron is UNCLAIMED the method will return true indicating that the claim was successful
     * otherwise it will return false
     */
    public boolean claim(Baron claimant) {
        if(baron.name().equals("UNCLAIMED")){
            baron = claimant;
            for(student.Track track : tracks){
                track.claim(claimant);
            }
            return true;
        }
        return false;
    }
}
