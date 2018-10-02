package twentyOne.second;

/**
 * Created by james on 9/23/2018.
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("i :" + i + " " + this.getName());
        }
    }
    public static void main(String[] args) {
        Thread thread = new TestThread();
        Thread thread2 = new TestThread();
        thread.start();
        thread2.start();
    }
}
