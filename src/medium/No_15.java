package medium;

import java.util.*;

/**
 * Created by Jiapeng on 2017/6/28.
 */
public class No_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (numsList.contains(- (nums[i] + nums[j]))) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(- (nums[i] + nums[j]));
                    answer.add(list);
                }
            }
        }
        System.out.println(numsList);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1, 2, -3, 4, -2}));
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
