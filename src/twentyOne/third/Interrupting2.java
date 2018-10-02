package twentyOne.third;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by james on 10/2/2018.
 */
class BlockedMutex {

    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
    }

    public void first() {
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquired in first() ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Blocked2 implements Runnable {

    BlockedMutex blockedMutex = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for first() in BlockMutex");
        blockedMutex.first();
        System.out.println("Broken out of blocked call");
    }
}

public class Interrupting2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Blocked2());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt() ");
        thread.interrupt();
    }






}
