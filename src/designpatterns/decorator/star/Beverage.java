package designpatterns.decorator.star;

/**
 * @author james reall008@163.com  10/10/2018
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
