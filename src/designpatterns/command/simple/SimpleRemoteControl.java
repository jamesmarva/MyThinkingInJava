package designpatterns.command.simple;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl() {

    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonPressed() {
        slot.execute();
    }

}
