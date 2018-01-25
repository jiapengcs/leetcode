package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2018/1/25
 *
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * 分析：
 * 方法一：暴力法，对于每一个位置，分别找到它左、右两边的最高点，再用较小的那个减去它的高度，就是该位置能容纳的水量；
 * 方法二：动态规划，对方法一的改进，即先计算出每个位置的左、右两边的最高点，保存在数组中，再遍历计算每个位置能容纳的水量；
 * 方法三：双指针，对方法二的改进，
 * 用left, right指针分别指向数组的首尾，用两个变量leftMax, rightMax记录左右两边当前出现的最高点，
 * 容纳量取决于较小的高度，所以left和right较小的那个向中间移动，并计算能容纳的水量，如果遇到更大的高度则更新leftMax或者rightMax。
 */
public class No_42 {
    // TC: O(n^2), SC: O(1)
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length-1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    // TC: O(n), SC: O(n)
    public int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for (int i = height.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for (int i = 1; i < height.length-1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    // TC: O(n), SC: O(1)
    public int trap3(int[] height) {
        int ans = 0;
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new No_42().trap2(new int[]{2,0,2}));
        System.out.println(new No_42().trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
