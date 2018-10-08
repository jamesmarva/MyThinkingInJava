package twenty.one;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author james reall008@163.com  10/8/2018
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLCharacter {
    int value() default 0;
    String name() default "";
    Constraints constraints() default @Constraints;
}
