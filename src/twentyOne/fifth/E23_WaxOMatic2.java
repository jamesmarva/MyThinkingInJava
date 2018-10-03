package twentyOne.fifth;

/**
 *
 * 就是是原来的在例子中的notifyAll() 改成 notify()
 * 感觉wait()就是个锚点，告诉这个程序，你在这里开始等着，如果有人唤醒你，你就从这个锚点开始继续走。
 * Created by james on 10/3/2018.
 */
public class E23_WaxOMatic2 {
    class Car {
        private boolean waxOn;
        public synchronized void waxed() {
            waxOn = true; // Ready to buff
            notify();
        }
        public synchronized void buffed() {
            waxOn = false; // Ready for another coat of wax
            notify();
        }
        public synchronized void waitForWaxing()
                throws InterruptedException {
            while(waxOn == false) {
                wait();
            }
        }
        public synchronized void waitForBuffing()
                throws InterruptedException {
            while(waxOn == true) {
                wait();
            }
        }
    }

}
