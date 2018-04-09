package testsrc;

import student.Station;

public class TestStation {

    private student.Station station1;
    private student.Station station2;
    private student.Station station3;


    public TestStation(){
        station1 = new Station("station1", 1, 3);
        station2 = new Station("station2", 1, 3);
        station3 = new Station("station3", 3, 3);

    }

    private void test(){
        System.out.println("the following should print out station1");
        System.out.println(station1.getName());
        System.out.println("the following should print out station2's coords (1, 3)");
        System.out.println(station2.getRow() + ", " + station2.getCol());
        System.out.println("the following tests the collocated method, should be true");
        System.out.println(station1.collocated(station2));
        System.out.println("the following tests the collocated method, should be false");
        System.out.println(station1.collocated(station3));
    }

    public static void main(String[] args){
        TestStation testStation = new TestStation();
        testStation.test();
    }
}
