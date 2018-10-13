package designpatterns.factory.cities;

/**
 * @author james reall008@163.com  10/14/2018
 */
public class ChicagoStylePepperoniPizza extends Pizza {

    // 构造器中对类中的几个成员变量进行赋值。
    public ChicagoStylePepperoniPizza() {
        name = "Chicago Style Pepperoni Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Black Olives");
        toppings.add("Spinach");
        toppings.add("Eggplant");
        toppings.add("Sliced Pepperoni");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }

}
