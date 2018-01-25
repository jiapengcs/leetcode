package com.jiapengcs.leetcode.medium;

/**
 * Created by Jiapeng on 2017/6/27.
 *
 * 11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * 思路：
 * 用两个指针从两端开始向中间靠拢，如果左端线段短于右端，那么左端右移，反之右端左移，直到左右两端移到中间重合，记录这个过程中每一次组成
 * 木桶的容积，返回其中最大的。（想想这样为何合理？）当左端线段L小于右端线段R时，我们把L右移，这时舍弃的是L与右端其他线段（R-1, R-2,
 * ...）组成的木桶，这些木桶是没必要判断的，因为这些木桶的容积肯定都没有L和R组成的木桶容积大。
 * https://discuss.leetcode.com/topic/3462/yet-another-way-to-see-what-happens-in-the-o-n-algorithm
 */
public class No_11 {
    // TC: O(n), SC: O(1)
    public static int maxArea(int[] height) {
        int answer = 0, l = 0, r = height.length - 1;
        while (l < r) {
            answer = Math.max(answer, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{4, 5, 1, 2, 1, 3, 1, 2, 2}));
    }
}
