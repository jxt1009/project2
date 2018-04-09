package testsrc;

public class TestSpace {

    private student.Space space1;
    private student.Space space2;
    private student.Space space3;

    public TestSpace(){
        space1 = new student.Space(1, 3);
        space2 = new student.Space(1, 3);
        space3 = new student.Space(3, 1);
    }

    public static void main(String[] args){
        TestSpace testSpace = new TestSpace();
        testSpace.test();
    }

    private void test(){
        System.out.println("space1 row and column test.  the following should be 1, 3: ");
        System.out.println(space1.getRow() + ", " + space1.getCol());
        System.out.println("comparing space1 (1,3) to space2 (1,3).  should be true");
        System.out.println(space1.collocated(space2));
        System.out.println("comparing space2 (1,3) to space3 (3,1).  should be false");
        System.out.println(space2.collocated(space3));
    }
}
