package com.jiapengcs.leetcode.jvm;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-4-8
 */
public class UncaughtExceptionTest {

    static class Task implements Runnable {
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("caught " + e + " in " + t.getName());
            }
        };
        thread.setUncaughtExceptionHandler(handler);    //设置未捕获异常处理器
        thread.start();
    }
}
