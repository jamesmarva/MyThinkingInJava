package designpatterns.command.undo;

/**
 * 命令行模式
 * @author james reall008@163.com  10/20/2018
 */
public class RemoteLoader {


    public static void main(String[] args) {
        RemoteControlUndo remoteControl = new RemoteControlUndo();
        Light livingRoomLight = new Light("Living Room");
        remoteControl.setOnCommands(0, new LightOnCommand(livingRoomLight), new LightOffCommand(livingRoomLight));
        remoteControl.onButtonWasPush(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }
}
