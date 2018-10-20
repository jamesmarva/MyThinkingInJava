package designpatterns.command.party;

/**
 * 命令行模式
 * @author james reall008@163.com  10/20/2018
 */
public interface Command {

    public void execute();

    public void undo();
}
