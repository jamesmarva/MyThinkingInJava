package twentyOne.second;

/**
 * Created by james on 9/23/2018.
 */
public class Printer implements Runnable {

    private static int taskCount;

    private final int id = taskCount++;

    Printer() {
        System.out.println("Printer started. ID = " + id);
    }

    @Override
    public void run() {
        System.out.println("stage 1 ... ID = " + id);
        Thread.yield();

        System.out.println("stage 2 ... ID = " + id);
        Thread.yield();

        System.out.println("stage 3 ... ID = " + id);
        Thread.yield();

        System.out.println("Printer ended. ID = " + id);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Printer()).start();
        }
    }

}
