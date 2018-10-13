package designpatterns.factory.pizzas;

/**
 *
 * 调用了创造pizza的工厂类 SimplePizzaFactory。
 * @author james reall008@163.com  10/13/2018
 */
public  class PizzaStore {

   SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory factory) {
        simplePizzaFactory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = simplePizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }


}
