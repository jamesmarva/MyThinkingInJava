package twentyOne.third;

import twentyOne.second.TestStatic;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by james on 9/30/2018.
 */
public class TestPrivate {


    private int value = 0;

    private int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "this is my override method.";
    }


    public static void main(String[] args) {

        TestPrivate testPrivate = new TestPrivate();
        System.out.println(testPrivate.getValue());


        AtomicityTest atomicityTest = new AtomicityTest();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(12));
        threadPoolExecutor.execute(atomicityTest);
//        threadPoolExecutor.sub
//        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();
        System.out.print(atomicityTest);
    }
}
