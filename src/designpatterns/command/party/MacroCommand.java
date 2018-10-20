package designpatterns.command.party;

/**
 * 命令行模式
 * @
 */
public class MacroCommand implements Command {
	Command[] commands;
 
	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}

	/**
	 * 0~n 顺序执行
	 */
	@Override
	public void execute() {
		for (int i = 0; i < commands.length; i++) {
			commands[i].execute();
		}
	}
 
    /**
     * 按照n~0 的顺序撤销
     * proper undo functionality
     */
	public void undo() {
		for (int i = commands.length -1; i >= 0; i--) {
			commands[i].undo();
		}
	}
}

