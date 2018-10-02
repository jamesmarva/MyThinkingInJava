package twentyOne.third;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by james on 9/28/2018.
 */
public class MutexEventGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
//        return 0;
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEventGenerator());
    }

}
