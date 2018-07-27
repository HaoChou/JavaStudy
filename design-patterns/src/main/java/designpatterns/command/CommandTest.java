package designpatterns.command;

/**
 * @author zhou
 * Created on 2018/6/29
 */
public class CommandTest {

    public static void main(String[] args) {

        Receiver receiver1=new Receiver("1");
        Receiver receiver2=new Receiver("2");

        Command c1=new MyCommand(receiver1);
        Command c2=new MyCommand(receiver2);

        Invoker invoker = new Invoker();
        invoker.addCommand(c1);
        invoker.addCommand(c2);


        invoker.doAllCommands();

    }
}
