package twentyOne.third;

/**
 * Created by james on 10/2/2018.
 */
class LiftOff2 implements Runnable {

    protected int countDown = 5000;

    private static int taskCount;

    private final int id = taskCount++;

    public LiftOff2() {}

    public LiftOff2(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +(countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    @Override
    public void run() {

    }
}

public class E20_InterruptCachedThreadPool {
}
