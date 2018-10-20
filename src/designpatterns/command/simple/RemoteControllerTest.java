package designpatterns.command.simple;

import designpatterns.command.simple.Light;
import designpatterns.command.simple.LightOffCommand;
import designpatterns.command.simple.LightOnCommand;
import designpatterns.command.simple.SimpleRemoteControl;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class RemoteControllerTest {


    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light();

        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.buttonPressed();

        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.buttonPressed();

        GarageDoor garageDoor = new GarageDoor();
//        GarageDoorOpenCommand garageDoorOpenCommand = new
        remoteControl.setCommand(new GarageDoorOpenCommand(garageDoor));
        remoteControl.buttonPressed();


    }

}
