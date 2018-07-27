package jdkstudy.event;

import java.util.EventListener;

/**
 * @author zhou
 * Created on 2018/5/25
 */
public class MyListener implements EventListener {

    public void EventActivated(MyEvent me)
    {
        System.out.println("事件已经被触发");
    }
}
