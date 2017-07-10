package easy;

import java.util.Arrays;

/**
 * Created by Jiapeng on 2017/7/10.
 *
 * 27. Remove Element
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * 思路：
 *  与No_26类似。
 */
public class No_27 {
    // TC: O(n), SC: O(1)
    public static int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == val) {
                continue;
            }
            nums[ans++] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
