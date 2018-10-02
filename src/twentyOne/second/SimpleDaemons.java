package twentyOne.second;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程和开的线程有什么区别？
 * 后天的线程是和非后台的线程同步结束的，
 * 比如这给个程序，如果没有设置成后台的线程，那么，这个线程就会一直执行下去的，不会停止，但是如果是设置成后台线程，那么随着主程序休眠后，
 * 主程序结束后台线程也随之结束。
 * Created by james on 9/24/2018.
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
//            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        System.out.print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(20000);
    }
}
