package designpatterns.decorator.star;

/**
 * @author james reall008@163.com  10/10/2018
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
