package com.jiapengcs.leetcode.easy;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-23
 *
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * 分析：
 * 方法一：双指针
 * 方法二：二分查找
 */
public class No_167 {
    public int[] twoSum1(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return null;
    }

    //讨论区
    public int[] twoSum2(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum > target) {
                high = leftAndRightToTarget(numbers, low, high, target - numbers[low])[1];
            } else {
                low = leftAndRightToTarget(numbers, low, high, target - numbers[high])[0];
            }
        }
        return null;
    }

    //通过二分查找分别找到左边(大于等于)、右边(小于等于)最接近目标值的元素。
    private int[] leftAndRightToTarget(int[] numbers, int start, int end, int target) {
        int low = start, high = end;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] == target) {
                return new int[]{mid, mid};
            } else if (numbers[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{low, high};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new No_167().twoSum2(new int[]{1, 2, 3, 5, 7, 11, 15}, 9)));
    }
}
