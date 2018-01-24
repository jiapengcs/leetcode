package com.jiapengcs.leetcode.jianzhioffer;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-17
 *
 * 33.丑数
 *
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * 分析：暴力破解需要对每个数进行因式分解，十分耗时。由于后面的丑数与前面的丑数有倍数关系，因此可以采用动态规划。
 * 观察发现，第一项为1，第二项为2，...，而每一项的2倍，3倍和5倍都必定是丑数，由于需要从小到大排列，
 * 所以每次计算一项时，我们取前面第x项的2倍，第y项的3倍，第z项的5倍中最小的数作为新产生的丑数。
 */
public class No_33 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] dp = new int[index];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }
        return dp[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(new No_33().GetUglyNumber_Solution(100));
    }
}
