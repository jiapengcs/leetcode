package com.jiapengcs.leetcode.easy;

import java.util.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-2
 *
 * 169. Majority Element
 *
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * 分析：找出数组中数量超过一半的元素。
 * 方法一：Hash法，记录每个数出现的次数；
 * 方法二：先排序，要找的元素一定在中间出现；
 * 方法三：先选一个候选者并计数为1，然后向后遍历，如果遇到相同的数则计数加一，否则减一；当计数减为0时就地重选候选者。
 */
public class No_169 {
    // TC: O(n), SC: O(1)
    public static int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate ? 1 : -1);
        }
        return candidate;
    }

    // TC: O(n), SC: O(n)
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return -1;
    }

    // TC: O(nlogn), SC: O(1)
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,2,1,2}));
    }
}
