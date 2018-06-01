package jdkStudy.thread.sleepAndWait.Test;

import jdkStudy.thread.sleepAndWait.NotifyThread;
import jdkStudy.thread.sleepAndWait.WaitThread;

/**
 * @author zhou
 * Created on 2018/3/26
 */
public class WaitAndNotifyTest {

    public static void main(String[] args) throws InterruptedException {

        Class lockClass = WaitAndNotifyTest.class;
        Thread waitThread1 = new WaitThread("sleepThread1", lockClass);
        Thread waitThread2 = new WaitThread("sleepThread2", lockClass);

        Thread notifyThread = new NotifyThread("notifyThread", lockClass);
        waitThread1.start();
        waitThread2.start();

        Thread.sleep(2000);
        notifyThread.start();
        System.out.println("test end!");

    }
}
