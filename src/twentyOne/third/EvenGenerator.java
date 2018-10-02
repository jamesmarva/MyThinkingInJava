package twentyOne.third;

/**
 * Created by james on 9/23/2018.
 */
public class EvenGenerator extends IntGenerator {

    private int currentEventValue = 0;

    @Override
    public int next() {
        ++currentEventValue;
//        System.out.println("currentEventValue: " + currentEventValue);

        ++currentEventValue;
//        System.out.println("currentEventValue: " + currentEventValue);

        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
