package com.jiapengcs.leetcode.jianzhioffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-17
 *
 * 64.滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 分析：利用双向队列
 * 1. 新元素num[t]的下标从右端入队，并从右往左与队列中的元素比较，移除对应元素小于num[t]的下标，这样可以保持队列中都是较大的元素且降序排列；
 * 2. 再通过下标判断最大值（即左边队首）是否还在窗口中，如果不在则移除；
 * 3. 此时的左端队首是当前窗口的最大值的下标，将对应元素加入到结果集中，重复上述步骤。
 */
public class No_64 {
    // TC: O(n), SC: O(k)
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num == null || size == 0) {
            return ans;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (deque.size() > 0 && num[deque.peekLast()] <= num[i]) {
                deque.removeLast();
            }
            if (deque.size() > 0 && i - deque.peekFirst() >= size) {
                deque.removeFirst();
            }
            deque.addLast(i);
            if (i + 1 >= size) {
                ans.add(num[deque.peekFirst()]);
            }
        }
        return ans;
    }
}
