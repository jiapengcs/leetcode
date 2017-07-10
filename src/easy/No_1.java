package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Jiapeng on 2017/5/14.
 *
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class No_1 {
    // Hash table costs O(1) to search => TC: O(n), SC: O(n)
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> buf = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (buf.containsKey(target - nums[i])) {
                answer[0] = buf.get(target - nums[i]);
                answer[1] = i;
                return answer;
            } else {
                buf.put(nums[i], i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 2, 7};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
