package designpatterns.command;

/**
 * @author zhou
 *
 * 讲reciver和command组装
 * Created on 2018/6/29
 */
public class CommandClient {


    public Command createCommand(Receiver receiver)
    {
        return new MyCommand(receiver);
    }
}
