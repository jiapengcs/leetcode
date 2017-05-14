package easy;

/**
 * Created by Jiapeng on 2017/5/14.
 *
 * 7. Reverse Integer
 *
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class No_7 {
    public static int reverse(int x) {
        long answer = 0;
        while (x != 0) {
            answer = answer * 10 + (x % 10);
            if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int) answer;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-1000));
        System.out.println(reverse(-1000000009));
    }
}
