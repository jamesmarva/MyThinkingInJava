package twenty.one;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author james reall008@163.com  10/7/2018
 */
public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length > 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }

        String[] myArgs = {"twenty.one.Member"};

        for (String className : myArgs) {
            Class<?> clazz = Class.forName(className);
            DBTable dbTable = clazz.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
//            如果名字为空，那么使用类名称。
            if (tableName.length() < 1) {
                tableName = clazz.getName().toUpperCase();
            }
            List<String> columnsDefs = new ArrayList<>();
            for (Field field : clazz.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    // use field  name if name not specified.
                    if(sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnsDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    if(sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnsDefs.add(columnName + " VARCHAR(" + sString.value() + ")" +
                            getConstraints(sString.constraints()));
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for(String columnDef : columnsDefs) {
                    createCommand.append("\n    " + columnDef + ",");
                }

                // Remove trailing comma
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
             }
        }

    }

//
//    private static String getName() {
//
//    }

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
