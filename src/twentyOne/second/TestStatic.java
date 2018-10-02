package twentyOne.second;

/**
 * Created by james on 9/23/2018.
 */
public class TestStatic {

    private static int count = 0;

    private final int finalCount = count;

    public void printOutCount() {
        System.out.println("count: " + count++);
    }

    public void printOutFinalCount() {
        System.out.println("finalCount: " + finalCount);
    }

    public static void main(String[] args) {
        TestStatic testStatic1 = new TestStatic();
        testStatic1.printOutCount();
        testStatic1.printOutCount();

        testStatic1.printOutCount();
        testStatic1.printOutFinalCount();


        TestStatic testStatic2 = new TestStatic();
        testStatic2.printOutFinalCount();
        testStatic2.printOutCount();
        testStatic2.printOutCount();

//        testStatic
    }

}
