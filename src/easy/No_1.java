package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Jiapeng on 2017/5/14.
 */
public class No_1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> buf = new HashMap();
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
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
