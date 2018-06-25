package jdkstudy.thread.sleepAndWait;

/**
 * @author zhou
 * Created on 2018/3/26
 */
public class SleepThread extends Thread {
    private Class lockClazz;
    private int sleepSecond = 0;

    public SleepThread(String threadName, Class lockClazz, int sleepSecond) {
        super.setName(threadName);
        this.lockClazz = lockClazz;
        this.sleepSecond = sleepSecond;
    }

    @Override
    public void run() {
        String threadName = super.getName();
        synchronized (lockClazz) {
            System.out.println("enter " + threadName);
            try {
                System.out.println(threadName + " is sleeping");
                Thread.sleep(sleepSecond * 1000);
                System.out.println(threadName + " is done ");

            } catch (InterruptedException e) {
                System.out.println(threadName + " is be Interrupted!");
                e.printStackTrace();
            }
            System.out.println(threadName + " is being over!");

        }
    }
}
