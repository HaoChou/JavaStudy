package jdkstudy.thread.synchronizedkeyword.errortest;

import java.util.HashSet;

/**
 * @author zhou
 * Created on 2018/7/4
 */
public class SetObserverTest {

    public static void main(String[] args) {
        ObservableSet<Integer> observableSet = new ObservableSet<Integer>(new HashSet<Integer>());

        observableSet.addObserver(new SetObserver<Integer>(){

            //ConcurrentModificationException
//            @Override
//            public void added(ObservableSet s, Integer element) {
//                System.out.println(element);
//                if(element==2){
//                    s.removeObserver(this);
//                }
//            }

            @Override
            public void added(ObservableSet s, Integer element) {
                System.out.println(element);
                if(element==2){
                    s.removeObserver(this);
                }
            }
        });
        for(int i=0;i<100;i++) {
            observableSet.add(i);
        }
    }
}
