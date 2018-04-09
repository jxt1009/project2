package testsrc;

import model.Baron;
import model.Orientation;
import student.Route;
import student.Station;
import student.Track;

public class TestTrack {

    private student.Track track1;
    private student.Track track2;
    private student.Station station1;
    private student.Station station2;
    private student.Route route;

    public TestTrack(){

        station1 = new Station("station2", 1, 3);
        station2 = new Station("station3", 3, 3);
        route = new Route(station1, station2, 3, Orientation.VERTICAL);

        //    public Track(Orientation ort, student.Route route, int row, int col){
        track1 = new Track(Orientation.VERTICAL, route, 1, 1);
        track2 =  new Track(Orientation.HORIZONTAL, route, 1, 3);
        //    public Route(Station origin, Station destination, int length, Orientation orientation){
    }

    private void test(){
        System.out.println("this should print out that track1's owner is UNCLAIMED");
        System.out.println(track1.getBaron());
        track1.claim(Baron.RED);
        System.out.println("this should print out that track1's owner is RED");
        System.out.println(track1.getBaron());
        System.out.println("this should print out track1's orientation, which is vertical");
        System.out.println(track1.getOrientation());
        System.out.println("this should print out track2's orientation, which is horizontal");
        System.out.println(track2.getOrientation());
        System.out.println("this should print out track1's route");
        System.out.println(track1.getRoute());
    }

    public static void main(String[] args){
        TestTrack test = new TestTrack();
        test.test();
    }
}
