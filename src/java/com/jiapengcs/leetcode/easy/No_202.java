package com.jiapengcs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-27
 *
 * 202. Happy Number
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 分析：Hash法记录出现过数字，如果重复出现则说明不是Happy Number.
 * 在讨论区看到一种很有创意的解法：因为不是Happy Number的数最终会形成一个死循环。
 * 借鉴链表找环的思路，用快慢指针也可以实现。此方法不需要额外空间。
 */
public class No_202 {
    // TC: *, SC: O(n)
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (!set.add(n)) {
                return false;
            }
            int tmp = 0;
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = tmp;
        }
        return true;
    }

    // TC: *, SC: O(1)
    public static boolean isHappy2(int n) {
        int fast = n, slow = n;
        while (fast != 1 && slow != 1) {
            fast = calculate(calculate(fast));
            slow = calculate(slow);
            if (fast == slow && fast != 1) {
                return false;
            }
        }
        return true;
    }

    public static int calculate(int n) {
        int tmp = 0;
        while (n > 0) {
            tmp += (n % 10) * (n % 10);
            n /= 10;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(isHappy2(1));
        System.out.println(isHappy2(2));
        System.out.println(isHappy2(3));
        System.out.println(isHappy2(4));
        System.out.println(isHappy2(5));
        System.out.println(isHappy2(6));
        System.out.println(isHappy2(7));
        System.out.println(isHappy2(8));
        System.out.println(isHappy2(9));
        System.out.println(isHappy2(10));
        System.out.println(isHappy2(19));
        System.out.println(isHappy2(23));
        System.out.println(isHappy2(49));
    }
}
