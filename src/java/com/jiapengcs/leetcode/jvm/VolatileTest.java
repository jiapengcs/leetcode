package com.jiapengcs.leetcode.jvm;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-4-3
 */
public class VolatileTest {

    private volatile boolean isInterrupted;

    class PrintTask implements Runnable {
        @Override
        public void run() {
            while (!isInterrupted) {
                System.out.println("working...");
            }
            System.out.println("Exit!");
        }
    }

    class StopTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                isInterrupted = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();
        for (int i = 0; i < 5; i++) {
            new Thread(test.new PrintTask()).start();
        }
        Thread thread = new Thread(test.new StopTask());
        thread.setDaemon(true);
        thread.start();
    }
}
