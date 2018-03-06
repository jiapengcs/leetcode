package com.jiapengcs.leetcode.hard;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-3-6
 *
 * 295. Find Median from Data Stream
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 * For example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 分析：查找数据流中的中位数。(见util.MedianFinder)
 * 维护一个大根堆和一个小根堆，两边轮流加入元素，排序后将堆顶元素加入到另一个堆，
 * 即小根堆将当前最小的元素加入大根堆，大根堆将当前最大的元素加入小根堆。
 * 这样大根堆保存了较小的一半元素，小根堆保存了较大的一半元素，两个堆顶元素代表了中间值的大小。时间复杂度为O(nlogn).
 *
 * 也可以考虑使用List接收所有输入值，然后对List排序。但是本题的题意应该是在数据流接收的中途也要输出中位数，
 * 这样每次输出都要进行排序，时间复杂度为O(n * nlogn).
 */
public class No_295 {

}
