package designpatterns.combining.adapter;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class RubberDuck implements Quackable {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
