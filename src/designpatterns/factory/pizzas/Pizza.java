package designpatterns.factory.pizzas;

import java.util.ArrayList;

/**
 * @author james reall008@163.com  10/13/2018
 */
public class Pizza {

    String name;

    //生面团
    String dough;

    //酱
    String sauce;

    //配料
    ArrayList<String> toppings = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public void prepare() {
        System.out.println("Preparing: " + name);
    }

    public void bake() {
        System.out.println("Baking" + name);
    }

    public void cut() {
        System.out.println("Cutting: " + name);
    }

    public void box() {
        System.out.println("Boxing: " + name);
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
