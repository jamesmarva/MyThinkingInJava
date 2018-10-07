package twenty.one;

/**
 * @author james reall008@163.com  10/7/2018
 */
@DBTable(name = "MEMBER")
public class Member {

    @SQLString(value = 30)
    String firstName;

    @SQLString(value = 50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true, unique = true))
    String handle;

    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
}
