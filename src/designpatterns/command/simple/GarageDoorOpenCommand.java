package designpatterns.command.simple;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class GarageDoorOpenCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        this.garageDoor.lightOn();
    }
}
