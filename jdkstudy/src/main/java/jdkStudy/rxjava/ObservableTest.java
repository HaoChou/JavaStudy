package jdkStudy.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * @author zhou
 * Created on 2018/5/29
 */
public class ObservableTest {

    public static void main(String[] args) {

        Observable.error(new NullPointerException("hehe"))
                .subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                System.out.println("a");

                System.out.println(o.toString());

            }
        });

        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("Hello, world!");
                subscriber.onCompleted();

            }

        });


        Subscriber<String> mySuscriber = new Subscriber<String>() {
            public void onCompleted() {
                System.out.println("Hello, world onCompleted!");
            }

            public void onError(Throwable e) {
                if(e instanceof  Exception)
                {
                    ((Exception)e).printStackTrace();
                }
            }

            public void onNext(String s) {
//                Integer i = Integer.valueOf("23s");
                System.out.println(s);
            }
        };


        //一旦mySubscriber订阅了myObservable， myObservable就是调用mySubscriber对象的onNext和onComplete方法，mySubscriber就会打印出Hello World！

        myObservable.subscribe(mySuscriber);




        Observable<String> myObservableJust = Observable.just("Hello, world2!");

        Action1<String> onNextAction = new Action1<String>() {
            public void call(String s) {
                System.out.println(s);
            }
        };
        myObservableJust.subscribe(onNextAction);








        Observable.just("Hello, world3!")
                .subscribe(s -> System.out.println(s));

    }
}
