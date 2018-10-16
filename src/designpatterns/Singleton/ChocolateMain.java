package designpatterns.Singleton;

/**
 * @author james reall008@163.com  10/15/2018
 */
public class ChocolateMain {
    public static void main(String args[]) {
        Chocolate boiler = Chocolate.getInstance();
        boiler.fill();
        boiler.boil();
        boiler.drain();

        // will return the existing instance
        Chocolate boiler2 = Chocolate.getInstance();
    }
}
