package twentyOne.second;

/**
 * Created by james on 9/23/2018.
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;

    //Static 在class中，方法区？
//    方法区：静态属性，常量池，代码片段。
    private static int taskCount = 0;

    // 类一旦初始化成为对象之后，final的变量就不可以改变了。
    private final int id = taskCount++;

    public String status() {
        return "# " + id +" () " + (countDown > 0? countDown : "lift off!");
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
//            taskCount ++;
            System.out.println(status());
//            什么作用？

            Thread.yield();
        }
    }

//    public static void main(String[] args) throws InterruptedException {
//        LiftOff liftOff = new LiftOff();
//
//        new Thread(liftOff).start();
//
//        Thread.sleep(12);
//        LiftOff liftOff1 = new LiftOff();
//
//        new Thread(liftOff1).start();
//
//    }

    public static void main(String[] args) {
        for(int i = 0; i < 5; i ++) {
//            System.out.println(i );
//            LiftOff liftOff = new LiftOff();
            new Thread(new LiftOff()).start();
        }
    }


}
