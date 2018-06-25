package jdkstudy.rxjava;


import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

/**
 * @author zhou
 *
 * doOnTerminate 是在onCompleted或者onError 调用 之前 调用
 * doAfterTerminate 是在onCompleted或者onError 调用 之后 调用
 *
 * Created on 2018/5/30
 */
public class OnTerminate {


    public static void main(String[] args) {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                for (int i = 0; i < 5; i++) {
                    if(i == 3){
                        subscriber.onError(new Throwable("EROOR"));
                    }else {
                        subscriber.onNext(i+"");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
                subscriber.onCompleted();
            }
        });


        Subscriber<String> stringSubscriber =  new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error"+e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };


        observable.doOnTerminate(new Action0() {
            @Override
            public void call() {
                System.out.println("doOnTerminate");
            }
        }).doAfterTerminate(
                new Action0() {
                    @Override
                    public void call() {
                        System.out.println("doAfterTerminate");
                    }
                }
        ).subscribe(stringSubscriber);
    }
}
