package designpatterns.command.command7;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class Light {String location = "";

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light is on");
    }

    public void off() {
        System.out.println(location + " light is off");
    }
}
