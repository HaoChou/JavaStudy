package designpatterns.command;

/**
 * @author zhou
 * Created on 2018/6/29
 */
public class Receiver {
    private String name;
    public Receiver(String name) {
        this.name=name;
    }

    public void action1()
    {
        System.out.println("i am recevier["+name+"]action1 done");
    }

    public void action2()
    {
        System.out.println("i am recevier["+name+"]action2 done");
    }

}
