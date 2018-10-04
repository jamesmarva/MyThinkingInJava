package twentyOne.seventh;

/**
 * 一个测试Pool的类，未完待续。。。
 * @author james
 * @date 10/4/2018
 */

class CheckOutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckOutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {

    }
}

public class SemaphoreDemo {


}
