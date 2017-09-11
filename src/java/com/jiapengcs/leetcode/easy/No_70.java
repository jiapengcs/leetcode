package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/9/7.
 *
 * 70. Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * 分析：动态规划，假设到达第n级台阶一共有F(n)种方法。到达第n级台阶有两种情况：从第n-1级爬1级台阶，而到达n-1级共有F(n-1)种方法；
 * 或者从第n-2级爬2级台阶，而到达n-2级共有F(n-2)种方法。所以得到递推式：F(n) = F(n-1) + F(n-2), F(1) = 1, F(2) = 2.
 * 可以采用递归或者迭代两种方法求解。
 */
public class No_70 {
    public static int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // TC: O(n), SC: O(1)
    public static int climbStairs2(int n) {
        int answer = 0, t1 = 1, t2 = 2;
        if (n == 1) return 1;
        if (n == 2) return 2;
        for (int i = 3; i <= n; i++) {
            answer = t1 + t2;
            t1 = t2;
            t2 = answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(1));
        System.out.println(climbStairs1(2));
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs1(4));
        System.out.println(climbStairs1(5));
        System.out.println(climbStairs1(6));
        System.out.println(climbStairs1(7));
        System.out.println(climbStairs1(8));
        System.out.println(climbStairs2(9));
        System.out.println(climbStairs2(60));
    }
}
