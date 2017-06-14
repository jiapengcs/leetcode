package easy;

/**
 * Created by Jiapeng on 2017/6/12.
 *
 * 476. Number Complement
 *
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
public class No_476 {
    // TC: O(n), SC: O(1)
    public static int findComplement1(int num) {
        int temp = ~num;
        int i = 0, answer = 0;
        while (num > 0) {
            if (temp % 2 != 0) {
                answer += Math.pow(2, i);
            }
            num >>= 1;
            temp >>= 1;
            i ++;
        }
        return answer;
    }

    // TC: O(1), SC: O(1)
    public static int findComplement2(int num) {
        int temp = Integer.highestOneBit(num) - 1;
        return ~num & temp;
    }

    public static void main(String[] args) {
        System.out.println(findComplement2(5));
        System.out.println(findComplement2(1));
        System.out.println(Integer.highestOneBit(-2));
    }
}
