package com.jiapengcs.leetcode.util;

import java.util.Date;

/**
 * Created by Jiapeng 2017/10/10.
 */
public class Template {
    public static void main(String[] args) {
        long start = new Date().getTime();

        // call function here...
        System.out.println("Hello, world!");

        long stop = new Date().getTime();
        System.out.println("\nCost Time: " + (stop - start) + "ms");
    }
}
