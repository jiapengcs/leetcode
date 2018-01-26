package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-23
 *
 * 264. Ugly Number II
 *
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 *
 * 分析：暴力破解需要对每个数进行因式分解，十分耗时。由于后面的丑数与前面的丑数有倍数关系，因此可以采用动态规划。
 * 观察发现，第一项为1，第二项为2，...，而每一项的2倍，3倍和5倍都必定是丑数，由于需要从小到大排列，
 * 所以每次计算一项时，我们取前面第x项的2倍，第y项的3倍，第z项的5倍中最小的数作为新产生的丑数。
 */
public class No_264 {

    public int nthUglyNumber(int n) {
        if (n < 1 || n > 1690) return 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            if (ugly[i] == ugly[p2] * 2) p2++;
            if (ugly[i] == ugly[p3] * 3) p3++;
            if (ugly[i] == ugly[p5] * 5) p5++;
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new No_264().nthUglyNumber(1));
        System.out.println(new No_264().nthUglyNumber(2));
        System.out.println(new No_264().nthUglyNumber(3));
        System.out.println(new No_264().nthUglyNumber(4));
        System.out.println(new No_264().nthUglyNumber(5));
        System.out.println(new No_264().nthUglyNumber(6));
        System.out.println(new No_264().nthUglyNumber(7));
        System.out.println(new No_264().nthUglyNumber(1690));
    }
}
