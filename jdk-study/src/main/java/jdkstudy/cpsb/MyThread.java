package jdkstudy.cpsb;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author zhou
 * Created on 2018/8/21
 */
public class MyThread implements Callable<Long>{
    @Override
    public Long call() throws Exception {
        //假设要求所有线程返回Long 这里Long可以换成你要的类型

        Random random = new Random();

        Thread.sleep(random.nextInt(3000));//随机sleep 0-3秒

        return random.nextLong();
    }
}
