package designpatterns.command.simple;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class GarageDoor {

    public GarageDoor() {
    }

    public void up() {
        System.out.println("Simple Garage Door is Open");
    }

    public void down() {
        System.out.println("Simple Garage Door is Closed");
    }

    public void stop() {
        System.out.println("Simple Garage Door is Stopped");
    }

    public void lightOn() {
        System.out.println("Simple Garage light is on");
    }

    public void lightOff() {
        System.out.println("Simple Garage light is off");
    }


}




