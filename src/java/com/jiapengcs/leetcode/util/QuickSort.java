package com.jiapengcs.leetcode.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/30
 *
 * 快速排序
 */
public class QuickSort {

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int low = start, high = end, pivot = nums[end];
            while (low < high) {
                if (nums[low++] > pivot) {
                    swap(nums, --low, --high);
                }
            }
            swap(nums, low, end);
            quickSort(nums, start, low-1);
            quickSort(nums, low+1, end);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(100000000);
        }
        long start = System.currentTimeMillis();
//        sort(nums);
        Arrays.sort(nums);
        long end = System.currentTimeMillis();

//        System.out.println(Arrays.toString(nums));
        System.out.println(end - start);
    }
}
