package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng 2017/10/17.
 *
 * 33. Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * 分析：一个升序排列的数组，以某个未知枢轴进行了翻转。查找这个数组中的元素。依题意为二分查找。
 * 方法一：二分，找到有序的左（右）半部分，检查target是否存在于这个部分的范围内。如果存在，则继续对这部分进行查找；否则对另一部分进行查找。
 * 方法二：先二分查找最小的元素，确定翻转的偏移量。即可当作“升序数组”进行二分查找。查找方法与一般情况一样，只对mid进行偏移后比较，
 * low, high的移动相应地影响到mid偏移后的值。
 * 复杂度均为O(log(n)).
 *
 * 由此题得到的启发：偏移后的有序数组同样可以进行二分查找。以及通过二分查找此类数组的最小元素的方法、偏移量已知的情况下进行二分查找的方法。
 */
public class No_33 {
    // TC: O(log(n)), SC: O(1)
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (nums[mid] <= nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // TC: O(log(n)), SC: O(1)
    public static int search1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int offset = low, n = nums.length;
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int realmid = (mid + offset) % n;
            if (nums[realmid] == target) {
                return realmid;
            }
            if (nums[realmid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 3}, 3));
        System.out.println(search(new int[]{5, 1, 3}, 3));
        System.out.println(search(new int[]{8, 9, 0, 1, 2}, 9));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
    }
}
