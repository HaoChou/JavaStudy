package jdkstudy.collection.queue.linkedlist;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author zhou
 * Created on 2018/6/27
 */
public class LinkedListTest {


    public static void main(String[] args) {
        Queue queue = new LinkedList();
        Random r = new Random();

        for(int i =0 ;i<30;i++){
            Integer integer = r.nextInt(20);
            queue.offer(integer);
            System.out.println("已经放入随机数"+integer);
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        System.out.println("-------------------------");
        //实现了Deque接口 可以当作双向队列用
        Deque deque = new LinkedList();
        for (int i=0;i<20;i++)
        {
            deque.offerLast(i);
        }
        while (!deque.isEmpty())
        {
            System.out.println(deque.pollFirst());
            System.out.println(deque.pollLast());
        }

        //linkedList.get()的效率比较低 判断index是否大于总数/2 决定从头开始一个个找或者从尾部开始一个个找。
        //双向链表 可以看内部类Node
        LinkedList linkedList = new LinkedList();
//        linkedList.get();
//        linkedList.addFirst();

    }
}
