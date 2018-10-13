package designpatterns.factory.pizzas;

/**
 * @author james reall008@163.com  10/13/2018
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza =null;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
            case "clam":
                pizza = new ClamPizza();
                break;
            case "veggie":
                pizza = new VeggiePizza();
                break;
            default:
                pizza = new ClamPizza();
        }
        return pizza;
    }

}
