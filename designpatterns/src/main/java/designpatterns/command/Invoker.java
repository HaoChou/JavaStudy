package designpatterns.command;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author zhou
 * Created on 2018/6/29
 */
public class Invoker {

    Vector<Command> commands = new Vector<>();

    public void addCommand(Command command)
    {
        commands.add(command);
    }


    public void doAllCommands()
    {

        Iterator<Command> iterator = commands.iterator();

        while (iterator.hasNext())
        {
            Command command = iterator.next();
            command.execute();
        }
    }
}
