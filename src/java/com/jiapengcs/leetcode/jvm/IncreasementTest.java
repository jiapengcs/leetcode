package com.jiapengcs.leetcode.jvm;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-4-3
 */
public class IncreasementTest {

    private static volatile int count;

    static class IncreaseTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                ++count;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new IncreaseTask());
        Thread b = new Thread(new IncreaseTask());
        Thread c = new Thread(new IncreaseTask());
        a.start();
        b.start();
        c.start();
        a.join();
        b.join();
        c.join();
        System.out.println(count);
    }
}
