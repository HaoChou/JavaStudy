package jdkstudy.thread.sleepAndWait;

import jdkstudy.thread.sleepAndWait.Test.WaitAndNotifyTest;

/**
 * @author zhou
 * Created on 2018/3/27
 */
public class WaitThread extends Thread {
    private Class lockClass;

    public WaitThread(String threadName, Class lockClass) {
        super.setName(threadName);
        this.lockClass = lockClass;
    }

    @Override
    public void run() {
        String threadName = super.getName();
        synchronized (WaitAndNotifyTest.class) {
            System.out.println("enter " + threadName);
            try {
                System.out.println(threadName + " start waiting");
                WaitAndNotifyTest.class.wait();
                System.out.println(threadName + " has stopped waiting,may be notified");
                Thread.sleep(5000);
                System.out.println(threadName + " is done ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " is being over!");
        }
    }
}
