package designpatterns.factory.cities;

import designpatterns.factory.pizzas.CheesePizza;
import designpatterns.factory.pizzas.ClamPizza;
import designpatterns.factory.pizzas.PepperoniPizza;
import designpatterns.factory.pizzas.VeggiePizza;

/**
 * @author james reall008@163.com  10/14/2018
 */
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza;
        switch (type) {
            case "cheese":
                pizza = new ChicagoStyleCheesePizza();
                break;
            case "pepperoni":
                pizza = new ChicagoStylePepperoniPizza();
                break;
            case "clam":
                pizza = new ChicagoStyleClamPizza();
                break;
            case "veggie":
                pizza = new ChicagoStyleVeggiePizza();
                break;
            default:
                pizza = new ChicagoStyleCheesePizza();
        }
        return pizza;
    }
}
