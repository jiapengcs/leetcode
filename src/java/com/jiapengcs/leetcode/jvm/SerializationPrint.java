package com.jiapengcs.leetcode.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-16
 */
public class SerializationPrint {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A...");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadA.join();  //先让线程A执行完再执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B...");
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadB.join();  //先让线程B执行完再执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C...");
            }
        });
        threadC.start();
        threadB.start();
        threadA.start();
    }
}
