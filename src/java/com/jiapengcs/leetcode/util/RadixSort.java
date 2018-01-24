package com.jiapengcs.leetcode.util;

import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-5
 *
 * 基数排序
 */
public class RadixSort {
    // TC: O(d⋅(n+k))≈O(n), SC: O(n+k)≈O(n)
    public static int[] sort(int[] nums) {
        int max = 0x80000000;
        for (int num : nums) max = Math.max(max, num);
        int len = nums.length;
        int[] bucket = new int[len];
        int exp = 1;
        for (; max / exp > 0; exp *= 10) {
            int[] count = new int[10];
            for (int num : nums) {  //统计分散在(0~9)每个桶中的个数
                int radix = (num / exp) % 10;
                count[radix]++;
            }
            for (int i = 1; i < 10; i++) {  //计算每个桶的右边界
                count[i] += count[i-1];
            }
            for (int i = len-1; i >= 0; i--) {  //将这些数字放到对应的桶中，同时对应桶的边界左移
                int radix = (nums[i] / exp) % 10;
                bucket[count[radix] - 1] = nums[i];
                count[radix]--;
            }
            for (int i = 0; i < len; i++) {  //从桶中取回所有元素
                nums[i] = bucket[i];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{11, 21, 32, 7, 19, 45, 33, 14, 28})));
    }
}
