package twentyOne.fifth;

import twentyOne.second.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author james
 * @date 10/3/2018
 */
class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff liftOff) {
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                System.out.println(Thread.currentThread());
                rocket.run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting LiftOffRunner.");
    }
}

public class TestBlockingQueues {

    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }

    static void getKey() {
//        try {
////            new BufferedReader(new InputStreamReader(System.in)).readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread thread = new Thread(runner);
        thread.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        thread.interrupt();
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", // Unlimited size
                new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", // Fixed size
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", // Size of 1
                new SynchronousQueue<LiftOff>());
    }

}
