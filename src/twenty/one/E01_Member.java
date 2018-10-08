package twenty.one;

/**
 * @author james reall008@163.com  10/8/2018
 */

@DBTable(name="member")
class E01_Member {

    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLCharacter(value = 15, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    @SQLBoolean
    Boolean isVIP;

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

    public Boolean isVIP() {
        return isVIP;
    }
}