package designpatterns.command.command7;


/**
 * @author james reall008@163.com  10/20/2018
 */
public class RemoteControlMain {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Stereo stereo = new Stereo();
        remoteControl.setOnCommands(0, new StereoOffCommand(stereo), new StereoOnCommand(stereo));


        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);


    }


}
