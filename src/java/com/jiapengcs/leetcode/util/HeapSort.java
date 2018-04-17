package com.jiapengcs.leetcode.util;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-29
 *
 * 堆排序
 */
public class HeapSort {

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length / 2 - 1; i >= 0; i--) {  //初始建堆
            adjustMaxHeap(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);                         //堆顶元素放到最后
            adjustMaxHeap(nums, i, 0);           //从上到下调整
        }
    }

    public static void adjustMaxHeap(int[] nums, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxIndex = index;
        if (left < heapSize && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < heapSize && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            swap(nums, maxIndex, index);
            adjustMaxHeap(nums, heapSize, maxIndex);  //递归调整
        }
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {5,3,1,4,6,2};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
