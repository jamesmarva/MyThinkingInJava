package twentyOne.second;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newCacheThreadPool
 * newSingleThreadPool
 * newFixedThreadPool
 *
 * Created by james on 9/23/2018.
 */
public class CachedThreadPool {

    public static void main(String[] args) {
//        CachedThreadPool
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new LiftOff());
//        }
//        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
//            executorService1.execute(new LiftOff());
        }
        executorService1.shutdown();

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService2.execute(new LiftOff());
        }
        executorService2.shutdown();



    }
}
