package jdkStudy.thread.sleepAndWait;

/**
 * @author zhou
 * Created on 2018/3/27
 */
public class WhileTrueThread extends Thread {

    private Class lockClazz;

    public WhileTrueThread(String threadName, Class lockClazz) {
        this.lockClazz = lockClazz;
        super.setName(threadName);
    }

    @Override
    public void run() {
        synchronized (lockClazz) {
            System.out.println("enter " + super.getName());
            while (true) {
                int a = 1;
            }
        }
    }
}
