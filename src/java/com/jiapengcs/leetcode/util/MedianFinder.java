package com.jiapengcs.leetcode.util;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 求数据流的中位数
 * 同63.数据流中的中位数，295. Find Median from Data Stream.
 *
 * 分析：查找数据流中的中位数。
 * 维护一个大根堆和一个小根堆，两边轮流加入元素，排序后将堆顶元素加入到另一个堆，
 * 即小根堆将当前最小的元素加入大根堆，大根堆将当前最大的元素加入小根堆。
 * 这样大根堆保存了较小的一半元素，小根堆保存了较大的一半元素，两个堆顶元素代表了中间值的大小。时间复杂度为O(nlogn).
 *
 * 也可以考虑使用List接收所有输入值，然后对List排序。但是本题的题意应该是在数据流接收的中途也要输出中位数，
 * 这样每次输出都要进行排序，时间复杂度为O(n * nlogn).
 */
class MedianFinder {

    private PriorityQueue<Integer> maxHeap = null;
    private PriorityQueue<Integer> minHeap = null;
    private int count = 0;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if ((++count & 1) == 1) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
    }

    public double findMedian() {
        if ((count & 1) == 1) {
            return minHeap.peek() * 1.0;
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
