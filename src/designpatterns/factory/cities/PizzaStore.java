package designpatterns.factory.cities;

/**
 * @author james reall008@163.com  10/14/2018
 */
public abstract class PizzaStore {


    //感觉就是工厂模式就是在简单工厂模式上面再封装了一层。但是同样的
    // 也需要更多的子类来实现。
    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }



}
