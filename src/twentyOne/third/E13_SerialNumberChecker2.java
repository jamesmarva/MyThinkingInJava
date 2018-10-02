package twentyOne.third;

import com.sun.org.apache.xml.internal.security.signature.reference.ReferenceNodeSetData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by james on 9/30/2018.
 */

class SerialNumberGenerator2 {
    private static int serialNumber;
    public synchronized static int nextSerialNumber() {
        return serialNumber++;
    }
}
public class E13_SerialNumberChecker2 {

    private static final int SIZE = 10;

    private static CircularSet serials = new CircularSet(1000);

    private static ExecutorService exec = Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            while ( true) {
                int serial = SerialNumberGenerator2.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicate detected.");
            System.exit(0);
        } else {
            System.err.println("Provide a sleep time in sec.");
            System.exit(1);
        }
    }
}
