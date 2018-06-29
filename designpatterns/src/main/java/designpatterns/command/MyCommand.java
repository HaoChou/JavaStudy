package designpatterns.command;


/**
 * @author zhou
 * Created on 2018/6/29
 */
public class MyCommand implements Command{

    private Receiver receiver;
    public MyCommand(Receiver receiver) {
        this.receiver=receiver;
    }

    @Override
    public void execute() {
        receiver.action1();
        receiver.action2();
    }
}
