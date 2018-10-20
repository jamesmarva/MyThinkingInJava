package designpatterns.combining.decorator;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class DecoyDuck implements Quackable{

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }

    public String toString() {
        return "Decoy Duck";
    }
}
