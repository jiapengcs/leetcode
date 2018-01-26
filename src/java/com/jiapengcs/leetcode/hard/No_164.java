package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-24
 *
 * 164. Maximum Gap
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 *
 * 分析：本题考察基数排序
 */
public class No_164 {
    public int maximumGap(int[] nums) {
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
        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, nums[i] - nums[i-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_164().maximumGap(new int[]{11, 21, 32, 7, 19, 45, 33, 14, 28}));
    }
}
