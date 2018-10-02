package twentyOne.third;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by james on 9/30/2018.
 */
class AtomicityTest2 implements Runnable {
    private int i;

    public synchronized int getValue() {
        return this.i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}

public class E12_AtomicityTest2 {

    public static void main(String[] args) {
        System.out.println("Press Control-C to exit.");
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest2 at = new AtomicityTest2();
        exec.execute(at);
        while (true) {
            int value = at.getValue();
            if (value % 2 != 0) {
                System.out.println(value);
            }
        }
    }


}
