package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-2-23
 *
 * 4. Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 *
 * 分析：求两个分别有序的数组的中位数。
 * 类似于快速选择（第215题）的思路，将两个数组看作一个整体，选择它们中间的两个数mid1和mid2（mid1可能等于mid2），
 * 快速选择时，假设选择第k个元素，每次比较舍去较小的数组的前半部分的m个元素，再在剩余的两个数组中选择第k - m个元素。
 */
public class No_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int mid1 = (len1 + len2 + 1) / 2;  //第一个中间数
        int mid2 = (len1 + len2 + 2) / 2;  //第二个中间数
        return (findKth(nums1, 0, len1-1, nums2, 0, len2 - 1, mid1) +
                findKth(nums1, 0, len1-1, nums2, 0, len2 - 1, mid2)) / 2.0;
    }

    private int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (len2 == 0) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;  //取第一个数组的“中间值”
        int j = start2 + Math.min(len2, k / 2) - 1;  //取第二个数组的“中间值”
        if (nums1[i] < nums2[j]) {  //比较大小，舍去较小值所在数组的前半部分
            return findKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        } else {
            return findKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new No_4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }
}
