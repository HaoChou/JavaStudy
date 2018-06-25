package jdkstudy.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @author zhou
 * Created on 2018/5/29
 */
public class ObservableOperatorsTest {

    public static void main(String[] args) {

        Observable.just("Hello, world!")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " -zhou";
                    }
                })
                .subscribe(s -> System.out.println(s));



        //返回hash值
        Observable.just("Hello, world!")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .subscribe(i -> System.out.println(Integer.toString(i)));

        //lambda
        Observable.just("Hello, world!")
                .map(s -> s.hashCode())
                .subscribe(i -> System.out.println(Integer.toString(i)));


        Observable.just("Hello, world!")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i+1)+1)
                .subscribe(s -> System.out.println(s));


        Observable test =  Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> s) {
                try {
                    s.onNext(run());
                    s.onCompleted();
                } catch (Throwable e) {
                    s.onError(e);
                }
            }

        }).subscribeOn(new Scheduler() {
            @Override
            public Worker createWorker() {
                return null;
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



        test.subscribe(mySuscriber);

    }


    public  static String run()
    {
        return "ssss";
    }
}
