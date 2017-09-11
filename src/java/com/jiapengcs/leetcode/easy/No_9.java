package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/9/5.
 *
 * 9. Palindrome Number
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * 分析：直接reverse，然后与原值比较。考虑到可能溢出，reverse后的值声明为long类型。
 */
public class No_9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        long reverse = 0;
        int t = x;
        while(t != 0) {
            reverse = reverse * 10 + t % 10;
            t /= 10;
        }
        return (reverse == x);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000000001));
        System.out.println(isPalindrome(-2147447412));
        System.out.println(isPalindrome(0));
    }
}
