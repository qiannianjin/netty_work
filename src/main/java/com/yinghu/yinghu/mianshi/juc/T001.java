package com.yinghu.yinghu.mianshi.juc;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName T001
 * @Description TODO
 * @Author whz
 * @Date 2023/6/29 16:03
 * Version 1.0
 **/
public class T001 {
   static AtomicInteger b=new AtomicInteger(0);

   static Random r = new Random();
   static MarriagePhaser phaser = new MarriagePhaser();

   static void milliSleep(int milli){
       try{
           TimeUnit.MILLISECONDS.sleep(milli);
       }catch(InterruptedException e){
           e.printStackTrace();
       }
   }

    public static void main(String[] args) {

        //char[] a = "1234567".toCharArray();
        //b.incrementAndGet();
        phaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p"+i)).start();

        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();

    }

    static class MarriagePhaser extends Phaser{

        @Override
        //栅栏被推到的时候自动调用,这个phase是一个计数作用，从0开始，
        //每当registeredParties达到7的时候会推到，这个7是自定义大小的 ，每达到7又开始重置为0了
        protected boolean onAdvance(int phase, int registeredParties) {
           switch (phase){
               case 0:
                   System.out.println("所有人到齐了"+ registeredParties);
                   System.out.println();
                   return false;
               case 1:
                   System.out.println("所有人吃完了"+ registeredParties);
                   System.out.println();
                   return false;
               case 2:
                   System.out.println("所有人离开了"+ registeredParties);
                   System.out.println();
                   return false;
               case 3:
                   System.out.println("婚礼结束！抱抱"+ registeredParties);
                   System.out.println();
                   return true;
               default:
                   return true;
           }

        }

    }


    static  class Person implements Runnable{
        String name;
        public Person(String name){
            this.name = name;

        }
       public void arrive(){
            milliSleep(r.nextInt(1000));
           System.out.printf("%s 到达现场！\n",name);
           //到达并等待继续往前走，因为设置的栅栏的承载数量是7个，所以要等到7个线程都执行完这个方法才继续走
           phaser.arriveAndAwaitAdvance();
       }

        public void eat(){
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场！\n",name);
            phaser.arriveAndAwaitAdvance();
        }
        public void leave(){
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场！\n",name);
            phaser.arriveAndAwaitAdvance();
        }
        public void hug(){
            if(name.equals("新郎")||name.equals("新娘")){
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场！\n",name);
            phaser.arriveAndAwaitAdvance();
        }else {
                phaser.arriveAndDeregister();
                //phaser.register();     //调用这个线程会加一个。
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();


        }
    }


}
