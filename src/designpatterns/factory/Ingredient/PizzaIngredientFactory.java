package designpatterns.factory.Ingredient;

/**
 * @author james reall008@163.com  10/14/2018
 */
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();


}
