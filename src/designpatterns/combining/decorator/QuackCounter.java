package designpatterns.combining.decorator;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class QuackCounter implements Quackable {

    Quackable quackable;

    static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.quackable = duck;

    }

    @Override
    public void quack() {
        quackable.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }
}
