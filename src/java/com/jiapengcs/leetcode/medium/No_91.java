package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/16
 *
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 *
 * 分析：爬楼梯问题变种（斐波那契数列）。
 * 借鉴爬楼梯问题的思路，假设到达第n级台阶共有F(n)种走法，到达的情况分两种：
 * 1) 从第n-1级走一步，前n-1级共有F(n-1)种走法；
 * 2) 从第n-2级走两步，前n-2级共有F(n-2)种走法。
 * 所以共有F(n-1) + F(n-2)种走法到达第n级台阶。
 * 此题的区别在于有可能出现：走一步不能到达最后、走两步不能到达最后的情况。
 * 假设此题的输入为"31024"：
 * 1) 最后一位可以表示D，即"3102"+D；
 * 2) 最后两位可以表示X，即"310"+X
 * 即F(n) = F(n-1) + F(n-2)；
 * 对于"3102"：
 * 1) 最后一位可以表示B，即"310"+B；
 * 2) 最后两位"02"不能表示任何字母；
 * 即F(n) = F(n-1)；
 * 对于"1310"：
 * 1) 最后一位不能表示任何字母；
 * 2) 最后两位"10"可以表示J，即"13"+J；
 * 即F(n) = F(n-2)；
 * 对于"1330"：
 * 1) 最后一位不能表示任何字母；
 * 2) 最后两位不能表示任何字母；
 * 即F(n) = 0.
 * 如果第一位为"0"，则直接返回F(n) = 0.
 */
public class No_91 {
    // TC: O(n), SC: O(n)
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int dp[] = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int single = s.charAt(i-1) - '0';
            int pair = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            if (single >= 1 && single <= 9) {
                dp[i] += dp[i-1];
            }
            if (pair >= 10 && pair <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1213"));
        System.out.println(numDecodings("2313"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings(""));
        System.out.println(numDecodings("101"));
        System.out.println(numDecodings("1060"));
        System.out.println(numDecodings("100"));
        System.out.println(numDecodings("99"));
    }
}
