package twentyOne.third;

/**
 * Created by james on 10/2/2018.
 */
class DualSynch {
    private final Object syncObject = new Object();
    synchronized void f() {
        for(int i = 0; i < 501; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g() {
        synchronized(syncObject) {
            for(int i = 0; i < 501; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    // 如果遇到这种情况，那么就是会有线程的阻塞。
    void h() {
        synchronized(this) {
            for(int i = 0; i < 501; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
//        (Thread) run() -> {ds.f();}.start();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.h();
    }
}