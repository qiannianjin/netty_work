package com.yinghu.yinghu.myThread.queue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {


    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

       // Arrays.asList("");
        User u1 = new User(1,"a",21);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",23);
        User u4 = new User(4,"d",24);
        User u5 = new User(6,"e",25);

        List<User> list=Arrays.asList(u1,u2,u3,u4,u5);

        list.stream().forEach(System.out::println);





   /*
        QueueTest1 queueTest1 = new QueueTest1();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            queueTest1.addQueue();
        },"入队列").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            queueTest1.outQueue();

        },"出队列").start();

*/

    }



}


class QueueTest1{
    //4种队列api
    BlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);

    //添加队列
    public void addQueue(){

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("d"));

    }

    //出队列
    public void outQueue(){
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());


    }













}
class User{

    Integer id;
    String name;
    Integer old;

    User(Integer id,
            String name,
            Integer old){

        this.id=id;
        this.name=name;
        this.old=old;


    }



}