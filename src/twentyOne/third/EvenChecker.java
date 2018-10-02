package twentyOne.third;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by james on 9/23/2018.
 */
public class EvenChecker implements Runnable {

    private IntGenerator intGenerator;

    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        this.intGenerator = g;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int value = intGenerator.next();
            if (value % 2 != 0) {
                System.out.println(value + " not even!");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit.");
        ExecutorService exec = Executors.newCachedThreadPool();
        System.out.println("count: " + count);
        for(int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
