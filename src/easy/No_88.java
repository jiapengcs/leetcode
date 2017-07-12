package easy;

import java.util.Arrays;

/**
 * Created by Jiapeng on 2017/7/12.
 *
 * Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from
 * nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * 思路：
 *  经典的有序数组归并算法
 */
public class No_88 {
    // TC: O(m+n), SC: O(m+n)
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        int i = 0, j = 0, k = 0;
        for ( ; i < m && j < n; ) {
            tmp[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            tmp[k++] = nums1[i++];
        }
        while (j < n) {
            tmp[k++] = nums2[j++];
        }
        for (int s = 0; s < m + n; s ++) {
            nums1[s] = tmp[s];
        }
    }

    // 摘抄
    // TC: O(m+n), SC: O(1)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1; m--; n--;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{4, 5};
        merge2(nums1, 3, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }
}
