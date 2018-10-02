package twentyOne.third;

/**
 * Created by james on 9/30/2018.
 */
public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }

}
