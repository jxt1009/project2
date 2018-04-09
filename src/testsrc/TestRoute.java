package testsrc;

import model.Baron;
import model.Orientation;
import student.Route;
import student.Station;

public class TestRoute {

    private Station station1;
    private Station station2;
    private Station station3;
    private Station station4;
    private Route route1;
    private Route route2;

    public TestRoute(){

        station1 = new Station("station1", 1, 3);
        station2 = new Station("station2", 3, 3);
        station3 = new Station("station3", 2, 3);
        station4 = new Station("station4", 2, 2);

        route1 = new Route(station1, station2, 7, Orientation.HORIZONTAL);
        route2 = new Route(station4, station3, 2, Orientation.VERTICAL);
    }

    public void test(){
        System.out.println("this should print out the origin station");
        System.out.println(route1.getOrigin());
        System.out.println("this should print out the destination station");
        System.out.println(route1.getDestination());
        System.out.println("this should print out the length, 7");
        System.out.println(route1.getLength());
        System.out.println("this should print out the current baron, UNCLAIMED");
        System.out.println(route1.getBaron());
        route1.claim(Baron.RED);
        System.out.println("this should print out the current baron, RED");
        System.out.println(route1.getBaron());
        System.out.println("this should print out how many points the route1 is worth, 20");
        System.out.println(route1.getPointValue());
        System.out.println("this should print out the orientation, VERTICAL");
        System.out.println(route1.getOrt());
        System.out.println("this should print out the tracks associated with this route1, should be 2");
        System.out.println(route1.getTracks());
        System.out.println("testing includesCoordinate, should be true");
        System.out.println(route1.includesCoordinate(station3));
        System.out.println("testing includesCoordinate, should be false");
        System.out.println(route1.includesCoordinate(station4));
        System.out.println("testing vertical orientation getTracks");
        System.out.println(route2.getTracks());
        System.out.println("testing vertical orientation includesCoordinates, should be true");
        System.out.println(route2.includesCoordinate(station4));
        System.out.println("testing vertical orientation includesCoordinates, should be false");
        System.out.println(route2.includesCoordinate(station1));
    }

    private void testForErrors(){
        //each of these routes should throw exceptions because they are invalid
        //TODO add additional test cases, make sure that diagonal stations fail
        Route failRoute1 = new Route(station2, station1, 3, Orientation.VERTICAL);
        Route failRoute2 = new Route(station1, station4, 5, Orientation.HORIZONTAL);
    }

    public static void main(String[] args){
        TestRoute test = new TestRoute();
        test.test();
        test.testForErrors();
    }
}
