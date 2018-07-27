package jdkstudy.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author zhou
 * Created on 2018/5/29
 */
public class SubscribeIOnTest {

    public static void main(String[] args) {

        Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        threadInfo("OnSubscribe.call()");
                        subscriber.onNext("RxJava");
                    }
                })
                .subscribeOn(getNamedScheduler("1"))
                .doOnSubscribe(() -> threadInfo("info1"))
                .subscribeOn(getNamedScheduler("2"))
                .doOnSubscribe(() -> threadInfo("info2"))
                .subscribe(s -> {
                    threadInfo("info3");
                    System.out.println(s + "-onNext");
                });



        Observable.just("ss")
                .subscribeOn(Schedulers.io())   // ----1---
                .subscribeOn(Schedulers.newThread()) //----2----
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });





        Observable.just("RxJava")
                .map(s -> {
                    threadInfo(".map()-0");
                    return s + "-map0";
                })
                .observeOn(getNamedScheduler("map之前的observeOn"))
                .map(s -> {
                    threadInfo(".map()-1");
                    return s + "-map1";
                })
                .map( s -> {
                    threadInfo(".map()-2");
                    return s + "-map2";
                })
                .observeOn(getNamedScheduler("subscribe之前的observeOn"))
                .subscribe(s -> {
                    threadInfo(".onNext()");
                    System.out.println(s + "-onNext");
                });

    }

    //用指定的名称新建一个线程
    public static Scheduler getNamedScheduler(final String name) {
        return Schedulers.from(Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, name);
            }
        }));
    }

    //打印当前线程的名称
    public static void threadInfo(String caller) {
        System.out.println(caller + " => " + Thread.currentThread().getName());
    }






}
