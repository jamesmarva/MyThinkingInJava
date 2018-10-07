package twenty.one;

/**
 * @author james reall008@163.com  10/7/2018
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique=true);
}
