package twentyOne.third;

import twentyOne.second.ThreadPoolExecutorDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by james on 9/30/2018.
 */
public class AtomicityTest implements Runnable {

    private int i = 0;

    private int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while(true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        ExecutorService exe =

        TestPrivate testPrivate = new TestPrivate();
        System.out.println(testPrivate.getClass().newInstance().toString());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(12));
        AtomicityTest at = new AtomicityTest();
        threadPoolExecutor.execute(new AtomicityTest());
        while(true) {
            int value = at.getValue();
            if (value % 2 != 0) {
                System.out.println(value);
                System.exit(0);
            }
        }
//        threadPoolExecutor.shutdown();
    }


}
