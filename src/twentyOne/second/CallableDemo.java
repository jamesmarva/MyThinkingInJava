package twentyOne.second;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by james on 9/24/2018.
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new StringTaskWithResult(i + "")));
        }
        for (Future<String> fs : results) {
//            try {
//                // get() blocks until completion.
//                System.out.println(fs.get());
//            } catch (InterruptedException e) {
//                System.out.println(e);
//                e.printStackTrace();
//                return;
//            } catch (ExecutionException e) {
//                System.out.println(e);
//                e.printStackTrace();
//                return;
//            } finally {
////                executorService.shutdown();
//            }
        }

        Future<String> future = executorService.submit(new StringTaskWithResult(111 + ""));
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return;
        } finally {
//            executorService.shutdown();
        }

        Future<Integer> fu = executorService.submit(new IntTaskWithResult(123));
        try {
            System.out.println(fu.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
class StringTaskWithResult implements Callable<String> {
    private String id;

    public StringTaskWithResult(String id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "result of TaskWithResult " + id;
    }
}

class IntTaskWithResult implements Callable<Integer> {

    private int id = 0;

    IntTaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        return id + 12;
    }
}