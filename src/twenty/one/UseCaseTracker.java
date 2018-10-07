package twenty.one;

import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author james reall008@163.com  10/7/2018
 */
public class UseCaseTracker {

    public static void  trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getDeclaredMethods()) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println("Found Use Case:" + useCase.id() + " "
                        + useCase.description());
                useCases.remove(useCase.id());
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 57, 67, 77);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
