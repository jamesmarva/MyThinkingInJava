package twentyOne.fifth;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.event.WindowAdapter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 因为这里是的清洁小工，所以，需要新增加一个变量，来确定是否清洁完毕了，
 * 如果单纯的按照原来的判断meal是否为空已经不能作为判断的根据了。因为场景是需要在确定清洁小工清洁完毕后，服务员再上菜，
 * 所以要在服务员和清洁小工之间再加一个变量。
 * 这个例子目前是失败的。
 * @author James
 * @date 10/3/2018.
 */

class WaitPerson2 implements Runnable {
    private Restaurant2 restaurant2;

    public WaitPerson2(Restaurant2 r) {
        this.restaurant2 = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while(restaurant2.meal == null || restaurant2.ifCleanUp) {
                        wait();
                    }
                }
                System.out.println("waitperson get " + restaurant2.meal);
                synchronized (restaurant2.chef2) {
                    restaurant2.meal = null;
                    restaurant2.chef2.notifyAll();
                }
                synchronized (restaurant2.busBoy) {
                    restaurant2.ifCleanUp = true;
                    restaurant2.busBoy.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class BusBoy implements Runnable {

    Restaurant2 restaurant2;

    public BusBoy(Restaurant2 r) {
        this.restaurant2 = r;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (!restaurant2.ifCleanUp) {
                        wait();
                    }
                }
                System.out.println("BusBoy begin to clean.");
                synchronized (restaurant2.waitPerson2) {
                    restaurant2.ifCleanUp = false;
                    restaurant2.waitPerson2.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("BusBoy interrupted");
        }
    }
}

class Chef2 implements Runnable {
    private Restaurant2 restaurant;
    private int count = 0;

    public Chef2(Restaurant2 r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized (restaurant.waitPerson2) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson2.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (Exception e) {
            System.out.println(" Chef interrupted");
        }
    }
}

class Restaurant2 {

    Meal meal;
    boolean ifCleanUp = false;
    WaitPerson2 waitPerson2 = new WaitPerson2(this);
    Chef2 chef2 = new Chef2(this);
    BusBoy busBoy = new BusBoy(this);

    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant2() {
        exec.execute(chef2);
        exec.execute(waitPerson2);
        exec.execute(busBoy);
    }
}


public class E26_Restaurant2 {
    public static void main(String[] args) {
        new Restaurant2();
    }


}
