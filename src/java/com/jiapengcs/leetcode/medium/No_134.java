package com.jiapengcs.leetcode.medium;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-22
 *
 * 134. Gas Station
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 * 分析：贪心算法
 * 从i点到达i+1点的剩余油量rest = gas[i] - cost[i]（不能到达的情况下rest为负）;
 * 贪心策略是最后走开销最大(即rest最小)的点，这样我们可以累加前面的rest来补偿这个最大开销。
 */
public class No_134 {
    // TC: O(n), SC: O(1)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length, restSum = 0, restMin = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < len; i++) {
            int rest = gas[i] - cost[i];
            restSum += rest;
            if (rest < restMin) {
                restMin = rest;
                ans = i;
            }
        }
        while (restSum >= 0 && gas[ans] - cost[ans] < 0) {
            ans = (ans + 1) % len;
        }
        return restSum >= 0 ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{6,1,4,3,5}, new int[]{3,8,2,4,2}));
        System.out.println(canCompleteCircuit(new int[]{100, 10, 1000}, new int[]{80, 100, 20}));
        System.out.println(canCompleteCircuit(new int[]{4}, new int[]{5}));
    }
}
