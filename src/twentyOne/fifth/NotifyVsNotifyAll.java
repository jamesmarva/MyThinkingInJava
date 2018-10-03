package twentyOne.fifth;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * fe
 * Created by james on 10/3/2018.
 */
class Blocker {

    synchronized void waitingCall() {
        try {
            while(!Thread.interrupted()) {
                wait();
                System.out.print(Thread.currentThread() + " ");
            }
        } catch(InterruptedException e) {
            // OK to exit this way
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}

class Task implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {
    // A separate Blocker object:
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}


public class NotifyVsNotifyAll {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(12));
        for(int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new Task());
        }
        threadPoolExecutor.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if(prod) {
                    System.out.print("\n notify() ");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.print("\n notifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400); // Run every .4 second
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        timer.cancel();
        System.out.println("\n Timer canceled");

        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("Task2.blocker.prodAll() ");

        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("\n Shutting down");
        threadPoolExecutor.shutdownNow(); // Interrupt all tasks
    }
}
