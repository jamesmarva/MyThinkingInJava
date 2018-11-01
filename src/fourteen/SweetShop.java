package fourteen;

/**
 * @author james reall008@163.com  10/29/2018
 */
class Candy {
    static { System.out.println("Loading Candy"); }
}

class Gum {
    static { System.out.println("Loading Gum"); }
}

class Cookie {
    static { System.out.println("Loading Cookie"); }
}

public class SweetShop {

//
    public static void main(String[] args) {
        System.out.println("inside ");
        new Candy();
        System.out.println("After");
        try {
            Class.forName("fourteen.Gum");
        } catch(ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
    }
}
