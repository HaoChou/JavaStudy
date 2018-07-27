package jdkstudy.thread.synchronizedkeyword.errortest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * @author zhou
 * Created on 2018/7/4
 */
public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();


    public void addObserver(SetObserver<E> s) {
        synchronized (observers) {
            observers.add(s);
        }
    }


    public void removeObserver(SetObserver<E> s) {
        synchronized (observers) {
            observers.add(s);
        }
    }

    private void notifyElementAdded(E element){
        synchronized (observers) {

            for(SetObserver setObserver:observers){
                setObserver.added(this,element);
            }
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if(added)
            notifyElementAdded(e);
        return added;
    }
}
