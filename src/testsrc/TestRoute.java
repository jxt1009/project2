package testsrc;

import model.Baron;
import model.Orientation;
import student.Route;
import student.Station;

public class TestRoute {

    private student.Station station1;
    private student.Station station2;
    private student.Station station3;
    private student.Station station4;
    private student.Station station5;
    private student.Route route1;
    private student.Route route2;

    public TestRoute(){

        station1 = new student.Station("station1", 1, 3);
        station2 = new student.Station("station2", 3, 3);
        station3 = new student.Station("station3", 2, 3);
        station4 = new student.Station("station4", 2, 2);
        station5 = new student.Station("station5", 2, 4);

        route1 = new student.Route(station1, station2, Orientation.VERTICAL);
        route2 = new student.Route(station4, station5, Orientation.HORIZONTAL);
    }

    public void test(){
        System.out.println("this should print out the origin station");
        System.out.println("what the route thinks is its origin: " + route1.getOrigin());
        System.out.println("what the test code says the origin is: " + station1);
        System.out.println("this should print out the destination station");
        System.out.println("what the route thinks its destination is: " + route1.getDestination());
        System.out.println("what the test code says the destination is " + station2);
        System.out.println("this should print out the length, 1");
        System.out.println(route1.getLength());
        System.out.println("this should print out the current baron, UNCLAIMED");
        System.out.println(route1.getBaron());
        route1.claim(Baron.RED);
        System.out.println("this should print out the current baron, RED");
        System.out.println(route1.getBaron());
        System.out.println("this should print out how many points the route1 is worth, 1");
        System.out.println(route1.getPointValue());
        System.out.println("this should print out the orientation, VERTICAL");
        System.out.println(route1.getOrt());
        System.out.println("this should print out the tracks associated with this route1, should be 1");
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
        //to use: individually uncomment each failRoute and run one at a time
        //because they throw exceptions, if you try to run all of them at once only the first one will run
        //Route failRoute1 = new Route(station2, station1, Orientation.VERTICAL);
        //Route failRoute2 = new Route(station1, station4, Orientation.HORIZONTAL);
        //Route failRoute3 = new Route(station4, station2, Orientation.VERTICAL);
        //Route failRoute4 = new student.Route(station4, station3, Orientation.HORIZONTAL);
        //Route failRoute5 = new Route(station2, station4, Orientation.VERTICAL);
    }

    public static void main(String[] args){
        TestRoute test = new TestRoute();
        test.test();
        test.testForErrors();
    }
}
