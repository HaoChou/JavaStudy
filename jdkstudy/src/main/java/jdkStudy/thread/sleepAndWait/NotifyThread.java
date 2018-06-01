package jdkStudy.thread.sleepAndWait;

import jdkStudy.thread.sleepAndWait.Test.WaitAndNotifyTest;

/**
 * @author zhou
 * Created on 2018/3/27
 */
public class NotifyThread extends Thread {

    Class lockClass;

    public NotifyThread(String threadName, Class lockClass) {
        this.lockClass = lockClass;
        super.setName(threadName);
    }

    @Override
    public void run() {
        synchronized (WaitAndNotifyTest.class) {
            String threadName = super.getName();
            System.out.println("enter " + threadName);
            try {
                System.out.println(threadName + " is sleeping 5000 millisecond ...");
                Thread.sleep(5000);
                WaitAndNotifyTest.class.notifyAll();
                System.out.println(threadName + " do notifyAll!");

//                WaitAndNotifyTest.class.notify(); //notify就通知一个 如果调用notify两次则会通知两个
//                System.out.println("do notify!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " is being over!");
        }
    }
}
