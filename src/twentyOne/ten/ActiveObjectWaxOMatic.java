package twentyOne.ten;

import java.util.concurrent.*;

/**
 * @author james reall008@163.com  10/5/2018
 */
class ActiveCar {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private enum Action {
        WAX,
        BUFF
    }

    private Action lastAction = Action.BUFF;
    private boolean waxOn;

    public void shutdown() {
        executorService.shutdown();
    }

    private static void pause(int sleep_time) {
        try {
            TimeUnit.MILLISECONDS.sleep(sleep_time);
        } catch(InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    private class WaxingTask implements Runnable {
        @Override
        public void run() {
            if(lastAction != Action.WAX) {
                System.out.println("Wax On! ");
                pause(200);
                waxOn = true;
                lastAction = Action.WAX;
            }
        }
    }
    private final WaxingTask waxingTask = new WaxingTask();

    private class BuffingTask implements Runnable {
        @Override
        public void run() {
            if(lastAction != Action.BUFF) {
                System.out.println("Wax Off! ");
                pause(200);
                waxOn = false;
                lastAction = Action.BUFF;
            }
        }
    }
    private final BuffingTask buffingTask = new BuffingTask();

    public void wax() {
        try {
            executorService.execute(waxingTask);
        } catch(RejectedExecutionException e) {}
    }

    public void buff() {
        try {
            executorService.execute(buffingTask);
        } catch(RejectedExecutionException e) {}
    }
}

class WaxCar implements Runnable {
    private final ActiveCar car;
    public WaxCar(ActiveCar c) {
        car = c;
    }

    @Override
    public void run() {
        car.wax();
    }
}

class BuffCar implements Runnable {
    private final ActiveCar car;
    public BuffCar(ActiveCar c) {
        car = c;
    }

    @Override
    public void run() {
        car.buff();
    }
}

public class ActiveObjectWaxOMatic {
    public static void main(String[] args) throws Exception {
        ActiveCar car = new ActiveCar();
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
        exec.scheduleAtFixedRate(new BuffCar(car), 0, 200, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(new WaxCar(car), 0, 200, TimeUnit.MILLISECONDS);
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
        car.shutdown();
    }


}
