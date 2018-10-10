package designpatterns.decorator.star;

/**
 * @author james reall008@163.com  10/11/2018
 */
public class Whip extends CondimentDecorator{

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;

    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip.";
    }

    @Override
    public double cost() {
        return 3 + beverage.cost();
    }
}
