package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/29
 *
 * 204. Count Primes
 *
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * 分析：
 * 用数组isPrime[]记录n个数是否为素数，如果i为素数，则从i*i开始，将i*i + m*i标记为非素数。
 * 改进：这n个数有一半是偶数，可以直接排除；i*i + m*i的标记过程简化为i*i + 2m*i，因为m为奇数时(m+1)*i可以被2整除。
 */
public class No_204 {
    // TC: O(nlog(logn)), SC: O(n)
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans++;
            }
        }
        return ans;
    }

    // TC: O(nlog(logn)), SC: O(n)
    public static int countPrimes2(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] buf = new boolean[n];
        int ans = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (!buf[i]) {
                for (int j = i * i; j < n; j += 2 * i) {
                    if (!buf[j]) {
                        --ans;
                        buf[j] = true;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes2(2));
        System.out.println(countPrimes2(100));
        System.out.println(countPrimes2(1000));
        System.out.println(countPrimes2(10000000));
    }
}
