package twentyOne.fifth;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * wait() notify() notifyAll() 是同步控制块。
 * Created by james on 10/2/2018.
 */
class Car {

    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while(waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn == true) {
            wait();
        }
    }
}

class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car c) {
        this.car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10));
        threadPoolExecutor.execute(new WaxOff(car));
        threadPoolExecutor.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        threadPoolExecutor.shutdownNow();

    }
}
