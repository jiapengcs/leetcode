package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/9/6.
 *
 * 13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * 分析：首先需要了解罗马数字的格式，用数组存放每个符号对应的值，再依次根据一个符号与它下一个符号的大小关系，来决定加减其对应的值。
 */
public class No_13 {
    public static int romanToInt(String s) {
        char[] buf = s.toCharArray();
        int[] nums = new int[buf.length];
        for (int i = 0; i < buf.length; i++) {
            switch (buf[i]) {
                case 'I': nums[i] = 1; break;
                case 'V': nums[i] = 5; break;
                case 'X': nums[i] = 10; break;
                case 'L': nums[i] = 50; break;
                case 'C': nums[i] = 100; break;
                case 'D': nums[i] = 500; break;
                case 'M': nums[i] = 1000; break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]) {
                sum -= nums[i];
            } else {
                sum += nums[i];
            }
        }
        return (sum + nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XVII"));
        System.out.println(romanToInt("VII"));
        System.out.println(romanToInt("CD"));
    }
}
