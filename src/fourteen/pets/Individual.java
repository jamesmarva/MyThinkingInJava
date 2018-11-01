package fourteen.pets;

/**
 * @author james reall008@163.com  10/30/2018
 */
public class Individual implements Comparable<Individual>{

    private static long counter = 0;
    private final long id = counter++;
    private String name;

    @Override
    public int compareTo(Individual o) {
        return 0;
    }
}
