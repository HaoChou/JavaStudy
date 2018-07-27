package jdkstudy.event;

import java.util.EventObject;

/**
 * @author zhou
 * Created on 2018/5/25
 */
public class MyEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyEvent(Object source) {
        super(source);
    }
}
