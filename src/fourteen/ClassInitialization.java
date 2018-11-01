package fourteen;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Random;

/**
 * @author james reall008@163.com  10/30/2018
 */
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 =
            ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random rand = new Random(47);
    
    public static void main(String[] args) {
//        System.out.println(1 / 2);
        System.out.println(countBits(2));


    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int temp = 0;
            int tempNum = i;
            while(tempNum/2 != 0) {
                temp = temp + tempNum % 2;
                tempNum = tempNum/2;
            }
            result[i] = temp;
            System.out.println(temp);
        }
        return result;
    }

}
