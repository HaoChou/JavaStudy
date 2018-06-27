package jdkstudy.collection.queue.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author zhou
 * Created on 2018/6/27
 */
public class PriorityQueueTest {


    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue();
        Random r = new Random();

        for(int i=0;i<100;i++)
        {
            Integer integer = r.nextInt(20);
            queue.offer(integer);
            System.out.println("已经放入随机数"+integer);
        }


        while (!queue.isEmpty()){

            //peak不移除队头
            System.out.println(queue.poll());
        }
    }
}
