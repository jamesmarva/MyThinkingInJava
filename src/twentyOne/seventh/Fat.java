package twentyOne.seventh;

/**
 * volatile 这个关键字之于成员变量，就像synchronized 之于方法一样。
 * @author james
 * @date 10/4/2018
 */
public class Fat {
    private volatile double d; // Prevent optimization
    private static int counter = 0;
    private final int id = counter++;
    public Fat() {
        // Expensive, interruptible operation:
        for(int i = 1; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double)i;
        }
    }
    public void operation() {
        System.out.println(this);
    }
    public String toString() {
        return "Fat id: " + id;
    }
}