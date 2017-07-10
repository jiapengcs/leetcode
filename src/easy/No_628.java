package easy;

import java.util.Arrays;

/**
 * Created by Jiapeng on 2017/6/27.
 *
 * 628. Maximum Product of Three Numbers
 *
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 *  Input: [1,2,3]
 *  Output: 6
 * Example 2:
 *  Input: [1,2,3,4]
 *  Output: 24
 *
 * Note:
 *  The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 *  Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class No_628 {
    // TC: O(nlog(n)), SC: O(1)
    public static int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int product1 = nums[0] * nums[1] * nums[nums.length - 1];
        int product2 = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        return product1 > product2 ? product1 : product2;
    }

    // 摘抄
    // TC: O(n), SC: O(1)
    public static int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct1(new int[]{1, 2, 3, 4}));
        System.out.println(maximumProduct1(new int[]{-4, -3, -2, 1, 2, 60}));
    }
}
