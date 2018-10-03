package twentyOne.fifth;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by james on 10/3/2018.
 */
class MyCarProcess {

    private boolean waxed = false;
    private boolean buffed = false;

    public synchronized void waitForWaxing() throws InterruptedException {
        System.out.println("wait to wax");
        while(!this.waxed) {
            wait();
        }
    }

    public synchronized void wax() {
        System.out.println("wax the car");
        waxed = true;
        notifyAll();
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        System.out.println("wait to buff.");
        while (!this.buffed && this.waxed) {
            System.out.println("waitForBuffing wait().............................");
            wait();
        }
    }

    public synchronized void buffed() {
        System.out.println("buff the car");
        buffed = true;
        notifyAll();

    }
}

class WaxCar implements Runnable {

    private MyCarProcess myCarProcess;

    public WaxCar(MyCarProcess carProcess) {
        this.myCarProcess = carProcess;
    }

    @Override
    public void run() {
        try {
            System.out.println("begin to wax car");
            myCarProcess.wax();
            myCarProcess.waitForBuffing();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class BuffCar implements Runnable {

    private MyCarProcess myCarProcess;

    public BuffCar(MyCarProcess myCarProcess) {
        this.myCarProcess = myCarProcess;
    }

    @Override
    public void run() {
        try {
            System.out.println("/n begin to buff");
            myCarProcess.buffed();
            myCarProcess.waitForWaxing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MyCarWaxBuff {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(12));
        MyCarProcess myCarProcess = new MyCarProcess();
        threadPoolExecutor.execute(new WaxCar(myCarProcess));
        TimeUnit.MILLISECONDS.sleep(10);
        threadPoolExecutor.execute(new BuffCar(myCarProcess));
        TimeUnit.SECONDS.sleep(2);
        threadPoolExecutor.shutdownNow();
    }
}
