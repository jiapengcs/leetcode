package com.jiapengcs.leetcode.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-28
 */
public class SerializationRepeatPrint {

    static int count = 0;  //count变量是线程共享的

    private static class PrintThread implements Runnable {
//        static final Object o = new Object();  //可以锁PrintThread的class对象，也可以锁这个对象
        int times;  //这些变量是线程私有的
        int n;
        int flag;

        PrintThread(int times, int n, int flag) {
            this.times = times;
            this.n = n;
            this.flag = flag;
        }

        @Override
        public void run() {
            synchronized (PrintThread.class) {  //保证每次只有一个线程进来
                while (count < times) {
                    if (count % n == flag) {
                        System.out.println(flag + 1);
                        ++count;
                        PrintThread.class.notifyAll();  //轮到此线程输出，输出后count自增，然后唤醒另外的线程
                    } else {
                        try {
                            PrintThread.class.wait();  //没有轮到此线程，先挂起等待别的线程唤醒，记得try catch
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static class AtomicPrintThread implements Runnable {

        private static AtomicInteger count = new AtomicInteger();
        private int times;
        private int flag;

        public AtomicPrintThread(int times, int flag) {
            this.times = times;
            this.flag = flag;
        }

        @Override
        public void run() {
            while (count.get() < times) {
                if (count.get() % 3 == flag) {
                    System.out.println(flag + 1);
                    count.getAndIncrement();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintThread(15000, 3, 0)).start();
        new Thread(new PrintThread(15000, 3, 1)).start();
        new Thread(new PrintThread(15000, 3, 2)).start();

//        //Atomic version
//        new Thread(new AtomicPrintThread(15000, 0)).start();
//        new Thread(new AtomicPrintThread(15000, 1)).start();
//        new Thread(new AtomicPrintThread(15000, 2)).start();
    }
}
