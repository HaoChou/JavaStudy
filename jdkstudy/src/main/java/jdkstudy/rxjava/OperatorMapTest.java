package jdkstudy.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

import java.util.*;

/**
 * @author zhou
 * Created on 2018/5/30
 */
public final class OperatorMapTest<T, R>  implements Observable.Operator<R, T> {

    final Func1<? super T, ? extends R> transformer;

    public OperatorMapTest(Func1<? super T, ? extends R> transformer) {
        this.transformer = transformer;
    }

    @Override
    public Subscriber<? super T> call(final Subscriber<? super R> o) {
        return new Subscriber<T>(o) {

            @Override
            public void onCompleted() {
                o.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                o.onError(e);
            }

            @Override
            public void onNext(T t) {
                try {
                    o.onNext(transformer.call(t));
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, this, t);
                }
            }

        };
    }


    public static void main(String[] args) {
        OperatorMapTest<? extends Number, ? super Exception> test = new OperatorMapTest(new Func1<Integer, Exception>() {
            @Override
            public Exception call(Integer o) {
                return null;
            }
        });
        Map<? super Number, ? super Exception> map = new HashMap<>();
        map.put(new Integer(1), new Exception());
        map.put(new Long(11), new Exception());

        Set<? super Number> objects = map.keySet();
        Iterator<? super Number> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();

            System.out.println(next.getClass());
        }


        List<? extends Number> listExtends = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(2);
        listExtends = listInteger;


        List<? super Number> listSuper = new ArrayList<>();
        listSuper.add(new Integer(1));
        listSuper.add(new Long(1));


        Object object = listSuper.get(0);
        Number number = listExtends.get(0);


    }
}
