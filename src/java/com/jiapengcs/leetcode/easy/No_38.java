package com.jiapengcs.leetcode.easy;

/**
 * Created by Jiapeng on 2017/9/6.
 *
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 * Input: 4
 * Output: "1211"
 *
 * 分析：将字符串转为char数组，依次计算每个数字的连续出现的次数，并把次数和数字压入StringBuilder，然后转为字符串。重复n次。
 */
public class No_38 {
    // TC: O(n^2), SC: O(n)
    public static String countAndSay(int n) {
        String answer = "1";
        StringBuilder builder = new StringBuilder();
        while (--n > 0) {
            int count = 0;
            char pre = 0;
            for (int i = 0; i < answer.length(); i++) {
                if (pre == 0 || answer.charAt(i) == pre) {
                    count++;
                    pre = answer.charAt(i);
                } else {
                    builder.append(count).append(pre);
                    pre = answer.charAt(i);
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            answer = builder.toString();
            builder.setLength(0);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
        System.out.println(countAndSay(9));
        System.out.println(countAndSay(20));
    }
}
