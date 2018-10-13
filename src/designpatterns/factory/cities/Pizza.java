package designpatterns.factory.cities;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

/**
 * @author james reall008@163.com  10/14/2018
 */
public abstract class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<String>();

    void prepare() {
        System.out.println("Prepare " + name);
        System.out.println("Tossing dough ...");
        System.out.println("Adding toppings: " );
        for (String topping : toppings) {
            System.out.println("    " + topping);
        }
    }

    void bake() {
        System.out.println("Bake for 25 minutes at ...");
    }

    void cut() {
        System.out.println("Cut the pizza into diagonal slices");
    }
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- " + name + " ----\n");
        sb.append(dough + "\n");
        sb.append(sauce + "\n");
        for (String topping : toppings) {
            sb.append(topping + "\n");
        }
        return sb.toString();
    }
}
