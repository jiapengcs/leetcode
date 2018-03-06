package com.jiapengcs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-3
 *
 * 448. Find All Numbers Disappeared in an Array
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 *
 * 分析：给定大小为n的数组，元素大小在1～n之间，找出没有出现的元素。
 * 此类题目元素大小没有超过数组大小，可以将元素与下标关联，改变元素的大小或者符号来记录信息。
 */
public class No_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.abs(nums[i]) - 1;
            if (nums[tmp] > 0) {
                nums[tmp] = (~nums[tmp] + 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
