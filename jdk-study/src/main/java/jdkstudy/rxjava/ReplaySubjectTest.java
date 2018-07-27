package jdkstudy.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.ReplaySubject;

/**
 * @author zhou
 * Created on 2018/5/30
 */
public class ReplaySubjectTest {

    public static void main(String[] args) {

        ReplaySubject<String> subject = ReplaySubject.create();

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                for (int i = 0; i < 5; i++) {
                    if(i == 3){
//                        subscriber.onError(new Throwable("EROOR"));
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

        observable.subscribe(subject);



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


        subject.subscribe(stringSubscriber);
    }
}
