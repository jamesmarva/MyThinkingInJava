package twentyOne.second;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by james on 9/24/2018.
 */
public class SleepingTask2 implements Runnable {

    private static Random random = new Random();

    private final int sleep_time = random.nextInt(10) + 1;

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(sleep_time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sleep_time);
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
//        if (args.length != 1) {
//            System.out.println("")
//        }
        for (int i = 0; i < 10; i++) {
            exec.execute(new SleepingTask2());
        }
        Thread.yield();
        exec.shutdown();
    }
}
