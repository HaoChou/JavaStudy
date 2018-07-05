package jdkstudy.thread.synchronizedkeyword.errortest;

/**
 * @author zhou
 * Created on 2018/7/4
 */
public interface SetObserver<E> {

    public void added(ObservableSet s , E element);
}
