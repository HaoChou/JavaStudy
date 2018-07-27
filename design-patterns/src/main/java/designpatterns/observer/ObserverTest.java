package designpatterns.observer;

/**
 * @author zhou
 * Created on 2018/6/28
 */
public class ObserverTest {

    public static void main(String[] args) {

        MyObserver observer1=new MyObserver("1");
        MyObserver observer2=new MyObserver("2");
        MyObserver observer3=new MyObserver("3");
        MyObserver observer4=new MyObserver("4");


        MyObservable myObservable=new MyObservable("X");

        myObservable.addObserver(observer1);
        myObservable.addObserver(observer2);
        myObservable.addObserver(observer3);
        myObservable.addObserver(observer4);

//        myObservable.setChange();
        myObservable.notify("呵呵");

    }
}
