package twenty.one;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author james reall008@163.com  10/8/2018
 */
public class E01_TableCreator {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("twenty.one.E01_Member");
        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : clazz.getDeclaredFields()) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations[0] instanceof SQLString) {
                SQLString sqlString = (SQLString) annotations[0];
                System.out.println(sqlString.name());
            }

            if (annotations[0] instanceof SQLInteger) {
                SQLInteger sqlInteger = (SQLInteger) annotations[0];
                System.out.println(sqlInteger.name());
            }

            if (annotations[0] instanceof SQLBoolean) {
                SQLBoolean sqlBoolean = (SQLBoolean) annotations[0];
            }

            if (annotations[0] instanceof SQLCharacter) {
                SQLCharacter sqlCharacter = (SQLCharacter) annotations[0];
            }

            if (annotations[0] instanceof Constraints) {
                Constraints constraints = (Constraints) annotations[0];
            }
        }
        Method[] methods = clazz.getDeclaredMethods();

    }

    private static String getConstraints(Constraints con) {
        String constraints = "";

        if(!con.allowNull()) {
            constraints += " NOT NULL";
        }

        if(con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }

        if(con.unique()) {
            constraints += " UNIQUE";
        }

        return constraints;
    }


}
