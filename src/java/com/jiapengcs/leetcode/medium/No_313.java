package com.jiapengcs.leetcode.medium;

import java.util.PriorityQueue;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-23
 *
 * 313. Super Ugly Number
 *
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers
 * given primes = [2, 7, 13, 19] of size 4.
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000.
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 * 分析：参考264题。
 * 也可以借助优先队列的堆排序，但是末尾有大量无效的元素，暂时没有想到很好的方法控制什么时候停止添加新元素。
 */
public class No_313 {
    // 超时，优先队列末尾有大量无效的元素，没有很好的方法控制什么时候停止添加新元素。
    // 更新，之前的代码中包含heap.contains()方法，该方法会对数组进行遍历，增加了O(n)的复杂度。
    // 删除该方法，改为判断对顶元素是否与刚出堆的元素相同。复杂度降为O(n*k)
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 1 || primes == null || primes.length == 0) {
            return 0;
        }
        int[] dp = new int[n];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(1);
        for (int i = 0; i < n; i++) {
            int out = heap.poll();
            dp[i] = out;
            for (int prime : primes) {
                if ((long) out * prime < 0x7fffffff) {
                    heap.offer(out * prime);
                }
            }
            while (heap.peek() == out) {
                heap.poll();
            }
        }
        return dp[n-1];
    }

    // 摘抄，参考264题的思路
    public int nthSuperUglyNumber1(int n, int[] primes) {
        int ugly[] = new int[n];
        int idx[] = new int[primes.length];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = 0x7fffffff;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ugly[idx[j]] == ugly[i]) idx[j]++;
            }
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {
//        System.out.println(new No_313().nthSuperUglyNumber(850, new int[]{7,13,29,31,37,41,43,53,59,61,71,73,79,83,89,101,107,109,127,131,137,149,151,157,173,227,229,233,239,257}));
//        System.out.println(new No_313().nthSuperUglyNumber(12, new int[]{2,7,13,19}));
        System.out.println(new No_313().nthSuperUglyNumber1(100000, new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251}));
    }
}
