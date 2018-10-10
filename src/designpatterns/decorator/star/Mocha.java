package designpatterns.decorator.star;

/**
 * @author james reall008@163.com  10/10/2018
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 2 + beverage.cost();
    }
}
