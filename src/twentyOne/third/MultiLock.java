package twentyOne.third;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by james on 10/2/2018.
 */
public class MultiLock {


    public synchronized void first(int count) {
        if (count-- > 0) {
            System.out.println("first() calling second with count " + count);
            second(count);
        }
    }

    public synchronized void second(int count) {
        if (count-- > 0) {
            System.out.println("Second() calling first() with count " + count);
        }
        first(count);
    }

    public static void main(String[] args) {
        final MultiLock multiLock = new MultiLock();
        new Thread() {
            @Override
            public void run() {
                multiLock.first(10);
            }
        }.start();
    }

}
