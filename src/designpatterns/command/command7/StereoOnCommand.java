package designpatterns.command.command7;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class StereoOnCommand implements Command{

    private Stereo stereo;

    StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
    }
    public void undo() {
        stereo.off();
    }

}
