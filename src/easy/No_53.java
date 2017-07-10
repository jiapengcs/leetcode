package easy;

/**
 * Created by Jiapeng on 2017/7/10.
 *
 * 53. Maximum Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * 思路：
 *  从头开始累加，用sum记录当前和，同时用answer记录sum出现的最大值，当sum小于0时认为当前序列是无贡献的，舍去，sum置为0，
 *  对剩下元素重新开始累加。
 */
public class No_53 {
    // TC: O(n), SC: O(1)
    public static int maxSubArray(int[] nums) {
        int answer = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            answer = Math.max(answer, sum);
            sum = sum < 0 ? 0 : sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
