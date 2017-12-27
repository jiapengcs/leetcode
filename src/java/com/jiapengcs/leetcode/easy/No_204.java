package com.jiapengcs.leetcode.easy;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-27
 *
 * 204. Count Primes
 *
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class No_204 {

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(1000));
        System.out.println(countPrimes(10000));
        System.out.println(countPrimes(1500000));
    }
}
