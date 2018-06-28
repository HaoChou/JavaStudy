package designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zhou
 * Created on 2018/6/28
 */
public class MyObserver implements Observer{
    private String name;

    public MyObserver(String name){
        this.name=name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我是观察者"+name+"被通知了参数是"+arg+"，被观察者是："+o.toString());
    }
}
