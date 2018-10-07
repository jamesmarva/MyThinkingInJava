package twentyOne.ten;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author james reall008@163.com  10/5/2018
 */
public class ActiveObjectDemo {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

//    private

    public Future<Float> getFloat(float first, float second) {
        return executorService.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                return first + second;
            }
        });
    }

    public Future<Integer> getInt(int first, int second) {
        return executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return first + second;
            }
        });
    }



}
