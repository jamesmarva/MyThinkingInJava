package designpatterns.command.command7;

/**
 * @author james reall008@163.com  10/20/2018
 */
public class StereoOffCommand implements Command {

    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    public void undo() {
        stereo.on();
    }
}
