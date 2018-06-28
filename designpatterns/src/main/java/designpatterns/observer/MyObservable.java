package designpatterns.observer;

import java.util.Observable;

/**
 * @author zhou
 * Created on 2018/6/28
 */
public class MyObservable  extends Observable{

    private String name;

    public MyObservable(String name){
        this.name=name;
    }

    public void notify(String arg)
    {
        setChanged();//protected方法 只能继承后调用
        notifyObservers(arg);
    }
    @Override
    public String toString(){
        return "【被观察者"+name+"】";
    }
}
