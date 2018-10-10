package designpatterns.decorator.star;

/**
 * @author james reall008@163.com  10/10/2018
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
