package com.jiapengcs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiapeng on 2017/6/27.
 *
 * 624. Maximum Distance in Arrays
 *
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different
 * arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be
 * their absolute difference |a-b|. Your task is to find the maximum distance.
 *
 * Example 1:
 *  Input:
 *  [[1,2,3],
 *  [4,5],
 *  [1,2,3]]
 *  Output: 4
 * Explanation:
 *  One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *
 * Note:
 *  1.Each given array will have at least 1 number. There will be at least two non-empty arrays.
 *  2.The total number of the integers in all the m arrays will be in the range of [2, 10000].
 *  3.The integers in the m arrays will be in the range of [-10000, 10000].
 *
 *  思路：
 *  因为两个最大、最小值来自不同的数组，不能简单地遍历查找所有元素的最大、最小值，应当用每个数组的最大、最小值与当前最大、最小值计算。
 */
public class No_624 {
    // TC: O(n), SC: O(1)
    public static int maxDistance(List<List<Integer>> arrays) {
        int answer = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        for (int i = 1; i < arrays.size(); i ++) {
            answer = Math.max(answer, Math.abs(min - arrays.get(i).get(arrays.get(i).size() - 1)));
            answer = Math.max(answer, Math.abs(max - arrays.get(i).get(0)));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1); //1
        list1.add(4); //5
        List<Integer> list2 = new ArrayList<>();
        list2.add(0); //3
        list2.add(5); //4
        List<List<Integer>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        System.out.println(maxDistance(input));
    }
}
