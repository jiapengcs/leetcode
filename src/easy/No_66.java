package easy;

import java.util.Arrays;

/**
 * Created by Jiapeng on 2017/7/11.
 */
public class No_66 {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) break;
        }
        if (digits[0] == 0) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            for (int i = 0; i < digits.length - 1; i ++) {
                tmp[i + 1] = digits[i];
            }
            return tmp;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 8})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
    }
}
