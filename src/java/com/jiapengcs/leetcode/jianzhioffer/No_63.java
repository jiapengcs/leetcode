package com.jiapengcs.leetcode.jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-17
 *
 * 63.数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 分析：此题我认为完全可以用List来接收输入值，然后进行排序，复杂度为O(nlogn)。
 * 但是讨论区的解法很有意思，利用一个大根堆和一个小根堆来接收输入（新元素先后经过两个堆的筛选），
 * 一半放入大根堆，一半放入小根堆，这样两个堆的堆顶元素正好是中位数。堆排序的复杂度也为O(nlogn)。
 */
public class No_63 {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });

    public void Insert(Integer num) {
        if ((count & 1) == 1) {
            maxHeap.add(num);
            int outNum = maxHeap.remove();
            minHeap.add(outNum);
        } else {
            minHeap.add(num);
            int outNum = minHeap.remove();
            maxHeap.add(outNum);
        }
        count++;
    }

    public Double GetMedian() {
        if ((count & 1) == 1) {
            return maxHeap.peek() * 1.0;
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        No_63 no_63 = new No_63();
        int[] nums = new int[]{1,2,4,3,7,6,5};
        for (int num : nums) {
            no_63.Insert(num);
            System.out.println(no_63.GetMedian());
        }
    }
}
