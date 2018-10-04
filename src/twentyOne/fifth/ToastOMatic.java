package twentyOne.fifth;

import com.sun.corba.se.impl.oa.toa.TOA;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 简单来说就是三个操作对象，两个队列，第一个对象操作完成后把操作的对象放到第一个队列中，第二个对象继续根据队列中的对象进行操作。
 * 要注意这里使用的数据结构是LinkedBlockingQueue<>
 * @author james
 * @date 10/3/2018
 */

class Toast {
    public enum Status { DRY, BUTTERED, JAMMED }
    private Status status = Status.DRY;
    private final int id;
    public Toast(int idn) {
        id = idn;
    }
    public void butter() {
        status = Status.BUTTERED;
    }
    public void jam() {
        status = Status.JAMMED;
    }
    public Status getStatus() {
        return status;
    }
    public int getId() {
        return id;
    }
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {}

class Toaster implements Runnable {

    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(49);
    public Toaster(ToastQueue tq) {
        toastQueue = tq;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}

class Butterer implements Runnable {

    private ToastQueue dryQueue, butteredQueue;
    public Butterer(ToastQueue dry, ToastQueue buttered) {
        dryQueue = dry;
        butteredQueue = buttered;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off");
    }
}

// Apply jam to buttered toast:
class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;
    public Jammer(ToastQueue buttered, ToastQueue finished) {
        butteredQueue = buttered;
        finishedQueue = finished;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Blocks until next piece of toast is available:
                Toast t = butteredQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch(InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}

class Eater implements Runnable {

    private ToastQueue finishedQueue;
    private int counter = 0;
    public Eater(ToastQueue finished) {
        finishedQueue = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = finishedQueue.take();
                if (toast.getId() != counter++ || toast.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>> Error: " + toast);
                    System.exit(1);
                } else {
                    System.out.println("Chomp: " + toast);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }
}

public class ToastOMatic {

    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue();
        ToastQueue butteredQueue = new ToastQueue();
        ToastQueue finishedQueue = new ToastQueue();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,100,
//                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(100));

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Toaster(dryQueue));
        executor.execute(new Butterer(dryQueue, butteredQueue));
        executor.execute(new Jammer(butteredQueue, finishedQueue));
        executor.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        executor.shutdownNow();
    }


}
