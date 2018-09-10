package jdkstudy.cpsb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhou
 * Created on 2018/8/21
 */
public class ChenPeiCaiB {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<Long>> futureList = new ArrayList<>();
        int i =0;
        while (i<100){
            //提交任务并且指定返回结果的future放入list
            Future<Long> future = executorService.submit(new MyThread());
            futureList.add(future);
            i++;
        }


        List<Long> resultList = new ArrayList<>();
        for (Future<Long> future:futureList){
            try {
                //线程未执行完的时候会阻塞  因为线程睡了随机三秒 可以看出来会等直接完才能get到结果
                Long result =future.get();
                resultList.add(result);
                System.out.println("result is "+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("result size is "+resultList.size());


        executorService.shutdown();

    }
}
