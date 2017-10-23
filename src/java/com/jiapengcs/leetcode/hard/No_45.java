package com.jiapengcs.leetcode.hard;

/**
 * Created by Jiapeng 2017/10/23.
 *
 * 45. Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * Note:
 * You can assume that you can always reach the last index.
 *
 * 分析：
 * 方法一：思路是遍历的过程不断更新能够到达的最远位置，每当到达这样的位置时，跳数加一。
 * 从前往后遍历，首先我们最远能到达下标为nums[0]的位置（用goal表示），在到达goal的过程中记录能到达的最远位置max，
 * 到达goal时，将goal更新为max，同时跳数加一。
 * 方法二：递归从后往前找能到达末尾的元素中下标最小的元素，这个元素被当做末尾，继续向前查找。（超时）
 */
public class No_45 {
    // TC: O(n), SC: O(1)
    public static int jump(int[] nums) {
        int answer = 0, goal = 0, max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == goal) {
                goal = max;
                answer++;
            }
        }
        return answer;
    }

    // TC: O(n^2), SC: O(1)
    public static int jump2(int[] nums) {
        return search(nums, nums.length - 1);
    }

    public static int search(int[] nums, int target) {
        if (target == 0) return 0;
        int index = target;
        for (int i = target; i >= 0; i--) {
            if (nums[i] + i >= target) {
                index = Math.min(index, i);
            }
        }
        return 1 + search(nums, index);
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
        System.out.println(jump(new int[]{6, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4, 1}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 4}));
        System.out.println(jump(new int[]{2}));
    }
}
