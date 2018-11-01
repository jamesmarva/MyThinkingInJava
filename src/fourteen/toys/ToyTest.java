package fourteen.toys;

import designpatterns.factory.Ingredient.Clams;

/**
 * @author james reall008@163.com  10/30/2018
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    Toy() {}
    Toy(int i) {}
}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1); }
}

public class ToyTest {
    static void printInfo(Class ccccc) {
        System.out.println("Class name: " + ccccc.getName() +
                " is interface? [" + ccccc.isInterface() + "]");
        System.out.println("Simple name: " + ccccc.getSimpleName());
        System.out.println("Canonical name : " + ccccc.getCanonicalName());
        System.out.println("");
    }

    public static void main(String[] args) {
        Class clazz = null;
        Class clazz1 = null;
        Class clazz2= null;
        Class clazz3 = null;

        try {
            clazz = Class.forName("fourteen.toys.FancyToy");
            clazz1 = Class.forName("fourteen.toys.Shoots");
            clazz2 = Class.forName("fourteen.toys.HasBatteries");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
//        printInfo(clazz);
//        printInfo(clazz1);
//        printInfo(clazz2);
//        for(Class face : clazz.getInterfaces()) {
//            printInfo(face);
//        }
        Class up = clazz.getSuperclass();
        Object obj = null;
        Toy toy = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
            toy = (Toy) up.newInstance();
        } catch(InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch(IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
//        printInfo(obj.getClass());
        printInfo(toy.getClass());
    }


}
