package twentyOne.third;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by james on 10/2/2018.
 */
class Accessor implements Runnable {

    private final int id;

    Accessor(int idn) {
        this.id = idn;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {

    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {

        private Random random = new Random(47);

        @Override
        protected synchronized Integer initialValue() {
            return random.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(12));
//        for(int i = 0; i < 5; i++) {
//            exec.execute(new Accessor(i));
//        }

        for(int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new Accessor(i));
        }

        TimeUnit.SECONDS.sleep(2);  // Run for a while
        exec.shutdownNow();         // All Accessors will quit
    }
}
