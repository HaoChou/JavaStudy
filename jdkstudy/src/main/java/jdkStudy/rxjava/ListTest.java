package jdkStudy.rxjava;

import com.sun.tools.javac.util.Log;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;

/**
 * @author zhou
 * Created on 2018/5/30
 */
public class ListTest {
    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
            }
        })
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + "word";
                    }
                })
                .lift(new Observable.Operator<String, String>() {
                    @Override
                    public Subscriber<? super String> call(Subscriber<? super String> o) {

                        return new Subscriber<String>(o) {

                            @Override
                            public void onCompleted() {
                                o.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                o.onError(e);
                            }

                            @Override
                            public void onNext(String t) {
                                try {
                                    o.onNext(t + "myLift");
                                } catch (Throwable e) {
                                    Exceptions.throwOrReport(e, this, t);
                                }
                            }

                        };
                    }
                }).doOnTerminate(new Action0() {
            @Override
            public void call() {
                System.out.println("订阅即将被终止.....................");
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext" + s);
            }
        });
    }
}
