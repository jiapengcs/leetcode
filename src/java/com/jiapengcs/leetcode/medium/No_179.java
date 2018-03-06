package com.jiapengcs.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-26
 *
 * 179. Largest Number
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * 分析：自定义排序
 */
public class No_179 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {  //将能拼成更大的数的元素放在前面
                String num1 = a + b;
                String num2 = b + a;
                return num2.compareTo(num1);
            }
        });
        if ("0".equals(strings[0])) {  //排序后最大元素为"0"，直接返回"0"
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (String str : strings) {
            ans.append(str);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No_179().largestNumber(new int[]{1, 20, 3}));
        System.out.println(new No_179().largestNumber(new int[]{0, 20, 3}));
        System.out.println(new No_179().largestNumber(new int[]{0, 0}));
    }
}
