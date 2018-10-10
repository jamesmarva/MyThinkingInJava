package designpatterns.decorator.star;

/**
 * @author james reall008@163.com  10/10/2018
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decat";
    }

    @Override
    public double cost() {
        return 0;
    }
}
