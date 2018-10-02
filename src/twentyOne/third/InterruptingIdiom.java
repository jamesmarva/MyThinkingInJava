package twentyOne.third;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by james on 10/2/2018.
 */

class NeedCleanup {

    private final int id;

    public NeedCleanup(int ident) {
        this.id = ident;
        System.out.println("NeedsCleanup:");
    }

    public void cleanup() {
        System.out.println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {

    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                NeedCleanup n1 = new NeedCleanup(1);
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedCleanup n2 = new NeedCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 0; i < 250000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time-consuming operation");
                    } finally {
                            n2.cleanup();
                    }
                } finally {
                   n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exiting via InterruptedException");
        }
    }
}


public class InterruptingIdiom {

    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            System.out.println("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }
        Thread thead = new Thread(new Blocked3());
        thead.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        thead.interrupt();
    }

}
