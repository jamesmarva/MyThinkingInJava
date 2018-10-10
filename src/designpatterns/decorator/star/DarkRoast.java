package designpatterns.decorator.star;

import java.util.Date;

/**
 * @author james reall008@163.com  10/10/2018
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 2.99;
    }
}
