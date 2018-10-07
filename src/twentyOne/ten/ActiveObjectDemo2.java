package twentyOne.ten;

import twentyOne.seventh.ActiveObjectDemo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author james reall008@163.com  10/5/2018
 */
public class ActiveObjectDemo2 {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Random random = new Random(47);
    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(
                    100 + random.nextInt(factor));
        } catch(InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }
    public Future<Integer> calculateInt(final int x, final int y) {
        return executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println("float starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public Future<Float> calculateFloat(final float x, final float y) {
        return executorService.submit(new Callable<Float>() {
            @Override
            public Float call() {
                System.out.println("int starting " + x + " + " + y);
                pause(2000);
                return x + y;
            }
        });
    }

    public void printDocument(final String s) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("printing document " + s);
                pause(1000);
                System.out.println("document " + s + " printed");
            }
        });
    }

    public void shutdown() {
        executorService.shutdownNow();
    }

    public static void main(String[] args) {
        ActiveObjectDemo2 activeObjectDemo = new ActiveObjectDemo2();
        List<Future<?>> results = new CopyOnWriteArrayList<>();
        for (float f = 0.0f; f < 1.0f; f+=0.2f) {
            results.add(activeObjectDemo.calculateFloat(f, f));
        }

        for (int i = 0; i < 5; i++) {
            results.add(activeObjectDemo.calculateInt(i, i));
            activeObjectDemo.printDocument("DOC_" + i);
        }

        System.out.println("All asynch calls made");
        while (results.size() > 0) {
            for (Future<?> f : results) {
                if (f.isDone()) {
                    try {
                        System.out.println("f.get() " + f.get() + f.get().getClass());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    results.remove(f);
                }
            }
        }
        activeObjectDemo.shutdown();
    }
}
