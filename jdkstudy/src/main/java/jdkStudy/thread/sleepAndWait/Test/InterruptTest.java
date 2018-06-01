package jdkStudy.thread.sleepAndWait.Test;

import jdkStudy.thread.sleepAndWait.SleepThread;
import jdkStudy.thread.sleepAndWait.WhileTrueThread;

/**
 * @author zhou
 * Created on 2018/3/27
 */
public class InterruptTest {

    public static void main(String[] args) {
        //测试打断while循环断线程
//        testWhileTrueInterrupted();

        //测试打断sleep线程
        testSleepInterrupted();
    }

    private static void testWhileTrueInterrupted() {
        Thread whileTrueThread1 = new WhileTrueThread("whileTrueThread1", InterruptTest.class);
        Thread whileTrueThread2 = new WhileTrueThread("whileTrueThread2", InterruptTest.class);

        whileTrueThread1.start();
        whileTrueThread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(whileTrueThread1.isInterrupted());
        System.out.println("interrupt");
        whileTrueThread1.interrupt(); // 用interrupt不可以停止whileTrueThread1
//        whileTrueThread1.stop(); // 用stop可以停止whileTrueThread1 而且释放同步资源锁
    }

    private static void testSleepInterrupted() {
        //初始化两个sleep的线程 sleep十秒 用同一个资源锁 。 五秒后打断其中一个
        Thread sleepThread1 = new SleepThread("sleepThread1", InterruptTest.class, 10);
        Thread sleepThread2 = new SleepThread("sleepThread2", InterruptTest.class, 10);

        sleepThread1.start();
        sleepThread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sleepThread1.isInterrupted());

        System.out.println("interrupt");
        sleepThread1.interrupt();
    }
}
