package twenty.one;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author james reall008@163.com  10/22/2018
 */
public class MyUseCaseTracker {

    public void annotationHandler(int id, Class<?> clazz) throws NoSuchMethodException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            System.out.println(useCase.id());
        }

//        Method method = clazz.("validatePassword");
//        UseCase useCaseVoice = method.getAnnotation(UseCase.class);
//        System.out.println(useCaseVoice.description());

    }

    public static void main(String[] args) throws NoSuchMethodException {
        MyUseCaseTracker myUseCaseTracker = new MyUseCaseTracker();
        myUseCaseTracker.annotationHandler(47, PasswordUtils.class);

        List<Integer> listTest = new ArrayList<>();
        Collections.addAll(listTest, 36, 37, 49);
        System.out.println(listTest);
        listTest.remove(new Integer(36));
        System.out.println(listTest);


    }



}
