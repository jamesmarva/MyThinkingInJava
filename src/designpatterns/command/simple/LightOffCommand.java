package designpatterns.command.simple;

import designpatterns.command.simple.Command;
import designpatterns.command.simple.Light;

public class LightOffCommand implements Command {
	Light light;
 
	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}
}
