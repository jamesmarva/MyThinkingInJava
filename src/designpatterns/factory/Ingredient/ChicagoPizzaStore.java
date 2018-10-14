package designpatterns.factory.Ingredient;

/**
 * @author james reall008@163.com  10/14/2018
 */
public class ChicagoPizzaStore extends PizzaStore {

    PizzaIngredientFactory ingredientFactory =
            new ChicagoPizzaIngredientFactory();

    @Override
    protected Pizza createPizza(String item) {
        return null;
    }
}
